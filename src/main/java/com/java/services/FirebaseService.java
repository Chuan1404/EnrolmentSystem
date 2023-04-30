/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.services;

import com.java.models.ChatMessage;
import com.java.models.Room;
import java.util.List;

/**
 *
 * @author AnChuPC
 */
public interface FirebaseService {
    public List<Room> getRooms(String advisorId);
    public List<ChatMessage> getMessage(String roomId);
}
