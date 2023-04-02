package com.csc340sp23.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hilda
 */
@Service
public class RoomService extends Booking {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    public Room getRoomById(Long roomId){
    return roomRepository.findById(roomId).orElse(null);
    
    }
    public Room getRoomByNumber(int roomNumber){
    return roomRepository.findByRoomNumber(roomNumber);
    }
    public void addRoom(Room room){
    roomRepository.save(room);
    }
    public void updateRoom(Room room){
    roomRepository.save(room);
    
    }
    public void deleteRoom(Long roomId){
    roomRepository.deleteById(roomId);
    }
    
    public void updateRoomBookedStatus(Long roomId, boolean booked){
    Optional<Room> optionalRoom = roomRepository.findById(roomId);
    if(optionalRoom.isPresent()){
    Room room = optionalRoom.get();
    room.setBooked(booked);
    roomRepository.save(room);
    }
    }
    
    

  /*
    public boolean isAvailable(Date checkInDate, Date checkOutDate, List<Booking> bookings) {
        for (Booking booking : bookings) {
            if (checkInDate.before(booking.getCheckOutDate()) && checkOutDate.after(booking.getCheckInDate())) {
                return false; // Room is already booked during this period
            }
        }
        return true; // Room is available during this period
    }*/

   

}
