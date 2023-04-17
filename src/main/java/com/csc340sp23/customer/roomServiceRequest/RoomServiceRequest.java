/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer.roomServiceRequest;

import com.csc340sp23.customer.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author Hilda
 */
@Entity
@Table(name = "room_service_requests")
public class RoomServiceRequest {
    
    public RoomServiceRequest(){
    }

    public RoomServiceRequest(Long id, String serviceType, String description, boolean completed) {
        this.id = id;
        this.serviceType = serviceType;
        this.description = description;
   
        this.completed = completed;
    }



 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    //@ManyToOne
    //@JoinColumn(name =  "roomNumber")
    //private Booking booking;
   
  
    
    @Column(name = "Service Type")
    private String serviceType;
    
    @Column(name = "Description")
    private String description;

    
    
    //@Column(name = "Room Number")
   // private String roomNumber;
    
    @Column(name = " Request Date")
    private LocalDateTime RSDate = LocalDateTime.now();
    
    @Column(name = "Completed")
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    


    public LocalDateTime getRSDate() {
        return RSDate;
    }

    public void setRSDate(LocalDateTime RSDate) {
        this.RSDate = RSDate;
    }
    
        public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

   

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
  


}

