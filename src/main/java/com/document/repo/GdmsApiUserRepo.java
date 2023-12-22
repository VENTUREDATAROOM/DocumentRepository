package com.document.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.document.entity.GdmsApiUsers;

public interface GdmsApiUserRepo extends JpaRepository<GdmsApiUsers, String> {

	GdmsApiUsers findByName(String name);

	Optional<GdmsApiUsers> findByUsername(String username);
    Optional<GdmsApiUsers> findByEmail(String email);
	
};



