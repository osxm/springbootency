/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-08
 * Author: XM
 */
package com.osxm.sb.ftp.config;

import java.io.File;

import org.apache.commons.net.ftp.FTPFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.ftp.filters.FtpSimplePatternFileListFilter;
import org.springframework.integration.ftp.gateway.FtpOutboundGateway;
import org.springframework.integration.ftp.inbound.FtpInboundFileSynchronizer;
import org.springframework.integration.ftp.inbound.FtpInboundFileSynchronizingMessageSource;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class FtpConfig {

    @Bean
    public SessionFactory<FTPFile> ftpSessionFactory() {
        DefaultFtpSessionFactory factory = new DefaultFtpSessionFactory();
        factory.setHost("localhost");
        factory.setPort(21);
        // factory.setUsername("username");
        // factory.setPassword("password");
        return factory;
    }

    @Bean
    public FtpInboundFileSynchronizer ftpInboundFileSynchronizer() {
        FtpInboundFileSynchronizer synchronizer = new FtpInboundFileSynchronizer(ftpSessionFactory());
        synchronizer.setRemoteDirectory("/localhost");
        synchronizer.setFilter(new FtpSimplePatternFileListFilter("*.txt"));
        return synchronizer;
    }

    @Bean
    @InboundChannelAdapter(channel = "ftpChannel", poller = @Poller(fixedDelay = "5000"))
    public MessageSource<File> ftpMessageSource() {
        FtpInboundFileSynchronizingMessageSource source = new FtpInboundFileSynchronizingMessageSource(
                ftpInboundFileSynchronizer());
        source.setLocalDirectory(new File("E:\\workspace\\ftpclient"));
        source.setAutoCreateLocalDirectory(true);
        return source;
    }

    @Bean
    @ServiceActivator(inputChannel = "ftpDownloadChannel")
    public MessageHandler ftpOutboundGateway() {
        FtpOutboundGateway gateway = new FtpOutboundGateway(ftpSessionFactory(), "get", "payload");
        gateway.setLocalDirectory(new File("E:\\workspace\\ftpclient")); // 本地目录
        gateway.setAutoCreateLocalDirectory(true); // 如果本地目录不存在，自动创建
        return gateway;
    }

    @Bean
    public MessageChannel ftpDownloadChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "ftpChannel")
    public MessageHandler ftpHandler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("Received file: " + message.getPayload());
            }
        };
    }

}
