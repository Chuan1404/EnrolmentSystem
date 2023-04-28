/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.java.models.ChatMessage;
import com.java.models.Room;
import com.java.services.FirebaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author AnChuPC
 */
@Controller
public class FirebaseController {

    @Autowired
    private FirebaseApp firebaseApp;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("/send-notification")
    public void sendNotification(Model model) throws FirebaseMessagingException {
        List<Room> rooms = firebaseService.getRooms("a9c9a08e-afc2-4b92-b8af-b848de70da70");
        List<ChatMessage> messages = firebaseService.getMessage("0");

        System.out.println("---------------------");
        rooms.forEach(item -> System.out.println(item));
        System.out.println("---------------------");
        messages.forEach(item -> System.out.println(item));
    }
}
