package com.simplilearn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.model.PurchasedProduct;
import com.simplilearn.service.PurchasedProductsService;

@Controller
public class PurchasedController {

	@Autowired
    private PurchasedProductsService service;
    
    @RequestMapping("paymentDone")
    public String paymentDone(HttpServletRequest request,@RequestParam String address,@RequestParam String emailid,PurchasedProduct pp)
    {
    	HttpSession session = request.getSession();
        pp.setEmail(emailid);
        pp.setAddress(address);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        pp.setDateofpurchase(str);
        System.out.println(str);
    	String pname=(String) session.getAttribute("name");
    	pp.setPname((String) session.getAttribute("name"));
    	if(pname.equalsIgnoreCase("Modern Sporty Look"))
    	{
    		pp.setPid(1);
    	}
    	else if(pname.equalsIgnoreCase("Classy Sporty Wear"))
    	{
    		pp.setPid(2);
    	}
    	else if(pname.equalsIgnoreCase("Perfect Gym Shoes"))
    	{
    		pp.setPid(3);
    	}
    	service.saveUser(pp);
    	return "paymentDone";
    }
    
    
    @GetMapping("SearchPurchases")
    public String SearchPurchases(@RequestParam String search,@RequestParam String searchoption,PurchasedProduct pp) {
        if(searchoption.equalsIgnoreCase("pid"))
        {
        	System.out.println(searchoption);
        	return "productByPid";
  
        }
          return  "productByPname";
     
    }
    
    @RequestMapping("productByPid")
    public String findProductByPid(HttpServletRequest request,@RequestParam int search,@RequestParam String searchoption) {
        HttpSession session =  request.getSession();
     	String pname=(service.getProductByPid(search)).getPname();
    	session.setAttribute("pname", pname);
    	String address=(service.getProductByPid(search)).getAddress();
    	session.setAttribute("address", address);
    	String dateofpurchase=(service.getProductByPid(search)).getDateofpurchase();
    	session.setAttribute("dateofpurchase", dateofpurchase);
    	String email=(service.getProductByPid(search)).getEmail();
    	session.setAttribute("email", email);
         return "productByPid";
    }

    @GetMapping("productByPname")
    public String findproductByPname(HttpServletRequest request,@RequestParam String search,@RequestParam String searchoption) {
        HttpSession session =  request.getSession();
      	int pid=(service.getProductByPname(search)).getPid();
     	session.setAttribute("pid", pid);
     	String address=(service.getProductByPname(search)).getAddress();
     	System.out.println((service.getProductByPname(search)).getAddress());
     	session.setAttribute("address", address);
     	String dateofpurchase=(service.getProductByPname(search)).getDateofpurchase();
     	session.setAttribute("dateofpurchase", dateofpurchase);
     	String email=(service.getProductByPname(search)).getEmail();
     	session.setAttribute("email", email);
 
    	return "productByPname";
    }
	
}
