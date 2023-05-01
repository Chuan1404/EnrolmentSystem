///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.java.controllers;
//
//import com.java.models.ChatMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
///**
// *
// * @author AnChuPC
// */
//@Controller
//public class ChatController {
//
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//
//    @MessageMapping("/hello")
//    public void sendMessage(@Payload ChatMessage chatMessage) {
//        messagingTemplate.convertAndSend("/topic/public", chatMessage);
//    }
//}
