package com.driver.service;

import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.repository.BookingRepository;
import com.driver.repository.HotelRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingService {

    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;

    public BookingService() {
        this.hotelRepository = new HotelRepository();
        this.bookingRepository = new BookingRepository();
    }

    public int bookRooms(Booking booking) {
        Hotel hotel = hotelRepository.findByHotelName(booking.getHotelName()).orElse(null);

        if(hotel == null || hotel.getAvailableRooms() < booking.getNoOfRooms()){
            return -1;
        }

        int totalAmount = hotel.getPricePerNight() * booking.getNoOfRooms();
        booking.setAmountToBePaid(totalAmount);

        bookingRepository.save(booking);

        return totalAmount;
    }

    public List<Booking> getBookingsByAadhar(Integer aadharCard) {
        return bookingRepository.findByAadhar(aadharCard);
    }
}
