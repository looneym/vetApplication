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

public class OpeningScene {
	
	 // public static Scene customersPage;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void showOpeningScene(Stage stage, Button returnHomeButton){
		
		Button showPetsButton = new Button("Show customer Pets and procedures");
		Button editButton = new Button("Edit Customer");
		Button addButton = new Button("Add Customer");
		Button deleteButton = new Button("Delete customer");
		final Label labelCustList = new Label("Customer List");

		// Initialize ObservableList of Customers
		ObservableList<Customer> customers = ManageCustomers.getAllCustomers();

		// Set up TableView to read from list of Customers
		TableView<Customer> table = new TableView<Customer>();
		table.setItems(customers);
		TableColumn<Customer, String> nameCol = new TableColumn<Customer, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
		TableColumn<Customer, String> addressCol = new TableColumn<Customer, String>("Address");
		addressCol.setCellValueFactory(new PropertyValueFactory("address"));
		table.getColumns().setAll(nameCol, addressCol);
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// Add TableView to a VBox
		final VBox vboxLeft = new VBox();
		vboxLeft.setSpacing(5);
		vboxLeft.setPadding(new Insets(10, 0, 0, 10));
		vboxLeft.getChildren().addAll(labelCustList, table);

		// Add buttons to another VBox
		final VBox vboxRight = new VBox();
		vboxRight.setSpacing(5);	
		vboxRight.setPadding(new Insets(50, 10, 0, 10));	
		vboxRight.getChildren().addAll(showPetsButton, editButton, addButton, deleteButton);

		// Use a BorderPane to manage the layout, add the VBoxes to it 
		BorderPane border = new BorderPane();
		border.setCenter(vboxLeft);
		border.setRight(vboxRight);

		// Add the BorderPane to the customersPage scene
		Scene customersPage = new Scene(border);
		// AnimalScene aScene = new AnimalScene(customers);
		stage.setScene(customersPage);
		stage.setTitle("Veterinary Customers Application");
		stage.setWidth(600);
		stage.setHeight(500);
		stage.show();

		// Set event handlers for buttons
		showPetsButton.setOnAction(e -> ViewPetsScene.showScene(table, customersPage, stage));
		editButton.setOnAction(e -> EditCustomerScene.editScene(table, customersPage, stage));
		addButton.setOnAction(f -> AddCustomerScene.addScene(returnHomeButton, stage));
		deleteButton.setOnAction(g -> {
			
			Customer customerToDelete = (Customer) table.getSelectionModel().getSelectedItem();
			ManageCustomers.deleteCustomer(customerToDelete);
			
		});
		
		returnHomeButton.setOnAction(e -> stage.setScene(customersPage));

	}

}
