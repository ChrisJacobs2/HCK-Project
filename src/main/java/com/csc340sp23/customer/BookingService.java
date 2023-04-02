package com.csc340sp23.customer;

import java.util.List;
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
        bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);
    }

}
