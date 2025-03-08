/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-08
 * Author: XM
 */
package com.osxm.sb.ftp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class FtpService {
    
    @Autowired
    private MessageChannel ftpDownloadChannel;

    public void downloadFile(String remoteFilePath) {
        ftpDownloadChannel.send(MessageBuilder.withPayload(remoteFilePath).build());
        System.out.println("File download triggered: " + remoteFilePath);
    }
    
}
