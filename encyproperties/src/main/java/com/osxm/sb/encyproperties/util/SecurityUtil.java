/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-01-07
 * Author: XM
 */

package com.osxm.sb.encyproperties.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SecurityUtil {
    private static final String AES_GCM_NOPADDING = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 128;
    private static final int GCM_IV_LENGTH = 12;

    public static SecretKey generateKeyByPassword(String password) throws Exception {
        // 使用SHA-256哈希函数
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha.digest(password.getBytes("UTF-8"));

        // AES-256需要一个长度为256位的密钥，所以取哈希的前32字节
        keyBytes = Arrays.copyOf(keyBytes, 32);

        // 创建密钥
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        return secretKey;
    }

    public static String encrypt(String data, String password) throws Exception {
        SecretKey key = generateKeyByPassword(password);
        return encrypt(data, key);
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_GCM_NOPADDING);
        byte[] iv = new byte[GCM_IV_LENGTH];
        SecureRandom.getInstanceStrong().nextBytes(iv);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmParameterSpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        byte[] encryptedDataWithIv = new byte[iv.length + encryptedData.length];
        System.arraycopy(iv, 0, encryptedDataWithIv, 0, iv.length);
        System.arraycopy(encryptedData, 0, encryptedDataWithIv, iv.length, encryptedData.length);
        return Base64.getEncoder().encodeToString(encryptedDataWithIv);
    }

    public static String decrypt(String data, String password) throws Exception {
        SecretKey key = generateKeyByPassword(password);
        return decrypt(data, key);
    }

    public static String decrypt(String encryptedDataWithIv, SecretKey key) throws Exception {
        byte[] decodedData = Base64.getDecoder().decode(encryptedDataWithIv);
        Cipher cipher = Cipher.getInstance(AES_GCM_NOPADDING);
        byte[] iv = new byte[GCM_IV_LENGTH];
        System.arraycopy(decodedData, 0, iv, 0, iv.length);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, gcmParameterSpec);
        byte[] encryptedData = new byte[decodedData.length - iv.length];
        System.arraycopy(decodedData, iv.length, encryptedData, 0, encryptedData.length);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData);
    }
}
