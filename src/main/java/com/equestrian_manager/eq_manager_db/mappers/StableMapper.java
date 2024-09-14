package com.equestrian_manager.eq_manager_db.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equestrian_manager.eq_manager_db.dtos.StableDto;
import com.equestrian_manager.eq_manager_db.models.Place;
import com.equestrian_manager.eq_manager_db.models.Stable;
import com.equestrian_manager.eq_manager_db.models.User;
import com.equestrian_manager.eq_manager_db.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StableMapper {

    @Autowired
    private UserRepository userRepository;

    public StableDto convertToDto(Stable stable) {
        StableDto newStable = new StableDto();

        List<Long> placesIds = stable.getPlaces().stream().map(Place::getId).collect(Collectors.toList());
        List<Long> clientsIds = stable.getClients().stream().map(User::getId).collect(Collectors.toList());

        newStable.setId(stable.getId());
        newStable.setClientsIds(clientsIds);
        newStable.setPlacesIds(placesIds);
        newStable.setName(stable.getName());
        newStable.setOwnerId(stable.getOwner().getId());

        return newStable;
    }

    public Stable convertToEntity(StableDto stableDto) {
        Stable newStable = new Stable();

        newStable.setId(stableDto.getId());
        newStable.setName(stableDto.getName());
        newStable.setOwner(userRepository.findById(stableDto.getOwnerId()).orElseThrow());

        return newStable;
    }
}
