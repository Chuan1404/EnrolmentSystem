/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services.impl;

import com.java.models.ChatMessage;
import com.java.models.Room;
import com.java.repositories.FirebaseRepository;
import com.java.services.FirebaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnChuPC
 */
@Service
public class FirebaseServiceImpl implements FirebaseService {

    @Autowired
    private FirebaseRepository firebaseRepository;

    @Override
    public List<ChatMessage> getMessage(String roomId) {
        return firebaseRepository.getMessage(roomId);
    }

    @Override
    public List<Room> getRooms(String advisorId) {
        return firebaseRepository.getRooms(advisorId);
    }
    

}
