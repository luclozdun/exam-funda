package com.request.request.dto;

import java.util.List;

import lombok.Data;

@Data
public class RequestRequest {
    private List<HotelRequest> hotels;

    private Long employeeId;

    private String detail;
}
