package com.hotel.hotel.dto;

import lombok.Data;

@Data
public class HotelRequest {
    private Long employeeId;

    private Long requestId;

    private String name;

    private Double price;
}
