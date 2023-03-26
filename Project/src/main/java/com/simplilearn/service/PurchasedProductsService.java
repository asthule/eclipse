package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.PurchasedProduct;
import com.simplilearn.repo.PurchasedPrdouctsRepo;

@Service
public class PurchasedProductsService {

	
	@Autowired
	private PurchasedPrdouctsRepo repository;
    public PurchasedProduct saveUser(PurchasedProduct pp) {
        return repository.save(pp);
    } 
    
    public PurchasedProduct getProductByPid(int pid) {
        return repository.findByPid(pid);
    }

    public PurchasedProduct getProductByPname(String pname) {
        return repository.findByPname(pname);
        
    }
   public List<PurchasedProduct> findAll() {
			return repository.findAll();
		}
}
