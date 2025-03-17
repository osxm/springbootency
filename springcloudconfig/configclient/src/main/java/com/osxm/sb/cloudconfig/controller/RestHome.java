/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-03-17
 * Author: XM
 */
package com.osxm.sb.cloudconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHome {
    @Value("${app.message:Hello Default}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
