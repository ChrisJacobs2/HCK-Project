package com.csc340sp23.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hilda Ramirez
 */
@Controller
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private BookingService bookingService;  // BTW, you can have more than one service here -- Christopher
    
 
    @GetMapping("/home")
    public String getHome() {
        return "customer/customer-home";
    }
    
    @GetMapping("/booking")
    public String getBookingList(Model model) {
        model.addAttribute("bookingList", bookingService.getAllBookings());
        
        return "customer/booking/booking-list";
    }
    
    @GetMapping("/id={id}")
    public String getBookingById(@PathVariable long id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        return "customer/booking/booking-detail";
    }
    
    
    @GetMapping("/delete/id={id}")
    public String deleteBooking(@PathVariable long id, Model model) {
        bookingService.deleteBooking(id);
        return "redirect:/user/booking";
    }
    
    /**
     *this will be the new booking form page 
     *  @GetMapping("/new-booking")
    public String newbookingForm(Model model) {
        return "customer/booking/new-booking";
    }
     * 
     */
    
    @PostMapping("/create")
    public String createBooking(Booking booking) {

        bookingService.saveBooking(booking);
        return "redirect:/user/home";
    }
    
    @PostMapping("/update")
    public String updateBooking(Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/user/booking";
    }
    
    @GetMapping("/new-booking")
    public String newbookingForm(Model model) {
        return "customer/booking/new-booking";
    }
    
    @GetMapping("/update/id={id}")
    public String updateBookingForm(@PathVariable long id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        return "customer/booking/update-booking";
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

