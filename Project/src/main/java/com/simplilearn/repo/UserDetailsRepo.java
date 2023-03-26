package com.simplilearn.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer>{

	UserDetails findByUsername(String username);
	
	
	
}
