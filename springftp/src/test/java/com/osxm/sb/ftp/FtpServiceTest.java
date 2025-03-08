/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-08
 * Author: XM
 */
package com.osxm.sb.ftp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osxm.sb.ftp.service.FtpService;

@SpringBootTest
public class FtpServiceTest {

    @Autowired
    private FtpService ftpService;

    @Test
    public void download() {
        ftpService.downloadFile("/localhost/2.txt");
    }
}
