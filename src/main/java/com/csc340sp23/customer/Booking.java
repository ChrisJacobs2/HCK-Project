/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import lombok.Getter;

import lombok.Setter;



/**
 *
 * @author Hilda
 */
@Entity
@Getter
@Setter


@Table(name = "Bookings")
public class Booking {
    public Booking(){
    }

    public Booking(Long id, String name, String address, String email, String roomNumber, boolean isAvailable, LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.roomNumber = roomNumber;
        this.isAvailable = isAvailable;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Address", nullable = false)
    
    private String address;
     
    @Column(name = "Email", nullable = false)
    
    private String email;
  
    @Column(name = "roomNumber", nullable = false)

    private String roomNumber;
    @Column(name = "isAvaiable", nullable = false)

    private boolean isAvailable;
    
    
    @Column(name = "checkInDate")
    private LocalDate checkInDate;
    
    @Column(name = "checkOutDate")
    private LocalDate checkOutDate;
    
    //@NotNull(message = "Room type is required")
    @Column(name = "roomType")
    private String roomType;
    
    @OneToMany(mappedBy = "roomNumber")
    private List<Booking> bookings;
    
    
    
    
    
    

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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

  
    
    

    public  String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
   
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    


}

