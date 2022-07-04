package com.hotel.hotel.repository;

import java.util.Optional;

import com.hotel.hotel.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> getGameById(Long id);
}
