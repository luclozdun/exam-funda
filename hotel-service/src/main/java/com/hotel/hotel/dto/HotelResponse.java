package com.hotel.hotel.dto;

import lombok.Data;

@Data
public class HotelResponse {
    private Long id;

    private Long employeeId;

    private Long requestId;

    private String name;

    private Double price;
}
