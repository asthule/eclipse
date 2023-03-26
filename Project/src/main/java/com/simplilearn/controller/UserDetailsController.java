package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.model.UserDetails;
import com.simplilearn.service.UserDetailsService;

@Controller
public class UserDetailsController {

	@Autowired
    private UserDetailsService service;
   
   @RequestMapping("Login")
    public String  Login()
    {
    	return "Login";
    }
   
   @RequestMapping("signUp")
    public String  signUp()
    {
    	return "Signup";
    }
   

   @GetMapping("signedUp")
    public String  signedUp(@RequestParam String username,@RequestParam String password,UserDetails ud) throws ServletException, IOException
    {
    	service.saveUser(ud);
    	return "Login";
    }
   
   @RequestMapping("LoggedIn")
    public String  LoggedIn(@RequestParam String username,@RequestParam String password)
    {
	   System.out.println(service.getUserByName(username).getUsername());
   
     if(!(username.contentEquals(service.getUserByName(username).getUsername())))
    		  {
 
    	 return "Login";
    		  }
   
      System.out.println(username);


    	return "productspage";
    }
}
