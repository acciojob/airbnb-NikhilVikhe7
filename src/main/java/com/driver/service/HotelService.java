package com.driver.service;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }



    public String addHotel(Hotel hotel) {
        if(hotel == null || hotel.getHotelName() == null
                || hotelRepository.findByHotelName(hotel.getHotelName()).isPresent()){

            return "FAILURE";

        }

        hotelRepository.save(hotel);
        return "SUCCESS";
    }

    public Hotel getHotelWithMostFacilities() {
        List<Hotel> hotels = hotelRepository.findAll();
       return hotels.stream().max(mostFacilitiesComparator).orElse(null);
    }

    Comparator<Hotel> mostFacilitiesComparator = (o1, o2) -> {
        if(o1.getFacilities().size() == o2.getFacilities().size())
        {
            return o2.getHotelName().compareTo(o1.getHotelName());
        }

        return o1.getFacilities().size() - o2.getFacilities().size();
    };

    public Hotel addFacilities(String hotelName, List<Facility> newFacilities) {
        Hotel hotel = hotelRepository.findByHotelName(hotelName).orElse(null);
        List<Facility> facilities = hotel.getFacilities();
        for(Facility facility : newFacilities){
            if (!facilities.contains(facility)){
                facilities.add(facility);
            }
        }

        hotelRepository.save(hotel);

        return hotel;
    }
}
