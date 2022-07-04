package com.hotel.hotel.service;

import java.util.List;

import com.hotel.hotel.dto.HotelRequest;
import com.hotel.hotel.dto.HotelResponse;

public interface HotelService {
    List<HotelResponse> getAll();

    HotelResponse getById(Long id);

    HotelResponse create(HotelRequest request);

    HotelResponse update(HotelRequest request, Long id);

    void delete(Long id);
}
