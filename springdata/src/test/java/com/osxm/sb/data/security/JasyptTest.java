
/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-01-07
 * Author: XM
 */
package com.osxm.sb.data.security;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    @Test
    public void ency() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("oscar");
        // encryptor.setAlgorithm("PBEWithHMACSHA512ANDAES_256"); // 或其他设置的算法
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        String originalText = "1234567";
        String encryptedText = encryptor.encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = encryptor.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        Assertions.assertEquals(originalText, decryptedText);
    }

}
