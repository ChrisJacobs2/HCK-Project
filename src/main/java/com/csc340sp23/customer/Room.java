/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer;

import com.csc340sp23.customer.helpdesk.HelpDesk;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Hilda
 */
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "Room Number", nullable = false)
    private int roomNumber;

    @Column(name = "Guest Name", nullable = false)

    private String name;

    @Column(name = "Room Type", nullable = false)

    private String roomType;
    
    @Column(name = "Check-In-Date", nullable = false)

    private LocalDate checkInDate;

    @Column(name = "Check-Out-Date", nullable = false)

    private LocalDate checkOutDate;

    @Column(name = "Booked", nullable = false)

    private boolean booked;
    
    //@OneToMany(mappedBy = "room")
    //private List<HelpDesk> messages;

  

    Room() {
    }

    public Room(Long roomId, int roomNumber, String name, String roomType, LocalDate checkInDate, LocalDate checkOutDate) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.name = name;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

}
