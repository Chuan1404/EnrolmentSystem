/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories;

import com.java.models.ChatMessage;
import com.java.models.Room;
import java.util.List;

/**
 *
 * @author AnChuPC
 */
public interface FirebaseRepository {
    public List<Room> getRooms(String counselorId);
    public List<ChatMessage> getMessage(String roomId);
}
