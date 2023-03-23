package com.csc340sp23.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Christopher Jacobs
 */
@Controller
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
 
    @GetMapping("/home")
    public String getHome() {
        return "customer/customer-home";
    }
    
    @GetMapping("/booking")
    public String getBookingList() {
        return "customer/booking/booking-list";
    }
    
    @GetMapping("booking/new-booking")
    public String newBookingForm() {
        return "customer/booking/new-booking";
    }
    
    @GetMapping("booking/details")
    public String bookingDetails() {
        return "customer/booking/booking-detail";
    }
    
    @GetMapping("/complaints")
    public String getHelp() {
        return "customer/complaints/complaint-list";
    }
    
    
    @GetMapping("/room-service")
    public String getRoomService() {
        return "customer/room-service/service-list";
    }
    

}

