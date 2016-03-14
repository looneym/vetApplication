package model;

import controller.ManageCustomers;
import javafx.beans.property.SimpleStringProperty;


public class Pet {

	private  SimpleStringProperty name;
	private  SimpleStringProperty type;
	private Customer owner;

	public Pet (String name, String type, Customer _owner) {
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.owner = _owner;
		_owner.addPet(this);
		ManageCustomers.addPet(this);

	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set (name);
	}

	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set (type);
	}

	public SimpleStringProperty nameProperty (){
		return name;
	}





	public SimpleStringProperty typeProperty (){
		return type;
	}

	public String toString(){
		return name.get();
	}

	public void setOwner(Customer owner){
		this.owner = owner;


	}

	public Object getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}




}