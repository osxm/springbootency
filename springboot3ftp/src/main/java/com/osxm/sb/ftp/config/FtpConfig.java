/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-11
 * Author: XM
 */
package com.osxm.sb.ftp.config;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpRemoteFileTemplate;

@Configuration
public class FtpConfig {

    @Bean
    public DefaultFtpSessionFactory ftpSessionFactory() {
        DefaultFtpSessionFactory factory = new DefaultFtpSessionFactory();
        factory.setHost("localhost");
        factory.setPort(21);
        factory.setUsername("ftpuser");
        factory.setPassword("123456");
        // 可选：设置被动模式（应对防火墙/NAT环境）
        factory.setClientMode(FTPClient.PASSIVE_LOCAL_DATA_CONNECTION_MODE);
        return factory;
    }

    @Bean
    public FtpRemoteFileTemplate ftpRemoteFileTemplate() {
        return new FtpRemoteFileTemplate(ftpSessionFactory());
    }
}