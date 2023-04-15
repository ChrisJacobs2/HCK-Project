package com.csc340sp23.customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hilda
 */
@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    
    public Booking getBookingById(Long id) {

        return bookingRepository.getReferenceById(id);

    }

    public void saveBooking(Booking booking) {
        String roomNumber = generateRandomRoomNumber();
        booking.setRoomNumber(roomNumber);
        bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);
    }

    private String generateRandomRoomNumber() {
        // generate a random 3-digit room number
        Random rand = new Random();
        int roomNum = rand.nextInt(400) + 100;
        return "R" + roomNum;
    }
   
 
}
