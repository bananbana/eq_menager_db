package com.equestrian_manager.eq_manager_db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equestrian_manager.eq_manager_db.dtos.StableDto;
import com.equestrian_manager.eq_manager_db.dtos.UserDto;
import com.equestrian_manager.eq_manager_db.mappers.UserMapper;
import com.equestrian_manager.eq_manager_db.models.User;
import com.equestrian_manager.eq_manager_db.security.services.UserDetailsImpl;
import com.equestrian_manager.eq_manager_db.services.StableService;
import com.equestrian_manager.eq_manager_db.services.UserService;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StableService stableService;

    @GetMapping("user_details")
    public ResponseEntity<UserDto> getUserDetails(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(userService.getUserDetails(userDetails.getId()));
    }

    @GetMapping("all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = users.stream().map(userMapper::convertToDto).collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/stables")
    public ResponseEntity<List<StableDto>> getUsersStables(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<StableDto> stables = stableService.getUsersStables(userDetails.getId());
        return ResponseEntity.ok(stables);
    }

    @GetMapping("/stables/{stableId}")
    public ResponseEntity<StableDto> getStable(@PathVariable Long stableId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        StableDto stable = stableService.getStableById(stableId, userDetails.getId());
        return ResponseEntity.ok(stable);
    }

    @PostMapping("/stables/create")
    public ResponseEntity<StableDto> createStable(@RequestBody StableDto stableDto, Authentication authentication) {
        // TODO: process POST request
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        StableDto createdStable = stableService.createStable(stableDto, userDetails.getId());
        return new ResponseEntity<>(createdStable, HttpStatus.CREATED);
    }
}
