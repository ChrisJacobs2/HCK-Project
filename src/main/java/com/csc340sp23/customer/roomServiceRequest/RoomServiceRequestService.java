/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer.roomServiceRequest;

import com.csc340sp23.customer.Booking;
import com.csc340sp23.customer.BookingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hilda
 */
@Service
public class RoomServiceRequestService {
    @Autowired
    private RoomServiceRequestRepository roomServiceRequestRepository;
   
    
    public List<RoomServiceRequest> getAllRoomServiceRequests() {
        return roomServiceRequestRepository.findAll();
    }
    
    
    
    

    public RoomServiceRequest getRoomServiceRequestById(Long id) {
        return roomServiceRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Room Service Request not found"));
    }
    
    
    public RoomServiceRequest updateRoomServiceRequest(Long id, RoomServiceRequest RSDetails) {
         RoomServiceRequest roomServiceRequest = roomServiceRequestRepository.findById(id).orElseThrow(() -> 
                 new RuntimeException("Room Service Request not found"));
     
        roomServiceRequest.setDescription(RSDetails.getDescription());
        roomServiceRequest.setRSDate(RSDetails.getRSDate());
       
        return roomServiceRequestRepository.save(RSDetails);
    }
    
    
   
    
    
    
    
    public void saveRoomServiceRequest(RoomServiceRequest roomServiceRequest) {
        roomServiceRequestRepository.save(roomServiceRequest);
    }
    
    public void deleteRoomServiceRequest(Long id) {
        roomServiceRequestRepository.deleteById(id);
    }
    
    
    
    
   
    
}
