package com.equestrian_manager.eq_manager_db.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equestrian_manager.eq_manager_db.dtos.PlaceDto;
import com.equestrian_manager.eq_manager_db.models.Place;
import com.equestrian_manager.eq_manager_db.models.Stable;
import com.equestrian_manager.eq_manager_db.services.StableService;;;

@Service
public class PlaceMapper {

    @Autowired
    StableService stableService;

    public PlaceDto convertToDto(Place place) {
        PlaceDto newPlace = new PlaceDto();

        newPlace.setId(place.getId());
        newPlace.setStableId(place.getStable().getId());
        newPlace.setColor(place.getColor());
        newPlace.setImgUrl(place.getImgUrl());
        newPlace.setName(place.getName());

        return newPlace;
    }

    public Place convertToEntity(PlaceDto placeDto) {
        Place newPlace = new Place();

        Long stableId = placeDto.getStableId();
        if (stableId == null) {
            throw new IllegalArgumentException("Stable ID must not be null");
        }

        Stable stable = stableService.getStableById(stableId);

        newPlace.setId(placeDto.getId());
        newPlace.setName(placeDto.getName());
        newPlace.setStable(stable);

        return newPlace;
    }

}
