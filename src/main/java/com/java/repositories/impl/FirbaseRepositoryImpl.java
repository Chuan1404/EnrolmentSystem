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
    public List<Room> getRooms(String counselorId) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/rooms/");

        Users counselor = userRepository.getUserById(counselorId);
        List<Room> rooms = new ArrayList<>();

        if (counselor != null) {
            ref.orderByChild("counselorId").equalTo(counselorId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot ds) {
                    for (DataSnapshot childSnapshot : ds.getChildren()) {
                        System.out.println(childSnapshot.getValue());
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
    public List<ChatMessage> getMessage(String roomId) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/messages");
        List<ChatMessage> messages = new ArrayList<>();
        ref.orderByChild("roomId").equalTo(roomId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                   System.out.println(childSnapshot.getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
            }
        }
        );
        return messages;
    }

}
