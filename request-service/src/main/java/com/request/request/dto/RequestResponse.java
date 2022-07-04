package com.request.request.dto;

import java.util.List;

import lombok.Data;

@Data
public class RequestResponse {

    private Long id;

    private List<HotelRequest> hotels;

    private Long employeeId;

    private String detail;
}
