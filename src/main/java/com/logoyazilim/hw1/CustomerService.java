package com.logoyazilim.hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerService {
	
	public List<Customer> initializeCustomers() {
		List<Customer> initialCustomers = new ArrayList<>();
		initialCustomers.add(new Customer("Mehmet", "Haziran", prepareBill(), "Türk Telekom"));
		initialCustomers.add(new Customer("Kerem", "Temmuz", prepareBill(), "Logo Yazılım"));
		initialCustomers.add(new Customer("Cansu", "Nisan", prepareBill(), "Ford"));
		initialCustomers.add(new Customer("Bilal", "Haziran", prepareBill(), "Ziraat Bankası"));
		initialCustomers.add(new Customer("Hatice", "Ocak", prepareBill(), "Borusan"));
		initialCustomers.add(new Customer("Fatma", "Kasım", prepareBill(),	"Defacto"));
		initialCustomers.add(new Customer("Melisa", "Haziran", prepareBill(), "Microsoft"));
		initialCustomers.add(new Customer("Kadir", "Mart", prepareBill(), "Tübitak"));
		return initialCustomers;
	}
	
	public List<Bill> prepareBill() {
		List<Bill> bills = new ArrayList<>();
		int billNumber = new Random().nextInt(5);
		
		for (int i = 0; i < billNumber; i++) {
			Bill bill = new Bill(fillBill(billNumber));
			bills.add(bill);
		}
		return bills;
	}
	
	private List<Product> fillBill(int billNumber) {
		List<Product> products = new ArrayList<>();
		Random random = new Random();
		products.add(new Product("Laptop", random.nextDouble(900)));
		products.add(new Product("Suit", random.nextDouble(1100)));
		products.add(new Product("Phone", random.nextDouble(1000)));
		products.add(new Product("Car Toy", random.nextDouble(700)));
		products.add(new Product("Headphone", random.nextDouble(600)));
		products.add(new Product("Camera", random.nextDouble(800)));

		return products.stream().limit(billNumber).toList();
	}
}
