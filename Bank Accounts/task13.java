
import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class task13 extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		//Creation of buttons
		Button balanaceBtn = new Button("Check Balance");
		Button widthdrawBtn = new Button("Withdraw Money");
		Button depositBtn = new Button("Deposit Money");
		Button exitBtn = new Button("Exit");
		Button mainBtn = new Button("Main Menu");
		Button submitBtn = new Button("Submit");
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5); //horizontal distance apart
		pane.setVgap(5.5); //Vertical distance apart
		
		pane.add(new Label("Welcome to Account"), 0, 0);
		
		
		primaryStage.show();
	}
	
	
	public static void main(String[] args)
	{
		
		launch(args);
		//create array of object for 10 accounts
		//Account[] account = new Account[10];
		//String[] firstNames = {"Bob", "George", "Sally", "Sam", "Miles", "Frank", "Michael", "Joe", "Hugo", "Jessica" };  
		//String[] lastNames = {"Marley", "Washington", "Summerton", "Hunt", "Fargo", "Lin", "Deng", "Beef", "Boss", "Alba" };
		//set balance for all accounts to 100
		/*for (int i = 0; i < account.length; i++)
		{
			int number = 100;
			double money = 100;
			account[i].setBalance(money);
			account[i].setId(number + i);
			account[i].setFirstName(firstNames[i]);
			account[i].setLastName(lastNames[i]);
		}
		*/
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

		
	}
}
