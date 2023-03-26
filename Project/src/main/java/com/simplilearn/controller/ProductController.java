package com.simplilearn.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.model.ProductModel;
import com.simplilearn.service.ProductService;

@Controller
public class ProductController {

	
	@Autowired
private ProductService service;
    

    @GetMapping("productspage")
    public String productspage(@RequestParam String username,@RequestParam String password)
    {
    
    	
    	System.out.println(username);
    	System.out.println(password);
    	return "productspage";
    }
    
    @RequestMapping("addProduct")
    public String  addProduct(@RequestParam String name,@RequestParam int qty,@RequestParam double price, ProductModel product) throws ServletException, IOException
    {
    
    	service.saveProduct(product);
    	return "Payment";
    }

    @RequestMapping("AdminLogin")
    public String  adminLogin() 
    {
    	return "AdminLogin";
    	    
    }
    @RequestMapping("AdminUI")
    public String  adminUI(@RequestParam String username,@RequestParam String password) 
    {
    	if(!((username.contentEquals("admin"))&&password.contentEquals("admin")))
    	{
    		return "AdminLogin";
    	}
    	return "AdminUI";
    }
    @RequestMapping("SearchProducts")
    public String  SearchProducts() 
    {
    	return "SearchProducts";
    	    
    }
    @RequestMapping("SearchHistory")
    public String  SearchHistory() 
    {
    	return "SearchHistory";
    	    
    }

}
