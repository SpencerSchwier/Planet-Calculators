package com.techelevator.ssg.model.store;

public class ShoppingCartItem extends Product{
	
	private int quantity;
	private Product product;
	private String name;
	private DollarAmount price;
	private String imageName;
	private Double productTotal;
	
	public ShoppingCartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DollarAmount getPrice() {
		return price;
	}

	public void setPrice(DollarAmount price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Double getProductTotal() {
		Double dollars = price.getDollars() * (double)quantity;
		Double cents = (price.getCents() * (double)quantity) / 100; 
		Double totalCost = dollars + cents;
		return totalCost;
	}

	

}
