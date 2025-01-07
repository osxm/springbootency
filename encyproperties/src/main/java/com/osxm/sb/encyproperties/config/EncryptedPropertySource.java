/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2025-01-07
 * Author: XM
 */
package com.osxm.sb.encyproperties.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.env.EnumerablePropertySource;

import com.osxm.sb.encyproperties.util.SecurityUtil;

public class EncryptedPropertySource extends EnumerablePropertySource<Map<String, Object>> {

    private final Map<String, Object> properties = new HashMap<>();

    public EncryptedPropertySource(String name, Map<String, Object> source) {
        super(name, source);
        source.forEach((key, value) -> {
            if (value != null) {
                try {
                    properties.put(key, decrypt(value.toString()));
                } catch (Exception e) {
                    properties.put(key, value);

                }

            }
        });
    }

    @Override
    public String[] getPropertyNames() {
        return properties.keySet().toArray(new String[0]);
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }

    private String decrypt(String encryptedValue) throws Exception {
        // 在这里实现你的解密逻辑
        // 例如，假设加密值是 "ENC(encryptedPassword)" 格式
        if (encryptedValue.startsWith("ENC(") && encryptedValue.endsWith(")")) {
            String encryptedPassword = encryptedValue.substring(4, encryptedValue.length() - 1);
            // 这里使用简单的Base64解码作为示例，你可以使用更复杂的解密算法
            return SecurityUtil.decrypt(encryptedPassword, "oscar");
        }
        return encryptedValue;
    }
}