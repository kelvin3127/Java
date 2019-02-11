/************************************************************************************
Course:JAC444 - Winter
Last Name: Chen
First Name: Cheng Kun
ID: 129306171
Section: B
This assignment represents my own work in accordance with Seneca Academic Policy.
Cheng Kun Chen
Date: 1/30/19
************************************************************************************/
import java.util.Scanner;

public class Task9 
{
	
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		boolean isNumber;
		int howMany = 0;
		
		System.out.println("Please enter the number of squares you want to create");
		do 
		{
			if(input.hasNextInt())
			{
			howMany = input.nextInt();
			isNumber = true;
			}
			else
			{
				System.out.println("Please enter a number");
				isNumber = false;
				input.next();
			}
		} while (!(isNumber));
		
		Square shape[] = new Square[howMany];	
		
		for(int i = 0; i < howMany; i++)
		{
			shape[i] = new Square();
		}
		
		System.out.println("You have created " + howMany + " squares");
		
		for(int i = 0; i < howMany; i++)
		{
		System.out.println("\nYou are working with Square " + (i + 1));
			
		System.out.println("Please enter the height of the square: ");
		do 
		{
			if(input.hasNextDouble())
			{
			double height = input.nextDouble();
			shape[i].setHeight(height);
			isNumber = true;
			}
			else
			{
				System.out.println("Please enter a number");
				isNumber = false;
				input.next();
			}
		} while (!(isNumber));
		
		System.out.println("Please enter the width of the square: ");
		do 
		{
			if(input.hasNextDouble())
			{
			double width = input.nextDouble();
			shape[i].setWidth(width);
			isNumber = true;
			}
			else
			{
				System.out.println("Please enter a number");
				isNumber = false;
				input.next();
			}
		} while (!(isNumber));
				
		System.out.println("\nSquare " + (i + 1));
		System.out.println("Height is " + shape[i].getHeight());
		System.out.println("Width is " + shape[i].getWidth());
		shape[i].howToColor();
		System.out.println("Square Area is " + shape[i].getArea() );
		
		}
		
		input.close();
	}
	
}
