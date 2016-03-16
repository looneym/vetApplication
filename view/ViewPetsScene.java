package view;

import controller.ManageCustomers;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;
import model.Pet;
import model.Procedure;

public class ViewPetsScene {
	
	public static void showScene(TableView<Customer> table, Scene customersPage, Stage stage){
		
		final Label labelPetsList = new Label("Pet List");
		Button editPetButton = new Button("Edit Pet");
		Button addPetButton = new Button("Add Pet");
		Button deletePetButton = new Button("Delete Pet");
		Button returnHomeButton = new Button("Return to main page");
		Button showProceduresButton = new Button("Show customer procedures");
		
		
		Customer selectedCustomer = (Customer) table.getSelectionModel().getSelectedItem();


		// Set up TableView to read from list of pets
		TableView<Pet> petsTable = new TableView<Pet>();
		petsTable.setItems(ManageCustomers.getCustomerPets(selectedCustomer));
		
		TableColumn<Pet, String> nameCol = new TableColumn<Pet, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		
		TableColumn<Pet, String> typeCol = new TableColumn<Pet, String>("Type");
		typeCol.setCellValueFactory(new PropertyValueFactory("type"));
		
		TableColumn<Pet, String> ownerCol = new TableColumn<Pet, String>("Owner");
		ownerCol.setCellValueFactory(new PropertyValueFactory("owner"));	
		
		petsTable.getColumns().setAll(nameCol, typeCol, ownerCol);
		petsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		petsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		

		// Add TableView to a VBox
		final VBox vboxPets = new VBox();
		vboxPets.setSpacing(5);
		vboxPets.setPadding(new Insets(10, 0, 0, 10));
		vboxPets.getChildren().addAll(labelPetsList, petsTable);
		
		final VBox vboxRight = new VBox();
		vboxRight.setSpacing(5);	
		vboxRight.setPadding(new Insets(50, 10, 0, 10));	
		vboxRight.getChildren().addAll(editPetButton, addPetButton, deletePetButton, returnHomeButton, showProceduresButton);
		
		BorderPane viewPetsBorderPane = new BorderPane();
		viewPetsBorderPane.setCenter(vboxPets);
		viewPetsBorderPane.setRight(vboxRight);
		
		Scene viewPetsScene = new Scene(viewPetsBorderPane);		
		stage.setScene(viewPetsScene);
		stage.show();
		
		
		 
		// Set event handlers for buttons
		returnHomeButton.setOnAction(e -> {
			stage.setScene(customersPage);
		});
		showProceduresButton.setOnAction(e ->{ViewProceduresScene.showScene(customersPage, viewPetsScene, stage, selectedCustomer);});
		editPetButton.setOnAction(e -> EditPetScene.editScene(petsTable, stage, customersPage));
		addPetButton.setOnAction(f -> AddPetScene.addPet(stage, selectedCustomer, customersPage));
		deletePetButton.setOnAction(g -> {
			
			Pet pet = (Pet) petsTable.getSelectionModel().getSelectedItem();
			ManageCustomers.removePet(pet);
			
		});
		
	}

}
