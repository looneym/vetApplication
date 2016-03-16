package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;
import model.Procedure;

public class EditProcedureScene {
	
	public static void showScene(Scene customersPage, Scene viewPetsScene, Scene viewProceduresScene, Stage stage, Customer selectedCustomer, Procedure procToEdit){
		
		

		// Create TextFields and a button to allow the user to update the details
		TextField nameInput = new TextField();
		nameInput.setText(procToEdit.getName());
		TextField priceInput = new TextField();
		priceInput.setText(procToEdit.getPrice());
		TextField dateInput = new TextField();
		dateInput.setText(procToEdit.getDate());
		
		Button buttonUpdate = new Button("Update");
        Label infoLabel = new Label("Edit procedure");
		
		Button returnHomeButton = new Button("Return to main page");
		returnHomeButton.setOnAction(e -> stage.setScene(customersPage));
		
		Button returnToCustomerProcedures = new Button("Return to this customer's procedures");
		returnToCustomerProcedures.setOnAction(e -> stage.setScene(viewProceduresScene));
		
		
		// Place these elements in a VBox
		VBox editBox = new VBox();
		editBox.getChildren().addAll(infoLabel, nameInput, priceInput, dateInput, buttonUpdate, returnHomeButton);	
		
		// Add the VBox to a BorderPane
		BorderPane editProcedureBorderPane = new BorderPane();
		editProcedureBorderPane.setLeft(editBox);
		
		// Create the window using the Border Pane
		Scene sceneEditProcedure = new Scene(editProcedureBorderPane);		
		stage.setScene(sceneEditProcedure);
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();
		
		
		
	buttonUpdate.setOnAction(e -> {
			
			
			String newName = nameInput.getText();
			procToEdit.setName(newName);
			String newPrice = priceInput.getText();
			procToEdit.setPrice(newPrice);
			String newDate = dateInput.getText();
			procToEdit.setDate(newDate);
			
		});
		
		
	}

}
