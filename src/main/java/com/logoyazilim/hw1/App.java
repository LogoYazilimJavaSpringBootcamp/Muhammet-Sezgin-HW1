package com.logoyazilim.hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
    	CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.initializeCustomers();
       
        // tüm müşterileri listeleme
        System.out.println("Tüm Müşteriler:");
        customerList.stream().map(customer -> customer.getName())
        		.forEach(System.out::println); 
        
        // yeni müşteri oluşturun
        customerList.add(new Customer("Mert", "Eylül", customerService.prepareBill(), "Koç"));
        
        // içinde "C" harci bulunan müşterileri listeleyin
        System.out.println();
        System.out.println("İçinde C Harfi Olan Müşteriler:");
        customerList.stream().map(customer-> customer.getName())
        		.filter(customerName -> customerName.toLowerCase().contains("c"))
        		.forEach(System.out::println);
        
        // haziran ayında kayıt olan müşterilerin faturalarının toplam tutarını listeleyin
        System.out.println();
        System.out.println("Haziran Ayında Kayıt Olanların Faturaları Toplamı:");
        double sumOfBillOfJuneCustomers = customerList.stream()
        		.filter(signDate -> signDate.getSignDate().contentEquals("Haziran"))
        		.mapToDouble(customer -> customer.sumBills())
        		.sum();
        System.out.format("%.2f", sumOfBillOfJuneCustomers);
        
        // sistemdeki tüm faturaları listeleyin
        System.out.println();
        System.out.println("Sistemdeki Tüm Faturalar:");
	customerList.stream().forEach(customer -> customer.showBills());
	
	// her müşteri için faturaları yukarıda ayrı ayrı printledim
	// ayrıca tüm faturaları bir listeye topluyorum
	List<Bill> allBills = new ArrayList<>();
	allBills = customerList.stream().map(customer -> customer.getBillList())
			.flatMap(List::stream)
			.collect(Collectors.toList());
			
		
	// sistemdeki 1500 tl üstündeki faturaları listeleyin
	System.out.println();
	System.out.println("1500 TL Üstü Faturalar:");
	allBills.stream().filter(t -> t.sumProducts() > 1500)
			.forEach(t -> t.showProducts());
	
	// sistemdeki 1500 tl üstü faturaların ortalaması
	System.out.println();
	System.out.println("1500 TL Üstü Faturaların Ortalaması:");
	double averageOfHighBills = allBills.stream().filter(t -> t.sumProducts() > 1500)
			.mapToDouble(bill -> bill.sumProducts())
			.average().orElseThrow();
	
	System.out.format("%.2f", (double)averageOfHighBills);
	
	// sistemdeki 500 tl altı faturalara sahip müşteriler
	System.out.println();
	System.out.println("500 TL Altı Faturalara Sahip Müşteriler:");
	customerList.stream()
			.filter(customer -> customer.getBillList().stream()
					.anyMatch(bill -> bill.sumProducts() < 500))
			.map(customer -> customer.getName())
			.forEach(System.out::println);
	
	// haziran ayı faturalarının ortalaması 750 tl altı olan müşterilerin sektörleri
	System.out.println();
	System.out.println("750 TL Altı Faturası Olanların Firmaları:");
	customerList.stream()
			.filter(customer -> customer.getBillList().stream()
					.anyMatch(bill -> bill.sumProducts() < 500))
			.map(customer -> customer.getEmployee())
			.forEach(System.out::println);
    }
}
