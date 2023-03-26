package com.simplilearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.model.AllProducts;

public interface AllProductsRepo extends JpaRepository<AllProducts, Integer> {

	AllProducts findByPid(int pid);
	
	AllProducts findByPname(String pname);
	
	List<AllProducts> findAllByPname(String pname);
	
}
