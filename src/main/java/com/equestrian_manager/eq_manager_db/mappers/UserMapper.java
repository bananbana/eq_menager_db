package com.equestrian_manager.eq_manager_db.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equestrian_manager.eq_manager_db.dtos.UserDto;
import com.equestrian_manager.eq_manager_db.models.Role;
import com.equestrian_manager.eq_manager_db.models.Stable;
import com.equestrian_manager.eq_manager_db.models.User;
import com.equestrian_manager.eq_manager_db.repositories.StableRepository;

@Service
public class UserMapper {

    @Autowired
    StableRepository stableRepository;

    public UserDto convertToDto(User user) {
        UserDto newUser = new UserDto();

        List<Long> stableIds = user.getStables().stream().map(Stable::getId).collect(Collectors.toList());
        List<Long> roleIds = user.getRoles().stream().map(Role::getId).collect(Collectors.toList());

        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        newUser.setId(user.getId());
        newUser.setRoles(roleIds);
        newUser.setStableIds(stableIds);

        return newUser;
    }

    public User convertToEntity(UserDto userDto) {
        User newUser = new User();

        newUser.setId(userDto.getId());
        newUser.setEmail(userDto.getEmail());
        newUser.setFullName(userDto.getFullName());

        return newUser;
    }
}
