/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-08
 * Author: XM
 */
package com.osxm.sb.ftp.config;

import java.io.InputStream;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Payload;

@MessagingGateway
public interface SftpGateway {

    @Gateway(requestChannel = "sftpChannel")
    void upload(@Payload String filePath);

    @Gateway(requestChannel = "sftpChannel", replyChannel = "sftpChannel")
    InputStream download(@Payload String remoteFilePath);
}