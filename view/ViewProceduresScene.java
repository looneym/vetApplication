package view;

import controller.ManageCustomers;
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
import model.Procedure;

public class ViewProceduresScene {

	public static void showScene(Scene customersPage, Scene viewPetsScene, Stage stage, Customer selectedCustomer) {
		

		Button editProcedureButton = new Button("Edit Procedure");
		Button addProcedureButton = new Button("Add Perocedure");
		Button deleteProcedureButton = new Button("Delete Procedure");
		Button returnHomeButton = new Button("Return to main page");
		
		
		final Label labelProcList = new Label("Procedures List");
		
		
		// Set up TableView to read from list of pets
		TableView<Procedure> proceduresTable = new TableView<Procedure>();
		proceduresTable.setItems(ManageCustomers.getCustomerProcedures(selectedCustomer));
		
		TableColumn<Procedure, String> procedureNameCol = new TableColumn<Procedure, String>("Name");
		procedureNameCol.setCellValueFactory(new PropertyValueFactory("name"));
		
		TableColumn<Procedure, String> priceCol = new TableColumn<Procedure, String>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory("type"));
		
		TableColumn<Procedure, String> dateCol = new TableColumn<Procedure, String>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory("owner"));	
		
		proceduresTable.getColumns().setAll(procedureNameCol, priceCol, dateCol);
		proceduresTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		proceduresTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		// Add TableView to a VBox
		final VBox vboxPets = new VBox();
		vboxPets.setSpacing(5);
		vboxPets.setPadding(new Insets(10, 0, 0, 10));
		vboxPets.getChildren().addAll(labelProcList, proceduresTable);
		
		final VBox vboxRight = new VBox();
		vboxRight.setSpacing(5);	
		vboxRight.setPadding(new Insets(50, 10, 0, 10));	
		vboxRight.getChildren().addAll(editProcedureButton, addProcedureButton, deleteProcedureButton, returnHomeButton);
		
		BorderPane viewProceduresBorderPane = new BorderPane();
		viewProceduresBorderPane.setCenter(vboxPets);
		viewProceduresBorderPane.setRight(vboxRight);
		
		Scene viewProceduresScene = new Scene(viewProceduresBorderPane);		
		stage.setScene(viewProceduresScene);
		stage.show();
		
		
		
	}

}
