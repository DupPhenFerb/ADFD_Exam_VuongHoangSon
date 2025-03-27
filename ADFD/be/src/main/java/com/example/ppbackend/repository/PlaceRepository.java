package com.example.ppbackend.repository;


import com.example.ppbackend.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    // Find places by province
    List<Place> findByProvince(String province);

    // Custom query to find top-rated places
    @Query("SELECT p FROM Place p WHERE p.rating >= :minRating ORDER BY p.rating DESC")
    List<Place> findTopRatedPlaces(@Param("minRating") Double minRating);
}