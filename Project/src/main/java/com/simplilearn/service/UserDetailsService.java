package com.simplilearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.UserDetails;
import com.simplilearn.repo.UserDetailsRepo;

@Service
public class UserDetailsService {

	
	@Autowired
    private UserDetailsRepo repository;
    


    public UserDetails saveUser(UserDetails ud) {
        return repository.save(ud);
    }      
        public UserDetails getUserByName(String username) {
 
            return repository.findByUsername(username);
        }
}
