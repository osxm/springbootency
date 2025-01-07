
/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-01-07
 * Author: XM
 */
package com.osxm.sb.encyproperties.util;

import org.junit.jupiter.api.Test;

public class SecurityUtilTest {

    @Test
    public void encrypt() throws Exception {
        String text = "123456";
        String password = "oscar";
        String encryText = SecurityUtil.encrypt(text, password);
        System.out.println(encryText);
    }
}
