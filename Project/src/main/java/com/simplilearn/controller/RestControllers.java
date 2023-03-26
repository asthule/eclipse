package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.simplilearn.model.ProductModel;
import com.simplilearn.service.ProductService;

@Controller
public class RestControllers {

	@Autowired
    private ProductService service;
    
//    @RequestMapping("addProduct")
//    public String addProduct(@RequestParam String name,@RequestParam int qty,@RequestParam double price, ProductModel product)
//    {
//    	return "Payment.jsp";
//    }
//	
    

//    @GetMapping("/addProduct")
//    public ProductModel addProduct(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam String name,@RequestParam int qty,@RequestParam double price, ProductModel product) throws ServletException, IOException {
//
//    	System.out.println(name);
//    	 model.addAttribute(name);
////    	request.setAttribute("name", name);
////		request.setAttribute("qty", qty);
////		request.setAttribute("price", price);
////		RequestDispatcher rd = request.getRequestDispatcher("/pages/Payment.jsp");
////		rd.forward(request, response);
//    	return service.saveProduct(product);
//    }

    @PostMapping("/addProducts")
    public List<ProductModel> addProducts(@RequestBody List<ProductModel> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<ProductModel> findAllProducts() {
        return service.getProducts();
    }



    @PutMapping("/update")
    public ProductModel updateProduct(@RequestBody ProductModel product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
