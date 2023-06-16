package com.vishal.hotel.Hotel.controller;

import com.vishal.hotel.Hotel.model.HotelAndRoomRequest;
import com.vishal.hotel.Hotel.model.HotelResponse;
import com.vishal.hotel.Hotel.model.RoomResponse;
import com.vishal.hotel.Hotel.repository.HotelRepository;
import com.vishal.hotel.Hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;



    @PostMapping
    public ResponseEntity<Long> addHotelAndRooms(@RequestBody HotelAndRoomRequest hotelAndRoomRequest){
        long hotelId = hotelService.addHotelAndRooms(hotelAndRoomRequest.getHotelRequest(),hotelAndRoomRequest.getRoomRequests());
        return new ResponseEntity<>(hotelId,HttpStatus.CREATED);
    }

    @GetMapping("/allHotel")
    public List<HotelResponse> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelName}")
    public List<HotelResponse> getHotelByNameOrAddress(@PathVariable("hotelName") String hotelName){
        return hotelService.getHotelByNameOrAddress(hotelName);
    }

    @GetMapping("/rating/{hotelRating}")
    public List<HotelResponse> getHotelByAddress(@PathVariable("hotelRating") float hotelRating){
        return hotelService.getHotelByRating(hotelRating);
    }

    @GetMapping("/hotel/{id}")
    public List<RoomResponse> getAllRoom(@PathVariable("id") long id){
        return hotelService.getAllRooms(id);
    }
}
