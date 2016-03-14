package model;

import controller.ManageCustomers;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {

	    private  SimpleStringProperty firstName;
	    private  SimpleStringProperty address;
	    private ObservableList<Pet> pets;
	    private ObservableList<Procedure> procedures;

	    public Customer (String fName, String address) {
	        this.firstName = new SimpleStringProperty(fName);
	        this.address = new SimpleStringProperty(address);
			ManageCustomers.addCustomer(this);


	    }
	    
	    public Customer (String fName, String address, ObservableList<Pet> pets) {
	        this.firstName = new SimpleStringProperty(fName);
	        this.address = new SimpleStringProperty(address);
	        this.pets = pets;
			ManageCustomers.addCustomer(this);


	    }

	    public String getFirstName() {
	        return firstName.get();
	    }
	    public void setFirstName(String fName) {
	        firstName.set(fName);
	    }

	    public SimpleStringProperty firstNameProperty (){
	    	return firstName;
	    }

	    public String getAddress() {
	        return address.get();
	    }
	    public void setAddress (String add) {
	    	address.set(add);
	    }

	    public SimpleStringProperty addressProperty (){
	    	return address;
	    }

	    public String toString(){
	    	return firstName.get();
	    }

		public void addPet(Pet pet) {
			if (pets != null) {
				pets.add(pet);
			} else {
				
				pets = FXCollections.observableArrayList();
				pets.add(pet);
			}
			
			
		}
	    
	    


}