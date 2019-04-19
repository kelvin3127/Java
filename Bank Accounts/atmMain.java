import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class atmMain extends Application
{
	Stage window;
	Scene loginScene, pinScene, menuScene, withdrawScene, depositScene, balanceScene;
	static Account records[] = new Account[10];
	public static ObjectInputStream in;
	int loginKey = 0;
	
	public static void main(String[] args) throws FileNotFoundException
	{
			
		//create array of object for 10 accounts	
		Account[] account = {
				new Account(100, "Bob", "Marley", 100, 1234),
				new Account(101, "Sam", "Hunt", 100, 2345),
				new Account(102, "Sally", "Summerton",100, 3455),
				new Account(103, "George", "Bush",100, 0),
				new Account(104, "Miles", "Fargo",100, 6546),
				new Account(105, "Frank", "Lin",100, 8653),
				new Account(106, "Michael", "Jackson",100, 2535),
				new Account(107, "Hugo", "Boss",100, 0),
				new Account(108, "Apofos", "Orlan",100, 8674),
				new Account(109, "Grim", "Trog",100, 0),
				new Account(110, "Sean", "Demilo",100, 3586)
		};
		
		FileOutputStream out = new FileOutputStream("account.dat");
		try (ObjectOutputStream output = new ObjectOutputStream(out))
		{
			//make new file called account
		    //check if the file exists, if not make the file

			for(int i = 0; i < account.length; i++)
		    {
			    output.writeInt(account[i].getId());
			    output.writeDouble(account[i].getBalance());
			    output.writeUTF(account[i].getFirstName());
		    	output.writeUTF(account[i].getLastName());
		    	output.writeInt(account[i].getPin());
		    }
		    
			System.out.println("Serialized data saved to file account.dat");
		} catch (IOException ex) {
			//print the error
			System.err.println("Unable to read file, Ending program");
		}
		
		
		//Deserilized
		try {
			 
			in = new ObjectInputStream(Files.newInputStream(Paths.get("account.dat")));
			int counter = 0;
			while (true)
			{
				records[counter] = (Account) in.readObject();
				//get record info
				records[counter].getId();
				records[counter].getBalance();
				records[counter].getFirstName();
				records[counter].getLastName();
				records[counter].getPin();
				counter++;
				System.out.println("Data" + counter +" Deserilized from file account.dat");
			}

			
		} catch (EOFException ex)
		{
			System.err.println("No more records to record");
		} catch (IOException ex) 
		{
			System.err.println("Unable to read file, Ending program");
		} catch (ClassNotFoundException ex) 
		{					
			System.err.println("Invalid Oject, Ending Program");
		}
		

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
			pinInp.setPromptText("");
			GridPane.setConstraints(pinInp, 2, 2);
			Label loginText = new Label("");
			GridPane.setConstraints(loginText, 1, 5);
			
			//Login Button
			Button loginBtn = new Button("Login");
			GridPane.setConstraints(loginBtn, 2, 3);
				//Login Button EventHandler
				loginBtn.setOnAction(e -> {
					
					//loop objects to validate
					for (int i = 0; i < 10; i++)
					{
						if (records[i].getPin() == 0)
						{
							window.setScene(pinScene);
						}
						
						if (records[i].validate(Integer.parseInt(userInp.getText().trim()), Integer.parseInt(pinInp.getText().trim())))
						{
							loginKey = i;
							window.setScene(menuScene);
						}
						
					}
				
					loginText.setText("Login Unsucessful, invalid account or password");
					window.setScene(menuScene);

				});
			
			//Exit Button
			Button loginExitBtn = new Button("Exit");
			GridPane.setConstraints(loginExitBtn, 2, 4);
				//Exit EventHandler
				loginExitBtn.setOnAction(e -> {
					try 
					{
						//make new file called account
					    File file = new File("account.dat");
					    FileOutputStream fileOut = new FileOutputStream(file);
					    ObjectOutputStream writer = new ObjectOutputStream(fileOut);
					    for(int i = 0; i < records.length; i++)
				    	{
				    		writer.writeObject(records[i]);
				    	}
					    
						writer.close();
						fileOut.close();
						System.out.println("Serialized data saved to file account.dat");
					} catch (IOException ex) {
						//print the error
						System.out.println(ex);
					}   
					closeProgram();
				});
				
		loginPage.getChildren().addAll(userLbe, userInp, pinLbe, pinInp, loginBtn, loginExitBtn, loginText);
		
		//Login Page End*******************************************************************************************
		
		//Create Pin Page******************************************************************************************
		/*GridPane pinPage = new GridPane();
			//Pin Page Settings
			pinPage.setPadding(new Insets(10));
			pinPage.setVgap(8);
			pinPage.setHgap(10);
			
			Label createPinLbe = new Label("There is no pin, please create a new pin");
			GridPane.setConstraints(pinLbe, 1, 2);
			
			//New Pin Label
			Label newPinLbe = new Label("There is no pin, please create a new pin");
			GridPane.setConstraints(pinLbe, 1, 3);
			TextField newPinInp = new TextField();
			GridPane.setConstraints(newPinInp, 2, 4);
			
			//Confirm Pin Label
			Label confirmPinLbe = new Label("There is no pin, please create a new pin");
			GridPane.setConstraints(pinLbe, 1, 5);
			TextField confirmPinInp = new TextField();
			GridPane.setConstraints(confirmPinInp, 2, 6);
			
			Label checkText = new Label("");
			GridPane.setConstraints(checkText, 2, 7);
			
			Button createBtn = new Button("Create Pin");
			GridPane.setConstraints(createBtn, 1, 8);
			createBtn.setOnAction(e -> {
				boolean check = false;
				if (newPinInp.getText() == confirmPinInp.getText())
				{
					check = true;
				}
				else
				{
					checkText.setText("The pin does not match");
				}
				if (check)
				{
					window.setScene(menuScene);
				}
				
			});
			
		pinPage.getChildren().addAll(createPinLbe, newPinLbe, newPinInp, confirmPinLbe, confirmPinInp, checkText, createBtn);
		*/
		//Create Pin Page End******************************************************************************************
		
		//Menu Page************************************************************************************************		
		GridPane menuPage = new GridPane();
			//Menu Page Settings
			menuPage.setPadding(new Insets(10));
			menuPage.setAlignment(Pos.CENTER);
			menuPage.setVgap(8);
			menuPage.setHgap(10);
		
			//Account Welcome Text
			Label accountLbe = new Label("Welcome to your Account");
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
			Label balanceLbe = new Label("Your Balance is: " );
			GridPane.setConstraints(balanceLbe, 0, 1);
			//Check Balance Label
			Label checkBalLbe = new Label("");
			GridPane.setConstraints(checkBalLbe, 1, 1);
			//Check Balance Button
			Button checkBtn = new Button("Check Balance");
			GridPane.setConstraints(checkBtn, 0, 2);
				//Check EventHandler
				checkBtn.setOnAction( e -> {
					checkBalLbe.setText(Double.toString(records[loginKey].getBalance()));
				});
			//Main Menu Button
			Button menuBtn = new Button("Main Menu");
			GridPane.setConstraints(menuBtn, 0, 3);
				//Main Menu EventHandler
				menuBtn.setOnAction(e -> {
					window.setScene(menuScene);
				});
				
		balancePage.getChildren().addAll(balanceLbe, menuBtn, checkBalLbe, checkBtn);
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
				//Input
			TextField withdrawInp = new TextField();
			withdrawInp.setPromptText("Amount");
			GridPane.setConstraints(withdrawInp, 2, 1);
				//Message
			Label withdrawText = new Label("");
			GridPane.setConstraints(withdrawText, 1, 3);
			
			
			//Withdraw Button
			Button withdrawPageBtn = new Button("Withdraw");
			GridPane.setConstraints(withdrawPageBtn, 1, 2);
				//Withdraw EventHandler
				withdrawPageBtn.setOnAction(e -> {
					double tempBal = Double.parseDouble(withdrawInp.getText());
					if(records[loginKey].getBalance() < tempBal)
					{
						withdrawText.setText("Insufficient Funds, your current balance is: " + records[loginKey].getBalance());
					}
					else
					{
						records[loginKey].withdraw(Double.parseDouble(withdrawInp.getText()));
						withdrawText.setText( withdrawInp.getText() + "withdrawn from account, new balance is: " + records[loginKey].getBalance());
					}
				});
			
			//Main Menu Button
			Button withdrawMenuBtn = new Button("Main Menu");
			GridPane.setConstraints(withdrawMenuBtn, 1, 3);
				//Main Menu EventHandler
				withdrawMenuBtn.setOnAction(e -> {
					window.setScene(menuScene);
				});
				
		withdrawPage.getChildren().addAll(withdrawLbe, withdrawInp, withdrawPageBtn, withdrawMenuBtn, withdrawText);
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
				//Input
			TextField depositInp = new TextField();
			depositInp.setPromptText("Amount");
			GridPane.setConstraints(depositInp, 2, 1);
				//Messages
			Label depositText = new Label("");
			GridPane.setConstraints(depositText, 1, 3);
				
			//Withdraw Button
			Button depositPageBtn = new Button("Deposit");
			GridPane.setConstraints(depositPageBtn, 1, 2);
				//Withdraw EventHandler
				depositPageBtn.setOnAction(e -> {
					records[loginKey].deposit(Double.parseDouble(depositInp.getText()));
					depositText.setText( depositInp.getText() + " has been deposited into account, new balance is: " + records[loginKey].getBalance());
				});
				
			//Main Menu Button
			Button depositMenuBtn = new Button("Main Menu");
			GridPane.setConstraints(depositMenuBtn, 1, 4);
				//Main Menu EventHandler
				depositMenuBtn.setOnAction(e -> {
					window.setScene(menuScene);
				});	
					
		depositPage.getChildren().addAll(depositLbe, depositInp, depositPageBtn, depositMenuBtn, depositText);
		//Deposit Page End**********************************************************************************
				
		//Different Scenes*******************************************************************
		depositScene = new Scene(depositPage, 400, 350);
		withdrawScene = new Scene(withdrawPage, 400, 350);
		balanceScene = new Scene(balancePage, 400, 350);
		menuScene = new Scene(menuPage, 400, 350);
		loginScene = new Scene(loginPage, 400, 350);
		//**************************************************************************************
		
		window.setScene(loginScene);
		window.show();
			

	}

	
	private void closeProgram()
	{
		window.close();
	}
}
