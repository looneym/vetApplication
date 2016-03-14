package view;

import controller.ManageCustomers;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;
import model.Pet;

public class AddPetScene {

	public static Object addPet(Stage stage, Customer owner, Scene customersPage) {
		
		
		// Create TextFields and a button to allow the user to update the details
		TextField nameInput = new TextField();
		TextField typeInput = new TextField();
		Button buttonAdd = new Button("Add");
		
		Label petAddLabel = new Label("Add a new pet");
		Button returnHomeButton = new Button("Return to main page");
		returnHomeButton.setOnAction(e -> stage.setScene(customersPage));
		
		// Set button handlers	
		
		buttonAdd.setOnAction(e -> {
			
			String name = nameInput.getText();
			String type = typeInput.getText();
			Pet newPet = new Pet(name, type, owner);
			
		});

		// Place these elements in a VBox
		VBox editBox = new VBox();
		editBox.getChildren().addAll(petAddLabel, nameInput, typeInput, buttonAdd, returnHomeButton);	

		// Add the VBox to a BorderPane
		BorderPane border = new BorderPane();
		border.setLeft(editBox);		

		// Create the window using the Border Pane
		Scene sceneAddNewCustomer = new Scene(border);
		stage.setScene(sceneAddNewCustomer);
		
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();
		
		return null;
	}

}
