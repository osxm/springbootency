/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-09-04
 * Author: XM
 */
package com.osxm.sb.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;  
import org.springframework.messaging.handler.annotation.SendTo;  
import org.springframework.stereotype.Controller;  
  
@Controller  
public class WebSocketController {  
  
    @MessageMapping("/hello")  
    @SendTo("/topic/greetings")  
    public String greeting(String message) throws Exception {  
        // 接收客户端发送的消息，并返回要发送给客户端的消息  
        return "Hello, " + message + "!";  
    }  
}
