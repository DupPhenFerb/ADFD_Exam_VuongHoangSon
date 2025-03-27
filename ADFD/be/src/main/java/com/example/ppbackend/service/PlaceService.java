package com.example.ppbackend.service;



import com.example.ppbackend.model.Place;
import com.example.ppbackend.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Transactional(readOnly = true)
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Place> getPlacesByProvince(String province) {
        return placeRepository.findByProvince(province);
    }

    @Transactional(readOnly = true)
    public List<Place> getTopRatedPlaces(Double minRating) {
        return placeRepository.findTopRatedPlaces(minRating);
    }

    @Transactional
    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    @Transactional(readOnly = true)
    public Optional<Place> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }
}