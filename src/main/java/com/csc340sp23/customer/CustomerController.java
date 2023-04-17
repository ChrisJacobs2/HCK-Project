package com.csc340sp23.customer;

import com.csc340sp23.customer.helpdesk.HelpDesk;
import com.csc340sp23.customer.helpdesk.HelpDeskService;
import com.csc340sp23.customer.roomServiceRequest.RoomServiceRequest;
import com.csc340sp23.customer.roomServiceRequest.RoomServiceRequestService;
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
    @Autowired
    private HelpDeskService helpDeskService;
    @Autowired
    private RoomServiceRequestService roomServiceRequestService;

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
    // updated this

    @PostMapping("/create")
    public String createBooking(Booking booking) {
        bookingService.saveBooking(booking);
        Booking savedBooking = bookingService.getBookingById(booking.getId());
        savedBooking.setRoomNumber(generatedRandomRoomNumber());
        bookingService.saveBooking(savedBooking);
        //model.addAttribute("message","booking successful!");
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
    // added List<String>.. and model.AddAttri(roomtypes)..

    @GetMapping("/update/id={id}")
    public String updateBookingForm(@PathVariable long id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        //List<String> roomTypes = bookingService.getAllRoomTypes();
        //model.addAttribute("roomTypes", roomTypes);

        return "customer/booking/update-booking";
    }
// Mappings for Complaints start here

    // user/complaints
    @GetMapping("/complaints")
    public String getHelp(Model model) {
        List<HelpDesk> messages = helpDeskService.getAllMessages();
        model.addAttribute("messages", messages);
        return "customer/complaints/complaint-list";
    }

    // following /new-booking was "/complaints/new"
    @GetMapping("/new-message")
    public String newHelpDeskForm(Model model) {
        //HelpDesk message = new HelpDesk();
        //model.addAttribute("message", message);
        return "customer/complaints/new-message";
    }

    // following create booking
    //was had @ModelAttribute("message")
    @PostMapping("/createcomplaint")
    public String createHelpDesk(HelpDesk message) {
        helpDeskService.saveMessage(message);
        return "redirect:/user/complaints";

    }

    // update complaint
    // was @ModelAttribute("message")
    @PostMapping("/updatecomplaint")
    public String updateHelpDesk(HelpDesk message) {
        helpDeskService.saveMessage(message);
        return "redirect:/user/complaints";

    }

    // following /id = {id}
    // worked with no '/'..? on complaints also no '/' on the link to in the complaint-list html file
    //also added /user to links for edit and delete parts on their html files parts
    @GetMapping("complaints/messageId={messageId}")
    public String getHelpDeskById(@PathVariable long messageId, Model model) {
        HelpDesk message = helpDeskService.getMessageById(messageId);
        model.addAttribute("message", message);
        return "customer/complaints/message-detail";
    }
    // follows /update/id

    @GetMapping("/updatecomplaint/complaints/messageId={messageId}")
    public String editHelpDeskForm(@PathVariable long messageId, Model model) {
        HelpDesk message = helpDeskService.getMessageById(messageId);
        model.addAttribute("message", message);
        return "customer/complaints/edit-message";

    }

    @GetMapping("/deletecomplaint/complaints/messageId={messageId}")
    public String deleteHelpDesk(@PathVariable long messageId) {
        helpDeskService.deleteMessageById(messageId);
        return "redirect:/user/complaints";

    }

    private String generatedRandomRoomNumber() {
        return "/user/create";
    }
    //@ModelAttribute("roomTypes")
    //public List<String> populateRoomTypes() {
    // Get all possible room types from the database and return them as a list
    //  List<String> roomTypes = bookingService.getAllRoomTypes();
    //  return roomTypes;
    //}

    // this starts room service mappings
    // user/room-serivce
    @GetMapping("/room-service")
    public String getAllRoomServiceRequests(Model model) {
        List<RoomServiceRequest> roomServiceRequests = roomServiceRequestService.getAllRoomServiceRequests();
        model.addAttribute("roomServiceRequests", roomServiceRequests);
        return "customer/room-service/service-list";
    }

    @GetMapping("/new-request")
    public String newRequestForm(Model model) {
        //HelpDesk message = new HelpDesk();
        //model.addAttribute("message", message);
        return "customer/room-service/new-request";
    }

    // added booking line request set roomnumber line
    @PostMapping("/createrequest")
    public String createRequest(RoomServiceRequest request) {
       // Booking booking = bookingService.getBookingById(request.getId());

       // request.setRoomNumber(booking.getRoomNumber());

        roomServiceRequestService.saveRoomServiceRequest(request);
        return "redirect:/user/room-service";

    }

    @PostMapping("/updaterequest")
    public String updateRoomServiceRequest(RoomServiceRequest request) {
        roomServiceRequestService.saveRoomServiceRequest(request);
        return "redirect:/user/room-service";

    }

    @GetMapping("room-service/requestId={id}")
    public String getRoomServiceRequestById(@PathVariable long id, Model model) {
        RoomServiceRequest roomServiceRequest = roomServiceRequestService.getRoomServiceRequestById(id);
        model.addAttribute("roomServiceRequest", roomServiceRequest);
        return "customer/room-service/request-detail";
    }

    @GetMapping("/updaterequest/room-service/requestId={id}")
    public String editRequestForm(@PathVariable long id, Model model) {
        RoomServiceRequest roomServiceRequest = roomServiceRequestService.getRoomServiceRequestById(id);
        model.addAttribute("roomServiceRequest", roomServiceRequest);
        return "customer/room-service/edit-request";

    }

    @GetMapping("/deleterequest/room-service/requestId={id}")
    public String deleteRoomServiceRequest(@PathVariable long id) {
        roomServiceRequestService.deleteRoomServiceRequest(id);
        return "redirect:/user/room-service";

    }

}
