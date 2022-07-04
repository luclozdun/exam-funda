package com.request.request.dto;

import java.util.List;

import com.request.request.model.Hotel;

import lombok.Data;

@Data
public class RequestResponse {

    private Long id;

    private List<Hotel> hotels;

    private Long employeeId;

    private String detail;
}
