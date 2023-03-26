package com.simplilearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.model.PurchasedProduct;

public interface PurchasedPrdouctsRepo extends JpaRepository<PurchasedProduct, Integer>{

	PurchasedProduct findByPid(int pid);

	PurchasedProduct findByPname(String pname);
}
