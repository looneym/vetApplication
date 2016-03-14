package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import model.Pet;
import model.Procedure;

public class ManageCustomers {
	
public static ObservableList<Customer> allCustomers;
public static ObservableList<Pet> allPets;
public static ObservableList<Pet> matchedPets;
public static ObservableList<Procedure> matchedProcedures;
public static ObservableList<Procedure> allProcedures;

	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////
	//////////                   Customer stuff 
	/////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ObservableList<Customer> getAllCustomers(){
		return allCustomers;
				
	}
	
	public static void setAllCustomers(ObservableList<Customer> _allCustomers){
		allCustomers = _allCustomers;
	}
	
	public static void deleteCustomer(Customer customer){
		allCustomers.remove(customer);
	}
	
	public static void addCustomer(Customer newCustomer){
		if (allCustomers != null){
			
			allCustomers.add(newCustomer);
		} else {
			allCustomers = FXCollections.observableArrayList();
			allCustomers.add(newCustomer);
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////
	//////////                   Pet stuff 
	/////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ObservableList<Pet> getAllPets(){
		return allPets;
				
	}
	
	public static void setAllPets(ObservableList<Pet> pets){
		allPets = pets;
	}
	
	public static void addPet(Pet pet){
		if (allPets != null){
			allPets.add(pet);
		} else {
			allPets = FXCollections.observableArrayList();
			allPets.add(pet);
		}
	}
	
	public static void removePet(Pet pet){
		
		allPets.remove(pet);
	}
	
	public static ObservableList<Pet> getCustomerPets(Customer customer){
		matchedPets = FXCollections.observableArrayList();
		
		for (int i = 0; i < allPets.size(); i++) {
			Pet pet = allPets.get(i);
			if (pet.getOwner().equals(customer)){
				matchedPets.add(pet);
			}
			
		}
		
		return matchedPets;
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////
	//////////                   Procedure stuff 
	/////////
	////////////////////////////////////////////////////////////////////////////////////////////
	
    public static ObservableList<Procedure> getAllProcedures(){
        return allProcedures;
                
    }
    
    public static void setAllProcedures(ObservableList<Procedure> procedures){
        allProcedures = procedures;
    }
    
    public static void addProcedure(Procedure procedure){
        if (allProcedures != null){
            allProcedures.add(procedure);
        } else {
            allProcedures = FXCollections.observableArrayList();
            allProcedures.add(procedure);
        }
    }
    
    public static void removeProcedure(Procedure procedure){
        
        allProcedures.remove(procedure);
    }
    
    public static ObservableList<Procedure> getCustomerProcedures(Customer customer){
        matchedProcedures = FXCollections.observableArrayList();
        
        for (int i = 0; i < allProcedures.size(); i++) {
            Procedure procedure = allProcedures.get(i);
            if (procedure.getOwner().equals(customer)){
                matchedProcedures.add(procedure);
            }
            
        }
        
        return matchedProcedures;
        
    }

	

}
