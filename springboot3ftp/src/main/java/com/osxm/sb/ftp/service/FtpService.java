/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-11
 * Author: XM
 */
package com.osxm.sb.ftp.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.integration.ftp.session.FtpRemoteFileTemplate;

@Service
public class FtpService {
    private final FtpRemoteFileTemplate ftpTemplate;

    public FtpService(FtpRemoteFileTemplate ftpTemplate) {
        this.ftpTemplate = ftpTemplate;
    }

    public List<String> listDirectory(String path) {
        return ftpTemplate.execute(session -> {
            String[] files = session.listNames(path);
            if (files == null)
                return Collections.emptyList();
            return Arrays.stream(files)
                    .filter(name -> !name.equals(".") && !name.equals(".."))
                    .collect(Collectors.toList());
        });
    }
}