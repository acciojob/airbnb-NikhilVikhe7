package com.driver.repository;

import com.driver.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class HotelRepository {
    Map<String, Hotel> hotels;

    public HotelRepository() {
        this.hotels = new HashMap<>();
    }


    public Optional<Hotel> findByHotelName(String hotelName){
        Optional<Hotel> hotel = Optional.empty();
        if(hotels.containsKey(hotelName)){
            hotel = Optional.of(hotels.get(hotelName));
        }

        return hotel;
    }

    public void save(Hotel hotel) {
        hotels.put(hotel.getHotelName(), hotel);
    }

    public List<Hotel> findAll(){
        return new ArrayList<>(hotels.values());
    }
}
