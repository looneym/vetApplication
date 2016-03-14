package view;

import controller.ManageCustomers;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Customer;
import model.Pet;

public class EditPetScene {
	
	public static void editScene(TableView table, Stage stage, Scene customersPage){
		
		// Identify which pet the user wants to edit
		Pet petToEdit = (Pet) table.getSelectionModel().getSelectedItem();
		

		// Create TextFields and a button to allow the user to update the details
		TextField nameInput = new TextField();
		nameInput.setText(petToEdit.getName());
		TextField typeInput = new TextField();
		typeInput.setText(petToEdit.getType());
		
		Button buttonUpdate = new Button("Update");
        Label infoLabel = new Label("Edit pet");
		
		Button returnHomeButton = new Button("Return to main page");
		returnHomeButton.setOnAction(e -> stage.setScene(customersPage));
		
		
		// Place these elements in a VBox
		VBox editBox = new VBox();
		editBox.getChildren().addAll(infoLabel, nameInput, typeInput, buttonUpdate, returnHomeButton);	
		
		// Add the VBox to a BorderPane
		BorderPane editPetBorderPane = new BorderPane();
		editPetBorderPane.setLeft(editBox);
		
		// Create the window using the Border Pane
		Scene sceneEditPet = new Scene(editPetBorderPane);		
		stage.setScene(sceneEditPet);
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();
		
		
		
	buttonUpdate.setOnAction(e -> {
			
			
			String newName = nameInput.getText();
			petToEdit.setName(newName);
			String newType = typeInput.getText();
			petToEdit.setType(newType);
			
		});
		


}
	
}
