import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class addressBook extends Application
{
	Stage window;
	Scene mainScene;
	int totalAddresses;
	int currAddress;
	int tempPos;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("Address Book");
		RandomAccessFile raf = new RandomAccessFile("address.txt", "rw");
		Adresses address = new Adresses();
		
		//GridPane Top*********************************************************************************
		GridPane gridTop = new GridPane();
		gridTop.setPadding(new Insets(10, 10, 10, 10));
		gridTop.setVgap(8);
		gridTop.setHgap(10);
		
		//First Name Label and Input
		Label firstNameLbe = new Label("First Name: ");
		GridPane.setConstraints(firstNameLbe, 1, 1);
		TextField firstNameInp = new TextField();
		firstNameInp.setPrefSize(450, 20);
		GridPane.setConstraints(firstNameInp, 2, 1);
	
		//Last Name label and Input
		Label lastNameLbe = new Label("Last Name: ");
		GridPane.setConstraints(lastNameLbe, 1, 2);
		TextField lastNameInp = new TextField();
		lastNameInp.setPrefSize(450, 20);
		GridPane.setConstraints(lastNameInp, 2, 2);
		
		gridTop.getChildren().addAll(firstNameLbe, firstNameInp, lastNameLbe, lastNameInp);
		//GridPane Top End*****************************************************************************
		
		//GridPane Center*********************************************************************************
		GridPane gridCenter = new GridPane();
		gridCenter.setPadding(new Insets(10, 10, 10, 10));
		gridCenter.setVgap(8);
		gridCenter.setHgap(10);
		
		//City Label and Input
		Label cityLbe = new Label("City: ");
		GridPane.setConstraints(cityLbe, 1, 1);
		TextField cityInp = new TextField();
		cityInp.setPrefSize(100, 20);
		GridPane.setConstraints(cityInp, 2, 1);
		
		//Province Label and ComboBox
		Label provLbe = new Label("Province: ");
		GridPane.setConstraints(provLbe, 3, 1);
		ComboBox<String> provComboBox = new ComboBox<String>();
		provComboBox.getItems().addAll("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT");
		provComboBox.setPromptText("Select Province");
		GridPane.setConstraints(provComboBox, 4, 1);
	
		//Postal Code label and Input
		Label postCodeLbe = new Label("Postal Code: ");
		GridPane.setConstraints(postCodeLbe, 5, 1);
		TextField postCodeInp = new TextField();
		postCodeInp.setPrefSize(100, 20);
		GridPane.setConstraints(postCodeInp, 6, 1);
		
		gridCenter.getChildren().addAll(postCodeLbe, postCodeInp, cityLbe, cityInp, provLbe, provComboBox);
		//GridPane Center End*****************************************************************************
		
		//HBox Bottom Menu*****************************************************************************
				HBox menu = new HBox();
				menu.setPadding(new Insets(10, 10, 10, 10));
				menu.setSpacing(10);
				
				//Add Button
				Button addBtn = new Button("Add");
				addBtn.setPrefSize(90, 20);
					//Add Button EventHandler
					addBtn.setOnAction( e -> {											
						try {
							address.setFirstName(firstNameInp.getText().trim());
							address.setLastName(lastNameInp.getText().trim());
							address.setCity(cityInp.getText().trim());
							address.setProv(provComboBox.getValue().trim());
							address.setPost(postCodeInp.getText().trim());
							
							raf.writeUTF(address.firstName);
							raf.writeUTF(address.lastName);
							raf.writeUTF(address.city);
							raf.writeUTF(address.prov);
							raf.writeUTF(address.post);
						} catch (IOException err) {
							System.out.println(err);
						}
						//keep count of total address
						totalAddresses++;
						//keep count of curr address
						if (currAddress == 0)
						{
							currAddress++;
						}
						
					});
				
				Button firstBtn = new Button("First");
				firstBtn.setPrefSize(90, 20);
				firstBtn.setOnAction( e -> {
					try {
						//set to first address
						tempPos = 0;
						currAddress = 1;
						//go to start of line
						raf.seek(0);
						firstNameInp.setText(raf.readUTF().trim()); 
						lastNameInp.setText(raf.readUTF().trim()); 
						cityInp.setText(raf.readUTF().trim()); 
						provComboBox.setValue(raf.readUTF().trim()); 
						postCodeInp.setText(raf.readUTF().trim()); 
						
					} catch (IOException err) {
						System.out.println(err);
					}
					
				});
				
				
				Button nextBtn = new Button("Next");
				nextBtn.setPrefSize(90, 20);
				nextBtn.setOnAction( e -> {							
					try {
						currAddress++;
						tempPos = currAddress * 75;
						raf.seek(tempPos);
							
						firstNameInp.setText(raf.readUTF().trim()); 
						lastNameInp.setText(raf.readUTF().trim()); 
						cityInp.setText(raf.readUTF().trim()); 
						provComboBox.setValue(raf.readUTF().trim()); 
						postCodeInp.setText(raf.readUTF().trim());
						
					} catch (IOException err) {
						System.out.println(err);
					}
				});
				
				Button previousBtn = new Button("Previous");
				previousBtn.setPrefSize(90, 20);
				previousBtn.setOnAction( e -> {
					
					try {
					currAddress--;
					tempPos = currAddress * 75;
					raf.seek(tempPos);
					
					firstNameInp.setText(raf.readUTF().trim()); 
					lastNameInp.setText(raf.readUTF().trim()); 
					cityInp.setText(raf.readUTF().trim()); 
					provComboBox.setValue(raf.readUTF().trim()); 
					postCodeInp.setText(raf.readUTF().trim());
					} catch (IOException err) {
						System.out.println(err);
					}
				});
				
				Button lastBtn = new Button("Last");
				lastBtn.setPrefSize(90, 20);
				lastBtn.setOnAction( e -> {
					try {
					tempPos = totalAddresses * 75;
					raf.seek(tempPos);
					
					firstNameInp.setText(raf.readUTF().trim()); 
					lastNameInp.setText(raf.readUTF().trim()); 
					cityInp.setText(raf.readUTF().trim()); 
					provComboBox.setValue(raf.readUTF().trim()); 
					postCodeInp.setText(raf.readUTF().trim());
					
					} catch (IOException err) {
						System.out.println(err);
					}
				});
				
				Button updateBtn = new Button("Update");
				updateBtn.setPrefSize(90, 20);
				updateBtn.setOnAction( e -> {
					try {
						
						//make temp to compare
						Adresses tempAddress = new Adresses(raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readUTF(), raf.readUTF());
						String checker;
						int counter = 0;
						//loop to find which line to update
						for (int i = 0; i < totalAddresses; i++)
						{
						
						tempPos = counter * 75;
						raf.seek(tempPos);
						checker = raf.readUTF();
						//check if firstName is the same
						if (checker == tempAddress.firstName)
						{
							//leave loop with the counter
							break;
						}
						counter++;
						
						}
						//use counter to find the right line to update
						tempPos = counter * 75;
						raf.seek(tempPos);
						
						raf.writeUTF(address.firstName);
						raf.writeUTF(address.lastName);
						raf.writeUTF(address.city);
						raf.writeUTF(address.prov);
						raf.writeUTF(address.post);
						
						
					} catch (IOException err) {
						System.out.println(err);
					}
				});
				
				menu.getChildren().addAll(addBtn, firstBtn, nextBtn, previousBtn, lastBtn, updateBtn);
				//HBox Bottom Menu End****************************************************************************
		BorderPane mainPage = new BorderPane();
		mainPage.setTop(gridTop);
		mainPage.setCenter(gridCenter);
		mainPage.setBottom(menu);
		mainScene = new Scene(mainPage, 600, 200);
		
		window.setScene(mainScene);
		window.show();
		
	}
	
	
	
}
