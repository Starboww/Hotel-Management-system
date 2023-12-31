package com.vishal.hotel.Hotel.service;


import com.vishal.hotel.Hotel.model.HotelRequest;
import com.vishal.hotel.Hotel.model.HotelResponse;
import com.vishal.hotel.Hotel.model.RoomRequest;
import com.vishal.hotel.Hotel.model.RoomResponse;

import java.util.List;
import java.util.List;

public interface HotelService {
    long addHotelAndRooms(HotelRequest hotelRequest, List<RoomRequest> roomRequest);


    List<HotelResponse> getAllHotels();

    List<HotelResponse> getHotelByNameOrAddress(String hotelName);

    List<HotelResponse> getHotelByRating(float hotelRating);

    List<RoomResponse> getAllRooms(long id);
}
