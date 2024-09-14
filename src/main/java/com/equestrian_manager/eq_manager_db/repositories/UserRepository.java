package com.equestrian_manager.eq_manager_db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equestrian_manager.eq_manager_db.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
