package com.request.request.controller;

import java.util.List;

import com.request.request.dto.RequestRequest;
import com.request.request.dto.RequestResponse;
import com.request.request.entity.Request;
import com.request.request.service.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class RequestController {

    @Autowired
    private RequestService gameService;

    @GetMapping
    private ResponseEntity<List<Request>> getAll() {
        var response = gameService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<RequestResponse> getById(@PathVariable("id") Long id) {
        var response = gameService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<RequestResponse> create(@RequestBody RequestRequest request) {
        var response = gameService.create(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        gameService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
