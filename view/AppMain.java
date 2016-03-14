package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Customer;
import model.Pet;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Optional;

import controller.CreateTestData;
import controller.ManageCustomers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class AppMain extends Application{
	
	Button returnHomeButton = new Button("Return to main page");
	Scene sceneEditCustomer;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		// Run separate method to create dummy data 
		CreateTestData.createCustomerList();
		
		// Show the opening scene
		OpeningScene.showOpeningScene(stage, returnHomeButton);
		
	}


}
