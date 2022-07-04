package com.hotel.hotel.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.exception.ResourceNotFoundExceptionRequest;
import com.hotel.hotel.dto.HotelRequest;
import com.hotel.hotel.dto.HotelResponse;
import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.repository.HotelRepository;
import com.hotel.hotel.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository gameRepository;

    private HotelResponse convertToResponse(Hotel entity) {
        HotelResponse response = new HotelResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmployeeId(entity.getEmployeeId());
        response.setPrice(entity.getPrice());
        return response;
    }

    private Hotel convertToEntity(HotelRequest request) {
        Hotel entity = new Hotel();
        entity.setName(request.getName());
        entity.setEmployeeId(request.getEmployeeId());
        entity.setPrice(request.getPrice());
        return entity;
    }

    private Hotel convertToEntity(HotelRequest request, Long id) {
        Hotel entity = new Hotel();
        entity.setId(id);
        entity.setName(request.getName());
        entity.setEmployeeId(request.getEmployeeId());
        entity.setPrice(request.getPrice());
        return entity;
    }

    @Override
    public List<HotelResponse> getAll() {
        var entities = gameRepository.findAll();
        var response = entities.stream().map(entity -> convertToResponse(entity)).collect(Collectors.toList());
        return response;
    }

    @Override
    public HotelResponse getById(Long id) {
        var entity = gameRepository.getGameById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("Hotel not found"));
        var response = convertToResponse(entity);
        return response;
    }

    @Override
    public HotelResponse create(HotelRequest request) {

        var entity = convertToEntity(request);

        try {
            gameRepository.save(entity);
            var response = convertToResponse(entity);
            return response;
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while creating hotel");
        }
    }

    @Override
    public HotelResponse update(HotelRequest request, Long id) {
        var entity = gameRepository.getGameById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("Hotel not found"));

        entity = convertToEntity(request, id);

        try {
            gameRepository.save(entity);
            var response = convertToResponse(entity);
            return response;
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while updating hotel");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            gameRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while deleting hotel");
        }
    }

}
