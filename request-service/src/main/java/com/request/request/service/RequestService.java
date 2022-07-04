package com.request.request.service;

import java.util.List;

import com.request.request.dto.RequestRequest;
import com.request.request.dto.RequestResponse;
import com.request.request.entity.Request;

public interface RequestService {
    List<Request> getAll();

    RequestResponse getById(Long id);

    RequestResponse create(RequestRequest request);

    void delete(Long id);
}
