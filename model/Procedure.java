package model;

import controller.ManageCustomers;

public class Procedure {
	
	private String name;
	private String price;
	private String date;
	private Customer owner;
	
	public Procedure(String name2, String price2, String date2, Customer owner2) {
		name = name2;
		price = price2;
		date = date2;
		owner2 = owner;
		ManageCustomers.addProcedure(this);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public void setOwner(Customer owner){
		this.owner = owner;


	}

	public Object getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}
	

}
