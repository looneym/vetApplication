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
import model.Procedure;

public class AddProcedureScene {

	public static Object addProcedure(Stage stage, Customer owner, Scene customersPage, Scene viewProceduresScene) {
		
		
		// Create TextFields and a button to allow the user to update the details
		TextField nameInput = new TextField();
		TextField priceInput = new TextField();
		TextField dateInput = new TextField();
		Button buttonAdd = new Button("Add");
		
		Label proceduresAddLabel = new Label("Add a new procedure");
		Button returnHomeButton = new Button("Return to main page");
		returnHomeButton.setOnAction(e -> stage.setScene(customersPage));
		
		// Set button handlers	
		
		buttonAdd.setOnAction(e -> {
			
			String name = nameInput.getText();
			String price = priceInput.getText();
			String date = dateInput.getText();
			Procedure newProcedure = new Procedure(name, price, date, owner);
			
		});

		// Place these elements in a VBox
		VBox editBox = new VBox();
		editBox.getChildren().addAll(proceduresAddLabel, nameInput, priceInput, dateInput, buttonAdd, returnHomeButton);	

		// Add the VBox to a BorderPane
		BorderPane border = new BorderPane();
		border.setLeft(editBox);		

		// Create the window using the Border Pane
		Scene sceneAddNewProcedure = new Scene(border);
		stage.setScene(sceneAddNewProcedure);
		
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();
		
		return null;
	}

}
