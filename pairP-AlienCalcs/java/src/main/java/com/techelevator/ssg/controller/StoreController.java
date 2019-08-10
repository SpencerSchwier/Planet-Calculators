package com.techelevator.ssg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;
import com.techelevator.ssg.model.store.ShoppingCart;
import com.techelevator.ssg.model.store.ShoppingCartItem;

@Controller
public class StoreController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/spaceStore")
	public String displaySpaceStore(ModelMap modelMap) {
		modelMap.put("products", productDao.getAllProducts());
		return "spaceStore";
	}
	
	@RequestMapping("/spaceStore/productDetail")
	public String showProductDetail(@RequestParam Long id, HttpServletRequest request) {
		Product product = productDao.getProductById(id);
		request.setAttribute("product", product);
		return "productDetail";
	}
	
	@RequestMapping(path="/spaceStore/shoppingCart", method=RequestMethod.GET)
	public String showShoppingCart() {
		return "shoppingCart";
	}
	
	@RequestMapping(path="/spaceStore/shoppingCart", method=RequestMethod.POST)
	public String updateShoppingCart(@RequestParam Long product, 
									 @RequestParam int quantity,
									 HttpSession session) {
		
		ShoppingCart cart;
		
		if(session.getAttribute("customerCart") == null) {
			cart = new ShoppingCart();
		} else {
			cart = (ShoppingCart)session.getAttribute("customerCart");
		}
		
		Product p = productDao.getProductById(product);
		ShoppingCartItem item = new ShoppingCartItem(p, quantity);
		item.setName(p.getName());
		item.setPrice(p.getPrice());
		item.setImageName(p.getImageName());

		cart.addProductToCart(item);
		
		session.setAttribute("customerCart", cart);
		
		return "redirect:/spaceStore/shoppingCart";
	}
	
	@RequestMapping("/thankYou")
	public String displayThankYou(HttpSession session) {
		session.removeAttribute("customerCart");
		return "thankYou";
	}

}
