package com.request.request.model;

import lombok.Data;

@Data
public class Hotel {
    private Long id;

    private Long employeeId;

    private Long requestId;

    private String name;

    private Double price;
}
