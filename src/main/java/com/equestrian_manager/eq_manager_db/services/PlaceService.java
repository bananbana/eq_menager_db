package com.equestrian_manager.eq_manager_db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

import com.equestrian_manager.eq_manager_db.dtos.PlaceDto;
import com.equestrian_manager.eq_manager_db.mappers.PlaceMapper;
import com.equestrian_manager.eq_manager_db.models.Place;
import com.equestrian_manager.eq_manager_db.repositories.PlaceRepository;
import com.equestrian_manager.eq_manager_db.repositories.StableRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlaceService {

    @Autowired
    private StableRepository stableRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private PlaceMapper placeMapper;

    public List<PlaceDto> findAllByStableId(Long stableId) {

        List<Place> placesByStableId = placeRepository.findByStableId(stableId);

        if (!stableRepository.existsById(stableId)) {
            throw new EntityNotFoundException("Stable with ID " + stableId + " not found.");
        }

        List<PlaceDto> placeDtos = new ArrayList<>();
        for (Place place : placesByStableId) {
            placeDtos.add(placeMapper.convertToDto(place));
        }
        return placeDtos;
    }

    public PlaceDto createPlace(PlaceDto placeDto, Long stableId) {
        placeDto.setStableId(stableId);
        Place newPlace = placeMapper.convertToEntity(placeDto);
        Place savedPlace = this.placeRepository.save(newPlace);

        return placeMapper.convertToDto(savedPlace);
    }

    public Place getPlaceById(Long placeId) {
        return placeRepository.findById(placeId).get();
    }

    @Transactional
    public void deletePlace(Long placeId) {
        placeRepository.deleteById(placeId);
    }
}
