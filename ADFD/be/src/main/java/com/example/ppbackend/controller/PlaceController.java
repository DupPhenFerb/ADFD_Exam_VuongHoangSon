package com.example.ppbackend.controller;


import com.example.ppbackend.model.Place;

import com.example.ppbackend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/province/{province}")
    public List<Place> getPlacesByProvince(@PathVariable String province) {
        return placeService.getPlacesByProvince(province);
    }

    @GetMapping("/top-rated")
    public List<Place> getTopRatedPlaces(
            @RequestParam(defaultValue = "4.0") Double minRating) {
        return placeService.getTopRatedPlaces(minRating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
