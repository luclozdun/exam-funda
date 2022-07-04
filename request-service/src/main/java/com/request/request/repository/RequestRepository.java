package com.request.request.repository;

import java.util.Optional;

import com.request.request.entity.Request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    Optional<Request> getGameById(Long id);
}
