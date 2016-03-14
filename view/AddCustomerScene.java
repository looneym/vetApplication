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

public class AddCustomerScene {
	
	public static void addScene(Button returnHomeButton, Stage stage){

		// Create TextFields and a button to allow the user to update the details
		TextField nameInput = new TextField();
		TextField addressInput = new TextField();
		Label customerAddLabel = new Label("Add a new customer");
		Button buttonAdd = new Button("Add");
		
		// Set button handler		
		buttonAdd.setOnAction(e -> {
			
			String name = nameInput.getText();
			String address = addressInput.getText();
			Customer newCustomer = new Customer(name, address);
			ManageCustomers.addCustomer(newCustomer);
			
		});

		// Place these elements in a VBox
		VBox editBox = new VBox();
		editBox.getChildren().addAll(customerAddLabel, nameInput, addressInput, buttonAdd, returnHomeButton);	

		// Add the VBox to a BorderPane
		BorderPane border = new BorderPane();
		border.setLeft(editBox);		

		// Create the window using the Border Pane
		Scene sceneAddNewCustomer = new Scene(border);
		stage.setScene(sceneAddNewCustomer);
		
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();
	


	}
	

}
