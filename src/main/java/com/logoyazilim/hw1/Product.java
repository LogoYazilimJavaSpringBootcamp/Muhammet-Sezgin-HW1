package com.logoyazilim.hw1;

public class Product {
	private final String type;
	private final Double price;
	
	public Product(String type, Double price){
		this.type = type;
		this.price = price;
	}
	
	public String getType() {
		return type;
	}

	public Double getPrice() {
		return price;
	}
}
