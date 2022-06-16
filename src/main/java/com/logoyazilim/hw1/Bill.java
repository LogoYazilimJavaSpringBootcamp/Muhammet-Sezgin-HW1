package com.logoyazilim.hw1;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
	private List<Product> productList;
	private LocalDateTime date;
	
	public Bill(List<Product> productList) {
		this.productList = productList;
		this.date = LocalDateTime.now();
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public double sumProducts() {
		return productList.stream().mapToDouble(product -> product.getPrice())
				.sum();
	}
	
	public void showProducts() {
		System.out.println("Bill at Date " + date + ":");
		productList.stream().map(product -> (product.getType()+ " " + 
				String.format("%.2f", product.getPrice())))
				.forEach(System.out::println);
		
		System.out.println("Total: " + String.format("%.2f", this.sumProducts()));
		System.out.println();
	}
}
