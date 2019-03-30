import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class babyNames extends Application
{
	Stage windowStage;
	Scene mainPage, subPage;
	static String folderName = "babynamesranking";
	
	Label yearLbe = new Label("Enter the Year:");
	Label nameLbe = new Label("Enter the Name:");
	Label genderLbe = new Label("Enter the Gender:");
	Label textLbe = new Label("");
	Label contLbe = new Label("Search another Name:");
	
	TextField yearInp = new TextField();
	TextField genderInp = new TextField();
	TextField nameInp = new TextField();
	TextField contInp = new TextField();
	
	Alert alert = new Alert(AlertType.ERROR);
	
	Button submit = new Button("Submit");
	Button submit2 = new Button("Submit");
	Button exit = new Button("Exit");
	Button exit2 = new Button("Exit");
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception 
	{
		windowStage = window;
		window.setTitle("Baby Name Rankings");
		//Open File******
		File file = new File(folderName);
		
		//Main Page*************************************************************************************
		GridPane mainPg = new GridPane();
		mainPg.setPadding(new Insets(10, 10, 10, 10));
		mainPg.setAlignment(Pos.CENTER);
		mainPg.setVgap(8);
		mainPg.setHgap(10);
		
		//Year label and input		
		GridPane.setConstraints(yearLbe, 0, 0);
		GridPane.setConstraints(yearInp, 1, 0);
		
		//Gender label and input	
		GridPane.setConstraints(genderLbe, 0, 1);
		genderInp.setPrefSize(5, 5);
		GridPane.setConstraints(genderInp, 1, 1);
		
		//Name label and input	
		GridPane.setConstraints(nameLbe, 0, 2);	
		GridPane.setConstraints(nameInp, 1, 2);
		
		//Invisible Label
		GridPane.setConstraints(textLbe, 0, 3);		
		
		//Submit Button
		submit.setPrefSize(70, 20);
		GridPane.setConstraints(submit, 0, 4);
		submit.setOnAction( e -> {
			
			//Error Checks*********************
			validCheck(yearInp.getText().trim(), nameInp.getText().trim(), genderInp.getText().trim());

			//Get filepath
			String filepath = folderName + yearInp.getText().trim() + ".txt";
			try 
			{
				searchFile(filepath, nameInp.getText().trim(), genderInp.getText().trim());
				
			} catch (IOException e2) 
			{
				System.out.println("Error occuered while trying to open folder");
			}
			
		});
		
		//Exit Button
		exit.setPrefSize(70, 20);
		GridPane.setConstraints(exit, 1, 4);
		exit.setOnAction( e -> {
			window.setScene(subPage);
		});
		
		mainPg.getChildren().addAll(yearLbe, yearInp, genderLbe, genderInp, nameLbe, nameInp, textLbe, submit, exit);
		//Main Page**************************************************************************************
		
		//Second Page************************************************************************************
		GridPane subPg = new GridPane();
		subPg.setPadding(new Insets(10, 10, 10, 10));
		subPg.setAlignment(Pos.CENTER);
		subPg.setVgap(8);
		subPg.setHgap(10);
		
		//Continue label and input	
		GridPane.setConstraints(contLbe, 0, 2);
		GridPane.setConstraints(contInp, 1, 2);
		
		//Submit button
		submit2.setPrefSize(70, 20);
		GridPane.setConstraints(submit2, 0, 3);
		submit2.setOnAction( e -> {
			if (continueCheck(contInp.getText().trim()) == true)
			{
				clear();
				window.setScene(mainPage);	
			};

		});
		
		//Exit button
		exit2.setPrefSize(70, 20);
		GridPane.setConstraints(exit2, 1, 3);
		exit2.setOnAction( e -> {
			window.close();
		});
		
		subPg.getChildren().addAll(contLbe, contInp, submit2, exit2);
		
		subPage = new Scene(subPg, 400, 200);
		mainPage = new Scene(mainPg, 400, 200);
		window.setScene(mainPage);
		window.show();
		
	}
	
	public boolean continueCheck(String y)
	{
		if (y.matches("[Yy]"))
		{
			return true;
		}
		return false;
	}
	
	public void clear()
	{
		yearInp.setText("");
		genderInp.setText("");
		nameInp.setText("");
		textLbe.setText("");
	}
	
	public void validCheck(String year, String name, String gender)
	{
		boolean valid1 = false;
		boolean valid2 = false;
		boolean valid3 = false;
		String error1 = "";
		String error2 = "";
		String error3 = "";
		alert.setTitle("Error");
		alert.setHeaderText("Invalid Input Fields");
		//Year Check
		if (year.isEmpty())
		{
			valid1 = true;
			error1 = "Please enter a year";
		}
		else if (year.matches("20[01][0-9]"))
		{
			valid1 = false;
		}
		else
		{
			valid1 = true;
			error1 = "Year must be from 2001 to 2010";
		}
		//Gender Check
		if (gender.isEmpty())
		{
			valid2 = true;
			error2 = "Please enter a gender";
		}
		if (gender.matches("[MmFf]"))
		{
			valid2 = false;
		}
		else 
		{
			valid2 = true;
			error2 = "Gender must be 'M' or 'F'";
		}
		//Name Check
		if (name.isEmpty())
		{
			valid3 = true;
			error1 = "Please enter a name";
		}
		else if (name.matches("[A-Z][a-z]+"))
		{
			valid3 = false;
		}
		else
		{
			valid3 = true;
			error3 = "Please enter a proper name";
		}
		
		
		alert.setContentText( error1 + "\n" +
							  error2 + "\n" +
							  error3
							);
		
		if (valid1 || valid2 || valid3 )
		{
		alert.showAndWait();
		}
	}
	
	public void searchFile(String filepath, String name, String gender) throws IOException
	{
		//get the name to search
        name = name.trim();
        String tempLine;
        String line[] = null;
        BufferedReader br = null;
        try
        {
        	//buffer reader
             br = new BufferedReader(new FileReader(filepath));

            while ((tempLine = br.readLine()) != null)
            {
            	//search line that contains the name\

                	//split line into a array
                    line = tempLine.split("\\s+");
                    
                    if (gender.compareToIgnoreCase("M") == 0 && name.compareToIgnoreCase(line[1]) == 0)
                    {
                    	//System Check
            			System.out.println("Ranking: " + line[0].trim());
            			System.out.println("Male Name: " + line[1].trim());
            			System.out.println(line[2].trim());
            			System.out.println("Female Name: " + line[3].trim());
            			System.out.println(line[4].trim());
            			
                    	textLbe.setText("Boy named " + line[1] + " is ranked #" + line[0] + " in " + yearInp.getText() + " year.");
                    	break;
                    }
                    if (gender.compareToIgnoreCase("F") == 0 && name.compareToIgnoreCase(line[3]) == 0)
                    {
                    	//System Check
            			System.out.println("Ranking: " + line[0].trim());
            			System.out.println("Male Name: " + line[1].trim());
            			System.out.println(line[2].trim());
            			System.out.println("Female Name: " + line[3].trim());
            			System.out.println(line[4].trim());
                    	
                    	textLbe.setText("Girl named " + line[3] + " is ranked #" + line[0] + " in " + yearInp.getText() + " year.");
                    	break;
                    }           
                }
            
        } catch (Exception e) {
            System.err.println("Cannot Open File "+ filepath);
        }
        
        //return array line
	}
	
}
