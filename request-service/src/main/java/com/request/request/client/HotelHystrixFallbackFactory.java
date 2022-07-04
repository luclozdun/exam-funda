package com.request.request.client;

import com.request.request.dto.HotelRequest;
import com.request.request.model.Hotel;

import org.springframework.http.ResponseEntity;

public class HotelHystrixFallbackFactory implements HotelClient {

    @Override
    public ResponseEntity<Hotel> geById(Long id) {
        Hotel hotel = new Hotel();
        hotel.setId(0L);
        hotel.setEmployeeId(0L);
        hotel.setName("name");
        hotel.setPrice(0.0);
        hotel.setRequestId(0L);
        return null;
    }

    @Override
    public ResponseEntity<Hotel> create(HotelRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
