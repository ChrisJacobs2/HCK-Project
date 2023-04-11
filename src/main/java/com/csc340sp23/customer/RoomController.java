/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.customer;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Hilda
 */

@Controller
@RequestMapping("/rooms")
public class RoomController{
    @Autowired
    private RoomService roomService;
  @Autowired
    private BookingService bookingService;
 
    
   
    @GetMapping("/reservation")
    public String getAllRooms(Model model){
    List<Room> rooms = roomService.getAllRooms();
    model.addAttribute("rooms", rooms);
    return "/rooms/reservation-list";
    
    }
    
    @GetMapping("/{id}")
    public String getRoomById(@PathVariable Long roomId, Model model){
    Room room = roomService.getRoomById(roomId);
    model.addAttribute("room", room);
    return "/rooms/show";
    
    }
    @GetMapping("/new")
    public String createRoomForm(Model model){
    Room room = new Room();
    model.addAttribute("room", room);
    return "/rooms/new";
    }
    @PostMapping("/create")
    public String createRoom(@ModelAttribute("room")Room room){
    roomService.addRoom(room);
    return "redirect:/rooms";
    }
    
    
    
    
    @GetMapping("/rooms/{id}/booked")
    @ResponseBody
    public boolean isBooked(@PathVariable Long roomId){
    Room room = roomService.getRoomById(roomId);
    return room.isBooked();
    }
    
    @PostMapping("/rooms/{id}/booked")
    @ResponseBody
    public boolean updateBookedStatus(@PathVariable Long roomId){
    Room room = roomService.getRoomById(roomId);
    return room.isBooked();
    }
    
    
    @GetMapping("/{id}/edit")
    public String updateRoomForm(@PathVariable Long roomId, Model model){
    Room room = roomService.getRoomById(roomId);
    model.addAttribute("room",room);
    return "rooms/edit";
    }
 
    
    @PutMapping("/{id}")
    public String updateRoom(@PathVariable Long roomId,@ModelAttribute("room")Room room){
    room.setRoomId(roomId);
    roomService.updateRoom(room);
    return "redirect:/rooms";
    }
    
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long roomId){
    roomService.deleteRoom(roomId);
    return "redirect:/rooms";
    }
    
    
    
    
    
}
