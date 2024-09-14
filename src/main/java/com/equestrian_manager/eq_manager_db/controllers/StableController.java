package com.equestrian_manager.eq_manager_db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equestrian_manager.eq_manager_db.dtos.StableDto;
import com.equestrian_manager.eq_manager_db.security.services.UserDetailsImpl;
import com.equestrian_manager.eq_manager_db.services.StableService;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("stables")
public class StableController {
    @Autowired
    private StableService stableService;

    @GetMapping
    public ResponseEntity<List<StableDto>> getAllUsersStables(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<StableDto> stables = stableService.getUsersStables(userDetails.getId());
        return new ResponseEntity<>(stables, HttpStatus.OK);
    }

}
