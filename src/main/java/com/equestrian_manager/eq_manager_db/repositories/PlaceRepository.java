package com.equestrian_manager.eq_manager_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equestrian_manager.eq_manager_db.models.Place;
import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByStableId(Long stableId);
}
