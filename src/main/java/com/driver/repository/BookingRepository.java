package com.driver.repository;

import com.driver.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookingRepository {

    private final Map<Integer, List<Booking>> bookings;

    public BookingRepository() {
        this.bookings = new HashMap<>();
    }

    public void save(Booking booking) {

        if(bookings.containsKey(booking.getBookingAadharCard())){
            bookings.get(booking.getBookingAadharCard()).add(booking);
        }else{
            bookings.put(booking.getBookingAadharCard(), new ArrayList<>(List.of(booking)));
        }
    }

    public List<Booking> findByAadhar(Integer aadharCard) {
        return bookings.get(aadharCard);
    }
}
