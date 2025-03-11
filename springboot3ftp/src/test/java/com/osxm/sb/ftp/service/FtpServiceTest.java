/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-11
 * Author: XM
 */
package com.osxm.sb.ftp.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FtpServiceTest {

    @Autowired
    private FtpService ftpService;

    @Test
    public void listDirectory() {
        List<String> list = ftpService.listDirectory("/");
        System.out.println(list);
    }

}
