import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mathQuiz extends Application
{
	static int maximum = 100;
	static int minimum = 1;
	int rightCounter = 0;
	int wrongCounter = 0;
	static int num1;
	static int num2;
	boolean validCheck;
	Stage windowStage;
	Scene mainScene;
	
	Alert alert = new Alert(AlertType.ERROR);
	
	Label topLbe = new Label("");
	Label addLbe = new Label("");
	Label subtractLbe = new Label("");
	Label multiplyLbe = new Label("");
	Label divideLbe = new Label("");
	Label correctLbe = new Label("Number of Correct Answers: ");
	Label wrongLbe = new Label("Number of Wrong Answers: ");
	Label correctAnsLbe = new Label("");
	Label wrongAnsLbe = new Label("");
	Label contLbe = new Label("Would you like to try with two other different numbers?:");
	
	TextField addInp = new TextField();
	TextField subtractInp = new TextField();
	TextField multiplyInp = new TextField();
	TextField divideInp = new TextField();
	TextField contInp = new TextField();
	
	Button submit = new Button("Submit");
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception 
	{
		windowStage = window;
		window.setTitle("Math Quiz Application");
		num1 = getRandomNum();
		num2 = getRandomNum();
		settext(num1, num2);
		
		//Center GridPane*******************************************
		GridPane gridCenter = new GridPane();
		gridCenter.setPadding(new Insets(10, 10, 10, 10));
		gridCenter.setAlignment(Pos.CENTER);
		gridCenter.setVgap(8);
		gridCenter.setHgap(10);
		
		GridPane.setConstraints(topLbe, 0, 0);
		GridPane.setConstraints(addLbe, 0, 1);
		GridPane.setConstraints(addInp, 1, 1);
		GridPane.setConstraints(subtractLbe, 0, 2);
		GridPane.setConstraints(subtractInp, 1, 2);
		GridPane.setConstraints(multiplyLbe, 0, 3);
		GridPane.setConstraints(multiplyInp, 1, 3);
		GridPane.setConstraints(divideLbe, 0, 4);
		GridPane.setConstraints(divideInp, 1, 4);
		GridPane.setConstraints(correctLbe, 0, 5);
		GridPane.setConstraints(correctAnsLbe, 1, 5);
		GridPane.setConstraints(wrongLbe, 0, 6);
		GridPane.setConstraints(wrongAnsLbe, 1, 6);
		GridPane.setConstraints(contLbe, 0, 7);
		GridPane.setConstraints(contInp, 1, 7);
		GridPane.setConstraints(submit, 0, 8);
		
		submit.setOnAction( e -> {
			
			validCheck(addInp.getText().trim(), subtractInp.getText().trim(), multiplyInp.getText().trim(), divideInp.getText().trim(), contInp.getText().trim());
			
			if (validCheck == true)
			{
				if (addCheck(num1, num2, addInp.getText().trim()))
				{
					rightCounter++;
				}
				else 
				{
					wrongCounter++;
				}
				if (subtractCheck(num1, num2, subtractInp.getText().trim()))
				{
					rightCounter++;
				}
				else 
				{
					wrongCounter++;
				}
				if (multiplyCheck(num1, num2, multiplyInp.getText().trim()))
				{
					rightCounter++;
				}
				else 
				{
					wrongCounter++;
				}
				if (divideCheck(Integer.toString(num1), Integer.toString(num2), divideInp.getText().trim()))
				{
					rightCounter++;
				}
				else 
				{
					wrongCounter++;
				}
					
			correctAnsLbe.setText(Integer.toString(rightCounter));
			wrongAnsLbe.setText(Integer.toString(wrongCounter));
			wrongCounter = 0;
			rightCounter = 0;
			}
			
			if (contInp.getText().matches("[Yy]"))
			{
				clear();
				num1 = getRandomNum();
				num2 = getRandomNum();
				settext(num1, num2);	
			}
			else if (contInp.getText().matches("[Nn]"))
			{
				window.close();
			}
		
			
		});
		
		gridCenter.getChildren().addAll(addLbe, addInp, subtractLbe, subtractInp, multiplyLbe, multiplyInp, 
										divideLbe, divideInp, correctLbe, correctAnsLbe, 
										topLbe, wrongLbe, wrongAnsLbe, contLbe, contInp, submit);
		
		//Everything********************************************

		mainScene = new Scene(gridCenter, 600, 500);
		
		window.setScene(mainScene);
		window.show();
		
	}
	
	public void validCheck(String add, String subtract, String multiply, String divide, String yn)
	{
		boolean valid1 = false;
		boolean valid2 = false;
		boolean valid3 = false;
		boolean valid4 = false;
		String error1 = "";
		String error2 = "";
		String error3 = "";
		String error4 = "";
		alert.setTitle("Error");
		alert.setHeaderText("Invalid Input Fields");
		//Add Check
		if ((yn != "n") || (yn != "N"))
		{
			if (add.isEmpty())
			{
				valid1 = true;
				error1 = "Please enter a addition number";
			}
			else if (add.matches("-?[1-9]\\d*|0"))
			{
				valid1 = false;
			}
			else
			{
				valid1 = true;
				error1 = "Please enter a addition number";
			}
			//Subtract Check
			if (subtract.isEmpty())
			{
				valid2 = true;
				error2 = "Please enter a subtraction number";
			}
			if (subtract.matches("-?[1-9]\\d*|0"))
			{
				valid2 = false;
			}
			else 
			{
				valid2 = true;
				error2 = "Please enter a subtraction number";
			}
			//Multiply Check
			if (multiply.isEmpty())
			{
				valid3 = true;
				error3 = "Please enter a muliplication number";
			}
			else if (multiply.matches("-?[1-9]\\d*|0"))
			{
				valid3 = false;
			}
			else
			{
				valid3 = true;
				error3 = "Please enter a muliplication number";
			}
			//Divide Check
			if (divide.isEmpty())
			{
				valid4 = true;
				error4 = "Please enter a division number";
			}
			else if (divide.matches("-?[0-9]+(\\.[0-9][0-9]?)?"))
			{
				valid4 = false;
			}
			else
			{
				valid4 = true;
				error4 = "Please enter a division number";
			}
			
			validCheck = true;
		}
		alert.setContentText( error1 + "\n" +
							  error2 + "\n" +
							  error3 + "\n" +
							  error4
							);
		
		if (valid1 || valid2 || valid3 || valid4)
		{
		alert.showAndWait();
		validCheck = false;		
		}
	}
	
	public static int getRandomNum()
	{
		return (int) ((Math.random()*(maximum - minimum))) + minimum;
	}
	
	public boolean addCheck( int num1, int num2, String inpNum)
	{
		int add = num1 + num2;
		if (add == Integer.parseInt(inpNum))
		{
			return true;
		}
		return false;
	}
	
	public boolean subtractCheck( int num1, int num2, String inpNum)
	{
		int subtract = num1 - num2;
		if (subtract == Integer.parseInt(inpNum))
		{
			return true;
		}
		return false;
	}
	
	public boolean multiplyCheck( int num1, int num2, String inpNum)
	{
		int multiply = num1 * num2;
		if (multiply == Integer.parseInt(inpNum))
		{
			return true;
		}
		return false;
	}
	
	public boolean divideCheck( String num1, String num2, String inpNum)
	{
		double divide = Double.parseDouble(num1) / Double.parseDouble(num2);
		divide = Math.round(divide * 100.0) / 100.0;
		if (divide == Double.parseDouble(inpNum))
		{
			return true;
		}
		return false;
	}
	
	public void settext( int num1, int num2)
	{
		topLbe.setText("Two randomly generated numbers are: " + num1 + " and " + num2);
		addLbe.setText("What is the addition of " + num1 + " and " + num2);
		subtractLbe.setText("What is the subtraction of " + num1 + " and " + num2);
		multiplyLbe.setText("What is the multiplication of " + num1 + " and " + num2);
		divideLbe.setText("What is the division of " + num1 + " and " + num2);
		
	}
	
	public void clear()
	{
		addInp.setText("");
		subtractInp.setText("");
		multiplyInp.setText("");
		divideInp.setText("");
		correctAnsLbe.setText("");
		wrongAnsLbe.setText("");
		contInp.setText("");
		rightCounter = 0;
		wrongCounter = 0;
		
	}

}
