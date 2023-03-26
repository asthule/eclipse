package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.ProductModel;
import com.simplilearn.repo.ProductsRepo;

@Service
public class ProductService {

	
	@Autowired
    private ProductsRepo repository;

    public ProductModel saveProduct(ProductModel product) {
        return repository.save(product);
    }

    public List<ProductModel> saveProducts(List<ProductModel> products) {
        return repository.saveAll(products);
    }

    public List<ProductModel> getProducts() {
        return repository.findAll();
    }

    public ProductModel getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public ProductModel getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }
    


    public ProductModel updateProduct(ProductModel product) {
    	ProductModel existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQty(product.getQty());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
