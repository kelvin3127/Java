
import java.util.Scanner;

public class Location 
{
	public static void main(String[] args) 
	{
	    // Create a Scanner
	    Scanner input = new Scanner(System.in);
	    
	    //Display message and call for rows and columns
	    System.out.println("Enter the number of rows in the array: ");
	    int rows = input.nextInt();
	    System.out.println("Enter the number of columns in the array: ");
	    int columns = input.nextInt();
	    
	    //Create the array with specified size
	    double[][] array = new double[rows][columns];
	    
	    //Display message and enter array data
	    System.out.println("Enter the array: ");
	    
	    //Loop to enter the array data
	    for (int i = 0; i < array.length; i++)
	    {	
	        for (int j = 0; j < array[i].length; j++)
	        
	          array[i][j] = input.nextDouble();
	    }
	    
	    //make the Location object
	    Location largeLocation = locateLargest(array);
	    
	    System.out.println("The location of the largest element is"
	    + largeLocation + " at (" + largeLocation.row + ", " + largeLocation.column + ")");
	    
	    input.close();
	}
	
	//Get the largest array
	public static Location locateLargest(double[][] a)
	{
		Location tempLocation = new Location();
		double maxVal = a[a.length][a.length-1];
		
		//Loop for the max value
		for(int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				
				if (a[i][j] > maxVal)
				{
					a[i][j] = maxVal;

				}
			}
		}
		tempLocation.maxValue = maxVal;
		return tempLocation;
		
	
	}

	
	
}
