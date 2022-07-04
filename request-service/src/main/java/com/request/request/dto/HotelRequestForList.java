package com.request.request.dto;

import lombok.Data;

@Data
public class HotelRequestForList {
    private Long employeeId;

    private Long requestId;

    private String name;

    private Double price;
}
