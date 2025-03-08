/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-08
 * Author: XM
 */
package com.osxm.sb.ftp.config;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.remote.gateway.AbstractRemoteFileOutboundGateway;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.gateway.SftpOutboundGateway;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.MessageHandler;

import com.jcraft.jsch.ChannelSftp.LsEntry;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class SftpConfig {

    @Bean
    public SessionFactory<LsEntry> sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost("");
        factory.setPort(22);
        factory.setUser("");
        factory.setPassword("");
        factory.setAllowUnknownKeys(true);
        return factory;
    }

    @Bean
    @ServiceActivator(inputChannel = "sftpChannel")
    public MessageHandler sftpOutboundGateway() {
        SftpOutboundGateway gateway = new SftpOutboundGateway(sftpSessionFactory(), "get", "payload");
        gateway.setLocalDirectory(new File("D:\\temp")); // Ensure this directory exists
        gateway.setAutoCreateLocalDirectory(true);
        gateway.setOption(AbstractRemoteFileOutboundGateway.Option.STREAM);
        return gateway;
    }
}
