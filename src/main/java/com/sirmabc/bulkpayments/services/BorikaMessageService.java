package com.sirmabc.bulkpayments.services;

import com.sirmabc.bulkpayments.communicators.BorikaClient;
import com.sirmabc.bulkpayments.exceptions.AppException;
import com.sirmabc.bulkpayments.util.*;
import com.sirmabc.bulkpayments.util.xmlsigner.XMLSigner;
import montranMessage.montran.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static com.sirmabc.bulkpayments.util.Header.X_MONTRAN_RTP_MESSAGE_SEQ;

@Service
public class BorikaMessageService {

    private static final Logger logger = LoggerFactory.getLogger(BorikaMessageService.class);

    @Value("${keystore.sign.path}")
    private String keyStorePath;

    @Value("${keystore.sign.password}")
    private String keyStorePassword;
    @Value("${keystore.sign.alias}")
    private String keyStoreAlias;

    private final BorikaClient borikaClient;

    private final Properties properties;

    private XMLSigner xmlSigner;

    @Autowired
    public BorikaMessageService(Properties properties, BorikaClient borikaClient, XMLSigner xmlSigner) {
        this.borikaClient = borikaClient;
        this.properties = properties;
        this.xmlSigner = xmlSigner;
    }

    @Async
    public void asyncStartProcessingMessage(HttpResponse<String> response) throws AppException {
        logger.info("Processing message asynchronously..." + Thread.currentThread().getName());

        try {
            Map<String, List<String>> headers = response.headers().map();
            acknowledge(headers);

            Message message = XMLFileHelper.deserializeXml(response.body(), Message.class);
            //DefinedMessage definedMessage = definedMessageService.define(headers, message, response.body());

            DatabaseService.saveBulkMessage(message.getAppHdr(), response.body(), headers.get(Header.X_MONTRAN_RTP_MESSAGE_SEQ).get(0));
            CodesPacs002 codesPacs002 = BulkMessageValidator.validate(message.getAppHdr(), headers, response.body());

            //definedMessage.processMessage(codesPacs002);
            if (codesPacs002 == CodesPacs002.OK01) {
                XMLFileHelper.objectToXmlFile(message, properties.getBulkMsgsDirPath());
            }
        } catch (Exception e) {
            logger.error(Thread.currentThread().getName() + "threw an error: " + e.getMessage(), e);
            throw new AppException(e.getMessage(), e);
        }
    }

    /*@Async()
    public void asyncStartProcessingParticipantsMessage(HttpResponse<String> response) throws AppException {
        logger.info("asyncStartProcessingParticipantsMessage..." + Thread.currentThread().getName());

        try {
            Map<String, List<String>> headers = response.headers().map();
            Message message = XMLFileHelper.deserializeXml(response.body(), Message.class);
            DefinedMessage definedMessage = definedMessageService.define(headers, message, response.body());

            definedMessage.saveMessage();
            CodesPacs002 pacs002Code = definedMessage.isValidAppHdr();

            definedMessage.processMessage(pacs002Code);
        } catch (Exception e) {
            logger.error(Thread.currentThread().getName() + "threw an error: " + e.getMessage(), e);
            throw new AppException(e.getMessage(), e);
        }
    }*/

    private void acknowledge(Map<String, List<String>> headers) throws IOException, InterruptedException {
        logger.info("Acknowledging headers...");

        String msgSeq = headers.get(X_MONTRAN_RTP_MESSAGE_SEQ.header).get(0);
        borikaClient.postAcknowledge(msgSeq);
    }
}
