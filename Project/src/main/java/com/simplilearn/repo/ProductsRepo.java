package com.simplilearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.model.ProductModel;

public interface ProductsRepo extends JpaRepository<ProductModel, Integer> {

	ProductModel findByName(String name);
	 ProductModel findAllByName(String name);
}
