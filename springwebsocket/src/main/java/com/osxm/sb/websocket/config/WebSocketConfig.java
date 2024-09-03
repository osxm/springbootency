/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-09-04
 * Author: XM
 */
package com.osxm.sb.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个Stomp协议的端点，客户端将使用此URL来建立WebSocket连接
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 配置消息代理选项
        // 启用简单的消息代理前缀
        registry.enableSimpleBroker("/topic");
        // 设置应用程序的前缀，以便拦截并处理以"/app"开头的消息
        registry.setApplicationDestinationPrefixes("/app");
    }
}