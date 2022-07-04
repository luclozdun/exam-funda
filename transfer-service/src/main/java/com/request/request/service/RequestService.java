package com.request.request.service;

import java.util.List;

import com.request.request.dto.RequestRequest;
import com.request.request.dto.RequestResponse;

public interface RequestService {
    List<RequestResponse> getAll();

    RequestResponse getById(Long id);

    RequestResponse create(RequestRequest request);

    RequestResponse update(RequestRequest request, Long id);

    void delete(Long id);
}
