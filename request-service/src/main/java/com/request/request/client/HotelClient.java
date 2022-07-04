package com.request.request.client;

import com.request.request.dto.HotelRequestForList;
import com.request.request.model.Hotel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hotel-service", path = "/hotels", fallback = HotelHystrixFallbackFactory.class)
public interface HotelClient {
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> geById(@PathVariable("id") Long id);

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody HotelRequestForList request);
}