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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        CountDownLatch latch = new CountDownLatch(1);
        Room room = new Room();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot childSnapshot : ds.getChildren()) {
                    Users advisor = userRepository.getUserById(childSnapshot.child("advisorId").getValue(String.class));
                    Users user = userRepository.getUserById(childSnapshot.child("userId").getValue(String.class));
                    if (childSnapshot.child("id").equals(id)) {
                        room.setId(id);
                        room.setUser(user);
                        room.setCounselor(advisor);
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
    public List<Room> getRooms(String advisorId) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/rooms");

        Users advisor = userRepository.getUserById(advisorId);
        List<Room> rooms = new ArrayList<>();

        if (advisor != null) {

            ref.orderByChild("advisorId").equalTo(advisorId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot ds) {
                    for (DataSnapshot childSnapshot : ds.getChildren()) {
                        String id = childSnapshot.child("id").getValue(String.class);
                        String userId = childSnapshot.child("userId").getValue(String.class);

                        Users user = userRepository.getUserById(userId);
                        Room room = new Room(id, user, advisor);
                        rooms.add(room);
                    }
//                    latch.countDown();
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

        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ref.orderByChild("roomId").equalTo(roomId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    try {
                        Future<ChatMessage> messageFuture = executor.submit(() -> {
                            String id = childSnapshot.child("id").getValue(String.class);
                            String message1 = childSnapshot.child("message").getValue(String.class);
                            Long timestamp = childSnapshot.child("timestamp").getValue(Long.class);
                            Room room = getRoomById(id);
                            ChatMessage message = new ChatMessage(id, message1, room, timestamp);
                            return message;
                        });

                        // add message to list
                        messages.add(messageFuture.get());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FirbaseRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        Logger.getLogger(FirbaseRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                latch.countDown();
                executor.shutdown();
            }

            @Override
            public void onCancelled(DatabaseError de) {
                latch.countDown();
            }
        }
        );
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(FirbaseRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return messages;
    }

}
