/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.repositories.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.java.models.ChatMessage;
import com.java.models.Room;
import com.java.pojos.Users;
import com.java.repositories.FirebaseRepository;
import com.java.repositories.UsersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AnChuPC
 */
@Repository
public class FirbaseRepositoryImpl implements FirebaseRepository {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public Room getRoomById(String id) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/rooms");
        Room room = new Room();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot childSnapshot : ds.getChildren()) {
                    Users counselor = userRepository.getUserById(childSnapshot.child("counselorId").getValue(String.class));
                    Users user = userRepository.getUserById(childSnapshot.child("userId").getValue(String.class));
                    if (childSnapshot.child("id").equals(id)) {
                        room.setId(id);
                        room.setUser(user);
                        room.setCounselor(counselor);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
            }
        });

        return room;
    }

    @Override
    public List<Room> getRooms(String counselorId) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/rooms");

        Users counselor = userRepository.getUserById(counselorId);
        List<Room> rooms = new ArrayList<>();

        if (counselor != null) {
            ref.orderByChild("counselorId").equalTo(counselorId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot ds) {
                    for (DataSnapshot childSnapshot : ds.getChildren()) {
                        String id = childSnapshot.child("id").getValue(String.class);
                        Room room = getRoomById(id);
                        if (room != null) {
                            rooms.add(room);
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError de) {
                }

            });
        }

        return rooms;
    }

    @Override
    public synchronized List<ChatMessage> getMessage(String roomId) {
        List<ChatMessage> messages = new ArrayList<>();

        System.out.println("begin");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/messages");
        ref.orderByChild("roomId").equalTo(roomId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String id = childSnapshot.child("id").getValue(String.class);
                    String message1 = childSnapshot.child("message").getValue(String.class);
                    Long timestamp = childSnapshot.child("timestamp").getValue(Long.class);
                    Room room = getRoomById(id);
                    ChatMessage message = new ChatMessage(id, message1, room, timestamp);
                    if (room != null) {
                        messages.add(message);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
            }
        }
        );
        System.out.println("end");

        System.out.println("return");
        return messages;
    }

}
