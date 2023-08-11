package com.sirmabc.bulkpayments.util;

import com.sirmabc.bulkpayments.exceptions.AppException;
import com.sirmabc.bulkpayments.persistance.entities.PropertiesEntity;
import com.sirmabc.bulkpayments.persistance.repositories.PropertiesRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Properties {
    private PropertiesEntity borikaUrl;

    private PropertiesEntity accValidUrl;

    private PropertiesEntity accValidBranch;

    private PropertiesEntity accUserId;

    private PropertiesEntity accValidMsgId;

    private PropertiesEntity accValidEntity;

    private PropertiesEntity rtpChannel;

    private PropertiesEntity rtpVersion;

    private PropertiesEntity fcUrl;

    private PropertiesEntity bizMsgIdr;

    private PropertiesEntity boricaKeyStorePath;

    private PropertiesEntity boricaKeyStorePassword;

    private PropertiesEntity boricaKeyStoreAlias;

    private PropertiesEntity boricaKeyPassword;

    private PropertiesEntity sbcKeyStorePath;

    private PropertiesEntity sbcKeyStorePassword;

    private PropertiesEntity sbcKeyStoreAlias;

    private PropertiesEntity sbcKeyPassword;

    private PropertiesEntity incmgBulkPacs008Path;

    private PropertiesEntity outgngBulkPacs008Path;

    private PropertiesEntity incmgBulkPacs002Path;

    private PropertiesEntity outgngBulkPacs002Path;

    private PropertiesEntity outgngBulkInProgressPath;

    private PropertiesEntity outgngBulkProcessedPath;

    private PropertiesEntity incmgBulkPacs004Path;

    private PropertiesEntity outgngBulkPacs004Path;

    private PropertiesEntity incmgBulkCamt056Path;

    private PropertiesEntity outgngBulkCamt056Path;

    private final PropertiesRepository repository;

    @Autowired
    public Properties(PropertiesRepository repository){
        this.repository = repository;
    }

    private static final Logger logger = LoggerFactory.getLogger(Properties.class);

    @PostConstruct
    public void postConstruct () throws AppException {
        logger.info("Getting properties from the database");

        try {
            borikaUrl = repository.findByName("borikaUrl");
            logger.info("Borica url: " + borikaUrl.getValue());

            accValidUrl = repository.findByName("accValidUrl");
            logger.info("Account validation service url: " + accValidUrl.getValue());

            accValidBranch = repository.findByName("accValidBranch");
            logger.info("Account validation service branch: " + accValidBranch.getValue());

            accUserId = repository.findByName("accUserId");
            logger.info("Account validation service userId: " + accUserId.getValue());

            // accValidMsgId = repository.findByName("accValidMsgId");
            // logger.info("Account validation service url: " + accValidMsgId.getValue());

            accValidEntity = repository.findByName("accValidEntity");
            logger.info("Account validation service entity: " + accValidEntity.getValue());

            rtpChannel = repository.findByName("rtpChannel");
            logger.info("Borica rtp channel (BIC) of institution: " + rtpChannel.getValue());

            rtpVersion = repository.findByName("rtpVersion");
            logger.info("Borica rtp version: " + rtpVersion.getValue());

            fcUrl = repository.findByName("fcUrl");
            logger.info("Flex cube service url: " + fcUrl.getValue());

            bizMsgIdr = repository.findByName("bizMsgIdr");
            logger.info("Flex cube bizMsgIdr url: " + bizMsgIdr.getValue());

            boricaKeyStorePath = repository.findByName("boricaKeyStorePath");
            logger.info("JKS borica keystore file path: " + boricaKeyStorePath.getValue());

            boricaKeyStorePassword = repository.findByName("boricaKeyStorePassword");
            logger.info("JKS borica password: " + boricaKeyStorePassword.getValue());

            boricaKeyStoreAlias = repository.findByName("boricaKeyStoreAlias");
            logger.info("JKS borica alias: " + boricaKeyStoreAlias.getValue());

            boricaKeyPassword = repository.findByName("boricaKeyPassword");
            logger.info("JKS borica key password: " + boricaKeyPassword.getValue());

            sbcKeyStorePath = repository.findByName("sbcKeyStorePath");
            logger.info("JKS sbc keystore file path: " + sbcKeyStorePath.getValue());

            sbcKeyStorePassword = repository.findByName("sbcKeyStorePassword");
            logger.info("JKS sbc password: " + sbcKeyStorePassword.getValue());

            sbcKeyStoreAlias = repository.findByName("sbcKeyStoreAlias");
            logger.info("JKS sbc alias: " + sbcKeyStoreAlias.getValue());

            sbcKeyPassword = repository.findByName("sbcKeyPassword");
            logger.info("JKS sbc key password: " + sbcKeyPassword.getValue());

            incmgBulkPacs008Path = repository.findByName("incmgBulkPacs008Path");
            logger.info("Incoming pacs.008 bulk messages directory path: " + incmgBulkPacs008Path.getValue());

            outgngBulkPacs008Path = repository.findByName("outgngBulkPacs008Path");
            logger.info("Outgoing pacs.008 bulk messages directory path: " + outgngBulkPacs008Path.getValue());

            incmgBulkPacs002Path = repository.findByName("incmgBulkPacs002Path");
            logger.info("Incoming pacs.002 bulk messages directory path: " + incmgBulkPacs002Path.getValue());

            outgngBulkPacs002Path = repository.findByName("outgngBulkPacs002Path");
            logger.info("Outgoing pacs.002 bulk messages directory path: " + outgngBulkPacs002Path.getValue());

            outgngBulkInProgressPath = repository.findByName("outgngBulkInProgressPath");
            logger.info("Outgoing bulk messages in progress directory path: " + outgngBulkInProgressPath.getValue());

            outgngBulkProcessedPath = repository.findByName("outgngBulkProcessedPath");
            logger.info("Outgoing processed bulk messages directory path: " + outgngBulkProcessedPath.getValue());

            incmgBulkPacs004Path = repository.findByName("incmgBulkPacs004Path");
            logger.info("Outgoing processed bulk messages directory path: " + incmgBulkPacs004Path.getValue());

            outgngBulkPacs004Path = repository.findByName("outgngBulkPacs004Path");
            logger.info("Outgoing processed bulk messages directory path: " + outgngBulkPacs004Path.getValue());

            incmgBulkCamt056Path = repository.findByName("incmgBulkCamt056Path");
            logger.info("Outgoing processed bulk messages directory path: " + incmgBulkCamt056Path.getValue());

            outgngBulkCamt056Path = repository.findByName("outgngBulkCamt056Path");
            logger.info("Outgoing processed bulk messages directory path: " + outgngBulkCamt056Path.getValue());
        } catch (Exception e) {
            throw new AppException(e.getMessage(), e);
        }
    }

    public String getBorikaUrl() {
        // TODO: Uncomment
        //return borikaUrl.getValue();
        return "http://172.16.51.196:8888/certservice/api/borica";
    }

    public void setBorikaUrl(PropertiesEntity borikaUrl) {
        this.borikaUrl = borikaUrl;
    }

    public String getAccValidUrl() {
        return accValidUrl.getValue();
    }

    public void setAccValidUrl(PropertiesEntity accValidUrl) {
        this.accValidUrl = accValidUrl;
    }

    public String getAccValidBranch() {
        return accValidBranch.getValue();
    }

    public void setAccValidBranch(PropertiesEntity accValidBranch) {
        this.accValidBranch = accValidBranch;
    }

    public String getAccUserId() {
        return accUserId.getValue();
    }

    public void setAccUserId(PropertiesEntity accUserId) {
        this.accUserId = accUserId;
    }

    public String getAccValidMsgId() {
        return accValidMsgId.getValue();
    }

    public void setAccValidMsgId(PropertiesEntity accValidMsgId) {
        this.accValidMsgId = accValidMsgId;
    }

    public String getAccValidEntity() {
        return accValidEntity.getValue();
    }

    public void setAccValidEntity(PropertiesEntity accValidEntity) {
        this.accValidEntity = accValidEntity;
    }

    public String getRtpChannel() {
        return rtpChannel.getValue();
    }

    public void setRtpChannel(PropertiesEntity rtpChannel) {
        this.rtpChannel = rtpChannel;
    }

    public String getRtpVersion() {
        return rtpVersion.getValue();
    }

    public void setRtpVersion(PropertiesEntity rtpVersion) {
        this.rtpVersion = rtpVersion;
    }

    public String getFcUrl() {
        return fcUrl.getValue();
    }

    public void setFcUrl(PropertiesEntity fcUrl) {
        this.fcUrl = fcUrl;
    }

    public String getBizMsgIdr() {
        return bizMsgIdr.getValue();
    }

    public void setBizMsgIdr(PropertiesEntity bizMsgIdr) {
        this.bizMsgIdr = bizMsgIdr;
    }

    public String getBoricaKeyStorePath() {
        return boricaKeyStorePath.getValue();
    }

    public void setBoricaKeyStorePath(PropertiesEntity boricaKeyStorePath) {
        this.boricaKeyStorePath = boricaKeyStorePath;
    }

    public String getBoricaKeyStorePassword() {
        return boricaKeyStorePassword.getValue();
    }

    public void setBoricaKeyStorePassword(PropertiesEntity boricaKeyStorePassword) {
        this.boricaKeyStorePassword = boricaKeyStorePassword;
    }

    public String getBoricaKeyStoreAlias() {
        return boricaKeyStoreAlias.getValue();
    }

    public void setBoricaKeyStoreAlias(PropertiesEntity boricaKeyStoreAlias) {
        this.boricaKeyStoreAlias = boricaKeyStoreAlias;
    }

    public String getBoricaKeyPassword() {
        return boricaKeyPassword.getValue();
    }

    public void setBoricaKeyPassword(PropertiesEntity boricaKeyPassword) {
        this.boricaKeyPassword = boricaKeyPassword;
    }

    public String getSbcKeyStorePath() {
        return sbcKeyStorePath.getValue();
    }

    public void setSbcKeyStorePath(PropertiesEntity sbcKeyStorePath) {
        this.sbcKeyStorePath = sbcKeyStorePath;
    }

    public String getSbcKeyStorePassword() {
        return sbcKeyStorePassword.getValue();
    }

    public void setSbcKeyStorePassword(PropertiesEntity sbcKeyStorePassword) {
        this.sbcKeyStorePassword = sbcKeyStorePassword;
    }

    public String getSbcKeyStoreAlias() {
        return sbcKeyStoreAlias.getValue();
    }

    public void setSbcKeyStoreAlias(PropertiesEntity sbcKeyStoreAlias) {
        this.sbcKeyStoreAlias = sbcKeyStoreAlias;
    }

    public String getSbcKeyPassword() {
        return sbcKeyPassword.getValue();
    }

    public void setSbcKeyPassword(PropertiesEntity sbcKeyPassword) {
        this.sbcKeyPassword = sbcKeyPassword;
    }

    public String getIncmgBulkPacs008Path() {
        return incmgBulkPacs008Path.getValue();
    }

    public void setIncmgBulkPacs008Path(PropertiesEntity incmgBulkPacs008Path) {
        this.incmgBulkPacs008Path = incmgBulkPacs008Path;
    }

    public String getOutgngBulkPacs008Path() {
        return outgngBulkPacs008Path.getValue();
    }

    public void setOutgngBulkPacs008Path(PropertiesEntity outgngBulkPacs008Path) {
        this.outgngBulkPacs008Path = outgngBulkPacs008Path;
    }

    public String getIncmgBulkPacs002Path() {
        return incmgBulkPacs002Path.getValue();
    }

    public void setIncmgBulkPacs002Path(PropertiesEntity incmgBulkPacs002Path) {
        this.incmgBulkPacs002Path = incmgBulkPacs002Path;
    }

    public String getOutgngBulkPacs002Path() {
        return outgngBulkPacs002Path.getValue();
    }

    public void setOutgngBulkPacs002Path(PropertiesEntity outgngBulkPacs002Path) {
        this.outgngBulkPacs002Path = outgngBulkPacs002Path;
    }

    public String getOutgngBulkInProgressPath() {
        return outgngBulkInProgressPath.getValue();
    }

    public void setOutgngBulkInProgressPath(PropertiesEntity outgngBulkInProgressPath) {
        this.outgngBulkInProgressPath = outgngBulkInProgressPath;
    }

    public String getOutgngBulkProcessedPath() {
        return outgngBulkProcessedPath.getValue();
    }

    public void setOutgngBulkProcessedPath(PropertiesEntity outgngBulkProcessedPath) {
        this.outgngBulkProcessedPath = outgngBulkProcessedPath;
    }

    public String getIncmgBulkPacs004Path() {
        return incmgBulkPacs004Path.getValue();
    }

    public void setIncmgBulkPacs004Path(PropertiesEntity incmgBulkPacs004Path) {
        this.incmgBulkPacs004Path = incmgBulkPacs004Path;
    }

    public String getOutgngBulkPacs004Path() {
        return outgngBulkPacs004Path.getValue();
    }

    public void setOutgngBulkPacs004Path(PropertiesEntity outgngBulkPacs004Path) {
        this.outgngBulkPacs004Path = outgngBulkPacs004Path;
    }

    public String getIncmgBulkCamt056Path() {
        return incmgBulkCamt056Path.getValue();
    }

    public void setIncmgBulkCamt056Path(PropertiesEntity incmgBulkCamt056Path) {
        this.incmgBulkCamt056Path = incmgBulkCamt056Path;
    }

    public String getOutgngBulkCamt056Path() {
        return outgngBulkCamt056Path.getValue();
    }

    public void setOutgngBulkCamt056Path(PropertiesEntity outgngBulkCamt056Path) {
        this.outgngBulkCamt056Path = outgngBulkCamt056Path;
    }

    public List<String> getAllOutgngBulkMsgsDirPaths() {
        List<String> outgngBulkPaths = new ArrayList<>();
        outgngBulkPaths.add(getOutgngBulkPacs008Path());
        outgngBulkPaths.add(getOutgngBulkPacs002Path());
        outgngBulkPaths.add(getOutgngBulkPacs004Path());
        outgngBulkPaths.add(getOutgngBulkCamt056Path());

        // TODO: Finish for the rest of the messages

        return outgngBulkPaths;
    }
}
