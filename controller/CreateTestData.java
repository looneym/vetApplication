package controller;

import model.Customer;
import model.Pet;
import model.Procedure;

public class CreateTestData {
	
	public static void createCustomerList(){
		
		Customer john = new Customer("John", "Cork");
		Customer mike = new Customer("Mike", "Dublin");
		Customer paul = new Customer("Paul", "Kerry");
		
		Pet spike = new Pet("Spike", "Dog",  john);
		Pet spot = new Pet("Spot", "Lizard",  mike);
		Pet fluffy = new Pet("Fluffy","Cat", paul);
		
		Procedure p1 = new Procedure("surgery", "20.33", "MAr 10", john);

		
		
	}

}
