package com.csc340sp23.customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





/**
 *
 * @author Hilda
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findByAvailabilityTrue();
    Booking findByRoomNumber(String roomNumber);
}
