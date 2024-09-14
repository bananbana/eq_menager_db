package com.equestrian_manager.eq_manager_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equestrian_manager.eq_manager_db.models.Stable;

public interface StableRepository extends JpaRepository<Stable, Long> {

}
