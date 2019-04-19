
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class task13 extends Application
{
	Stage window;
	Scene loginScene, pinScene, menuScene, withdrawScene, depositScene, balanceScene;
	
	public static void main(String[] args)
	{
		
		
		//create array of object for 10 accounts
		
		double bal = 100;
		int[] pins = {1234, 2345, 7654, 7646, 7464, 0, 4633, 0, 4673, 7647};
		int[] ids = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
		String[] firstNames = {"Bob", "George", "Sally", "Sam", "Miles", "Frank", "Michael", "Joe", "Hugo", "Jessica" };  
		String[] lastNames = {"Marley", "Washington", "Summerton", "Hunt", "Fargo", "Lin", "Deng", "Beef", "Boss", "Alba" };
		//set balance for all accounts to 100
		Account[] account = new Account[10];
		for (int i = 0; i < account.length; i++)
		{
			account[i].setId(ids[i]);
			account[i].setPin(pins[i]);
			account[i].setBalance(bal);
			account[i].setFirstName(firstNames[i]);
			account[i].setLastName(lastNames[i]);
		}
		
		/*
		try 
		{
			//make new file called account
		    File file = new File("account.dat");
		    //check if the file exists, if not make the file
		    if (!file.exists()) {
		    	file.createNewFile();
		    }
		    
		    FileOutputStream fileOut = new FileOutputStream("account.dat");
		    ObjectOutputStream writer = new ObjectOutputStream(fileOut);
		    
		    for(int i = 0; i < account.length; i++)
		    	{
		    		writer.writeObject(account[i]);
		    	}
		    
			writer.close();
			System.out.println("Serialized data saved to file account.dat");
		} catch (IOException ex) {
			//print the error
			System.out.println(ex);
		}
		*/

		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("ATM App");	
		
		//Login Page**********************************************************************************************
		GridPane loginPage = new GridPane();
		//Login Settings
		loginPage.setPadding(new Insets(10, 10, 10, 10));
		loginPage.setVgap(8);
		loginPage.setHgap(10);
		
			//Name label and Input
			Label userLbe = new Label("Account:");
			GridPane.setConstraints(userLbe, 1, 1);
			TextField userInp = new TextField();
			userInp.setPromptText("Account Number");
			GridPane.setConstraints(userInp, 2, 1);
		
			//Pin label and Input
			Label pinLbe = new Label("Pin:");
			GridPane.setConstraints(pinLbe, 1, 2);
			TextField pinInp = new TextField();
			pinInp.setPromptText("Pin");
			GridPane.setConstraints(pinInp, 2, 2);
			
			//Login Button
			Button loginBtn = new Button("Login");
			GridPane.setConstraints(loginBtn, 2, 3);
				//Login Button EventHandler
				loginBtn.setOnAction(e -> {
					window.setScene(menuScene);
				});
				
		loginPage.getChildren().addAll(userLbe, userInp, pinLbe, pinInp, loginBtn);
		
		//Login Page End*******************************************************************************************
		
		//Menu Page************************************************************************************************		
		GridPane menuPage = new GridPane();
			//Menu Page Settings
			menuPage.setPadding(new Insets(10));
			menuPage.setAlignment(Pos.CENTER);
			menuPage.setVgap(8);
			menuPage.setHgap(10);
		
			//Account Welcome Text
			Label accountLbe = new Label("Welcome name Here");
			GridPane.setConstraints(accountLbe, 1, 0 );		
			
			//Balance Button
			Button balanceBtn = new Button("Balance");
			GridPane.setConstraints(balanceBtn, 1, 1);
				//Balance EventHandler
				balanceBtn.setOnAction(e -> {
					window.setScene(balanceScene);
				});
				
			//Withdraw Button
			Button withdrawBtn = new Button("Withdraw");
			GridPane.setConstraints(withdrawBtn, 1, 2);
				//Withdraw EventHandler
				withdrawBtn.setOnAction(e -> {
					window.setScene(withdrawScene);
				});
				
			//Deposit Button
			Button depositBtn = new Button("Deposit");
			GridPane.setConstraints(depositBtn, 1, 3);
				//Deposit EventHandler
				depositBtn.setOnAction(e -> {
					window.setScene(depositScene);
				});
				
			//Exit Button
			Button exitBtn = new Button("Exit");
			GridPane.setConstraints(exitBtn, 1, 4);
				//Exit EventHandler
				exitBtn.setOnAction(e -> {
					window.setScene(loginScene);
				});
		
		menuPage.getChildren().addAll(exitBtn, depositBtn, withdrawBtn, balanceBtn, accountLbe);		
		//Menu Page End********************************************************************************************
		
		//Balance Page*********************************************************************************************
		GridPane balancePage = new GridPane();
			//Balance Page Settings
			balancePage.setPadding(new Insets(10));
			balancePage.setAlignment(Pos.CENTER);
			balancePage.setVgap(8);
			balancePage.setHgap(10);
			
			//Balance Label
			Label balanceLbe = new Label("Your Balance is:");
			GridPane.setConstraints(balanceLbe, 0, 1);
			//Main Menu Button
			Button menuBtn = new Button("Main Menu");
			GridPane.setConstraints(menuBtn, 0, 2);
				//Main Menu EventHandler
				menuBtn.setOnAction(e -> {
					window.setScene(menuScene);
				});
				
		balancePage.getChildren().addAll(balanceLbe, menuBtn);
		//Balance Page End*******************************************************************************************
				
		//Withdraw Page**********************************************************************************************
		GridPane withdrawPage = new GridPane();
			//Withdraw Page Settings
			withdrawPage.setPadding(new Insets(10));
			withdrawPage.setAlignment(Pos.CENTER);
			withdrawPage.setVgap(8);
			withdrawPage.setHgap(10);
			
			//Withdraw Label and Input
			Label withdrawLbe = new Label("Withdraw Amount:");
			GridPane.setConstraints(withdrawLbe, 1, 1);
			TextField withdrawInp = new TextField();
			withdrawInp.setPromptText("Amount");
			GridPane.setConstraints(withdrawInp, 2, 1);
			
			//Withdraw Button
			Button withdrawPageBtn = new Button("Withdraw");
			GridPane.setConstraints(withdrawPageBtn, 1, 2);
				//Withdraw EventHandler
				withdrawPageBtn.setOnAction(e -> {
					//widthdraw Money
				});
			
			//Main Menu Button
			Button withdrawMenuBtn = new Button("Main Menu");
			GridPane.setConstraints(withdrawMenuBtn, 1, 3);
				//Main Menu EventHandler
				withdrawMenuBtn.setOnAction(e -> {
					window.setScene(menuScene);
				});
				
		withdrawPage.getChildren().addAll(withdrawLbe, withdrawInp, withdrawPageBtn, withdrawMenuBtn);
		//Withdraw Page End**************************************************************************************
		
		//Deposit Page******************************************************************************************
		GridPane depositPage = new GridPane();
			//Withdraw Page Settings
			depositPage.setPadding(new Insets(10));
			depositPage.setAlignment(Pos.CENTER);
			depositPage.setVgap(8);
			depositPage.setHgap(10);
				
			//Withdraw Label and Input
			Label depositLbe = new Label("Deposit Amount:");
			GridPane.setConstraints(depositLbe, 1, 1);
			TextField depositInp = new TextField();
			depositInp.setPromptText("Amount");
			GridPane.setConstraints(depositInp, 2, 1);
				
			//Withdraw Button
			Button depositPageBtn = new Button("Deposit");
			GridPane.setConstraints(depositPageBtn, 1, 2);
				//Withdraw EventHandler
				depositPageBtn.setOnAction(e -> {
					//deposit Money
				});
				
				//Main Menu Button
				Button depositMenuBtn = new Button("Main Menu");
				GridPane.setConstraints(depositMenuBtn, 1, 3);
					//Main Menu EventHandler
					depositMenuBtn.setOnAction(e -> {
						window.setScene(menuScene);
					});	
					
		depositPage.getChildren().addAll(depositLbe, depositInp, depositPageBtn, depositMenuBtn);
		//Deposit Page End**********************************************************************************
				
		//Different Scenes*******************************************************************
		depositScene = new Scene(depositPage, 400, 350);
		withdrawScene = new Scene(withdrawPage, 400, 350);
		balanceScene = new Scene(balancePage, 300, 350);
		menuScene = new Scene(menuPage, 300, 350);
		loginScene = new Scene(loginPage, 300, 350);
		//**************************************************************************************
		
		window.setScene(loginScene);
		window.show();
			
	}
	
}
