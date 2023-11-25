package com.document.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.document.entity.EntranceUser;

public interface UserEntranceRepo  extends JpaRepository<EntranceUser,Integer>{
	
	EntranceUser findByUsername(String username);

}
