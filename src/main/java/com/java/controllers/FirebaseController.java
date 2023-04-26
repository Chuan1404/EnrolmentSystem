/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controllers;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author AnChuPC
 */
public class FirebaseController {
    @Autowired
    private FirebaseApp firebaseApp;

    @GetMapping("/send-notification")
    public String sendNotification(Model model) throws FirebaseMessagingException {

        // Get the registration token from the client
        String registrationToken = "<client-registration-token>";

        // See documentation on defining a message payload.
        Message message = Message.builder()
            .putData("score", "850")
            .putData("time", "2:45")
            .setToken(registrationToken)
            .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = FirebaseMessaging.getInstance(firebaseApp).send(message);

        model.addAttribute("message", response);

        return "index";
    }
}
