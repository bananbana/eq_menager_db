package com.equestrian_manager.eq_manager_db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.NoSuchElementException;

import com.equestrian_manager.eq_manager_db.dtos.StableDto;
import com.equestrian_manager.eq_manager_db.mappers.StableMapper;
import com.equestrian_manager.eq_manager_db.models.Stable;
import com.equestrian_manager.eq_manager_db.models.User;
import com.equestrian_manager.eq_manager_db.repositories.StableRepository;

@Service
public class StableService {

    @Autowired
    private StableRepository stableRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private StableMapper stableMapper;

    public StableDto getStableById(Long stableId, Long userId) {
        User user = userService.getUserById(userId);
        Stable stable = user.getStables().stream().filter(b -> b.getId().equals(stableId)).findFirst()
                .orElseThrow(NoSuchElementException::new);

        return stableMapper.convertToDto(stable);
    }

    public List<StableDto> getUsersStables(Long userId) {
        User user = userService.getUserById(userId);

        Set<Stable> stables = user.getStables();
        List<StableDto> stableDtos = stables.stream().map(stableMapper::convertToDto).toList();
        return stableDtos;
    }

    public StableDto createStable(StableDto stableDto, Long userId) {
        User user = userService.getUserById(userId);
        Stable newStable = stableMapper.convertToEntity(stableDto);
        newStable.setOwner(user);
        user.getOwnedStables().add(newStable);
        Stable savedStable = stableRepository.save(newStable);
        return stableMapper.convertToDto(savedStable);
    }

}
