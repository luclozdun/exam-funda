package com.request.request.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.request.exception.ResourceNotFoundExceptionRequest;
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
    private RequestRepository gameRepository;

    private RequestResponse convertToResponse(Request game) {
        RequestResponse response = new RequestResponse();
        response.setAge(game.getAge());
        response.setDescription(game.getDescription());
        response.setId(game.getId());
        response.setImage(game.getImage());
        response.setName(game.getName());
        response.setSubtitle(game.getSubtitle());
        response.setBackground(game.getBackground());

        return response;
    }

    private Request convertToEntity(RequestRequest request) {
        Request game = new Request();
        game.setAge(request.getAge());
        game.setDescription(request.getDescription());
        game.setImage(request.getImage());
        game.setName(request.getName());
        game.setSubtitle(request.getSubtitle());
        game.setBackground(request.getBackground());

        return game;
    }

    private Request convertToEntity(RequestRequest request, Long id) {
        Request game = new Request();
        game.setAge(request.getAge());
        game.setDescription(request.getDescription());
        game.setImage(request.getImage());
        game.setName(request.getName());
        game.setId(id);
        game.setSubtitle(request.getSubtitle());
        game.setBackground(request.getBackground());

        return game;
    }

    @Override
    public List<RequestResponse> getAll() {
        var entities = gameRepository.findAll();
        var response = entities.stream().map(entity -> convertToResponse(entity)).collect(Collectors.toList());
        return response;
    }

    @Override
    public RequestResponse getById(Long id) {
        var entity = gameRepository.getGameById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("Game not found"));
        var response = convertToResponse(entity);
        return response;
    }

    @Override
    public RequestResponse create(RequestRequest request) {

        var entity = convertToEntity(request);

        try {
            gameRepository.save(entity);
            var response = convertToResponse(entity);
            return response;
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while creating game");
        }
    }

    @Override
    public RequestResponse update(RequestRequest request, Long id) {
        var entity = gameRepository.getGameById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionRequest("Game not found"));

        entity = convertToEntity(request, id);

        try {
            gameRepository.save(entity);
            var response = convertToResponse(entity);
            return response;
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while updating game");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            gameRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionRequest("Error ocurred while deleting game");
        }
    }

}
