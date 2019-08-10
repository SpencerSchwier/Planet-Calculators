package com.techelevator.ssg.model.store;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<ShoppingCartItem> productsInCart;
	
	public ShoppingCart() {
		productsInCart = new ArrayList<ShoppingCartItem>();
	}
	
	public List<ShoppingCartItem> getProductsInCart(){
		return productsInCart;
	}
	
	public void addProductToCart(ShoppingCartItem item) {
		Boolean itemInCart = false;
		
		for(ShoppingCartItem p : productsInCart) {
			if(p.getName().equals(item.getName())) {
				int totalQty = p.getQuantity() + item.getQuantity();
				productsInCart.remove(p);
				item.setQuantity(totalQty);
				productsInCart.add(item);
				itemInCart = true;
			}
		}
		if(!itemInCart) {
			productsInCart.add(item);		

		}

	}
	
	public Double getShoppingCartTotal() {
		Double total = 0.0;
		for(ShoppingCartItem p : productsInCart) {
			total += p.getProductTotal();
		}
		
		return total;
	}

}
