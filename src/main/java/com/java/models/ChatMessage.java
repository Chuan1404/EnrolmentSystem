/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.models;

/**
 *
 * @author AnChuPC
 */
public class ChatMessage {

    private String id;
    private String message;
    private long timestamp;
    private Room room;

    public ChatMessage() {

    }

    public ChatMessage(String id, String message, Room room, Long timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.room = room;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", id, message, room.getId(), timestamp);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

}
