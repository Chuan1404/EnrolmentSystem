/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.java.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 *
 * @author AnChuPC
 */
@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) throws Exception {
        return message;
    }
}
