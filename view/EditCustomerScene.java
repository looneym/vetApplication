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
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;
import model.Pet;

public class EditCustomerScene {
	
	public static void editScene(TableView table, Scene customersPage, Stage stage){	
		

		final Label labelPetsList = new Label("Pet List");
		Button returnHomeButton = new Button("Return to main page");
		returnHomeButton.setOnAction(e -> stage.setScene(customersPage));

		// Identify which customer the user wants to edit
		Customer customerToEdit = (Customer) table.getSelectionModel().getSelectedItem();
		
	

		// Create TextFields and a button to allow the user to update the details
		TextField nameInput = new TextField();
		nameInput.setText(customerToEdit.getFirstName());
		TextField addressInput = new TextField();
		addressInput.setText(customerToEdit.getAddress());
		Button buttonUpdate = new Button("Update");

		// Place these elements in a VBox
		VBox editBox = new VBox();
		editBox.getChildren().addAll(nameInput, addressInput, buttonUpdate, returnHomeButton);	
		
		// TitledPane t1 = new TitledPane("T1", editBox);

		// Add the VBox to a BorderPane
		BorderPane editCustomerBorderPane = new BorderPane();
		editCustomerBorderPane.setLeft(editBox);	
		



//		// Get the list of pets
//		ObservableList<Pet> customerPets = ManageCustomers.getCustomerPets(customerToEdit);
//
//
//		// Set up TableView to read from list of pets
//		TableView<Pet> petsTable = new TableView<Pet>();
//		petsTable.setItems(ManageCustomers.getCustomerPets(customerToEdit));
//		
//		TableColumn<Pet, String> nameCol = new TableColumn<Pet, String>("Name");
//		nameCol.setCellValueFactory(new PropertyValueFactory("name"));
//		
//		TableColumn<Pet, String> typeCol = new TableColumn<Pet, String>("Type");
//		typeCol.setCellValueFactory(new PropertyValueFactory("type"));
//		
//		TableColumn<Pet, String> ownerCol = new TableColumn<Pet, String>("Owner");
//		ownerCol.setCellValueFactory(new PropertyValueFactory("owner"));	
//		
//		petsTable.getColumns().setAll(nameCol, typeCol, ownerCol);
//		petsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//		petsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//		// Add TableView to a VBox
//		final VBox vboxPets = new VBox();
//		vboxPets.setSpacing(5);
//		vboxPets.setPadding(new Insets(10, 0, 0, 10));
//		vboxPets.getChildren().addAll(labelPetsList, petsTable);
//		editCustomerBorderPane.setCenter(vboxPets);


		// Create the window using the Border Pane
		Scene sceneEditCustomer = new Scene(editCustomerBorderPane);		
		stage.setScene(sceneEditCustomer);
		
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();

		buttonUpdate.setOnAction(e -> {
			
			
			String newName = nameInput.getText();
			String newAddress = addressInput.getText();
			customerToEdit.setAddress(newAddress);
			customerToEdit.setFirstName(newName);
			
		});
		


	}

}
