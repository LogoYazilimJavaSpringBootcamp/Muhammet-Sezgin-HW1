package com.logoyazilim.hw1;

import java.util.List;

public class Customer {
	private String name;
	private String signDate;
	private String employee;
	private List<Bill> billList;
	
	public Customer(String name, String signDate, List<Bill> billList, String employee) {
		this.name = name;
		this.signDate = signDate;
		this.billList = billList;
		this.employee = employee;
	}
	
	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	public String getSignDate() {
		return signDate;
	}

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double sumBills() {
		return billList.stream().mapToDouble(bill -> bill.sumProducts())
				.sum();
	}
	
	public void showBills() {
		System.out.println("Bills Of " + this.name + ":");
		billList.stream().forEach(t -> t.showProducts());
		System.out.println();
		System.out.println();
	}
}
