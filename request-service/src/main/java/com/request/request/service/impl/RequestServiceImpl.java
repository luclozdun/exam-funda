package com.request.request.service.impl;

import java.util.Date;
import java.util.List;

import com.request.exception.ResourceNotFoundExceptionRequest;
import com.request.request.client.HotelClient;
import com.request.request.dto.HotelRequest;
import com.request.request.dto.RequestRequest;
import com.request.request.dto.RequestResponse;
import com.request.request.entity.Request;
import com.request.request.repository.RequestRepository;
import com.request.request.service.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private HotelClient hotelClient;

    public RequestResponse convertToResponse(Request entity) {
        RequestResponse response = new RequestResponse();
        response.setId(entity.getId());
        response.setDetail(entity.getDetail());
        response.setEmployeeId(entity.getEmployeeId());
        return response;
    }

    @Override
    public List<Request> getAll() {
        var entities = requestRepository.findAll();
        return entities;
    }

    @Override
    public RequestResponse getById(Long id) {
        var entity = requestRepository.getGameById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("Game not found"));
        var response = convertToResponse(entity);
        return response;
    }

    @Override
    public RequestResponse create(RequestRequest request) {

        Request sol = new Request();
        sol.setCreatedAt(new Date());
        sol.setEmployeeId(request.getEmployeeId());
        sol.setDetail(request.getDetail());

        var hotels = request.getHotels();

        try {
            requestRepository.save(sol);
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while creating game");
        }

        for (HotelRequest hotel : hotels) {
            hotelClient.create(hotel);
        }

        RequestResponse response = new RequestResponse();
        response.setDetail(request.getDetail());
        response.setEmployeeId(request.getEmployeeId());
        response.setHotels(request.getHotels());
        response.setId(sol.getId());

        return response;

    }

    @Override
    public void delete(Long id) {
        try {
            requestRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while deleting game");
        }
    }

}
