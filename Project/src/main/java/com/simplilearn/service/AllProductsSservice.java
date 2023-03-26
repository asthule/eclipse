package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.AllProducts;
import com.simplilearn.repo.AllProductsRepo;

@Service
public class AllProductsSservice {

	 @Autowired
	    private AllProductsRepo repository;
	    public AllProducts getProductByPid(int pid) {
	        return repository.findByPid(pid);
	    }

	    public AllProducts getProductByPname(String pname) {
	        return repository.findByPname(pname);
	    }
	    
	    public List<AllProducts> getAllProductsById(String pname){
			return repository.findAllByPname(pname);

}

		public List<AllProducts> getAllProductsByPname(String search) {
			return repository.findAllByPname(search);
	
		}
		


		public List<AllProducts> findAll() {
			return repository.findAll();
		}

		
}
