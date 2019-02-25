import java.util.Scanner;



public class CramersRule

{
	
	public static void main(String[] args)
	
	{
		
		Scanner input = new Scanner(System.in);
		//Create new Scanner object

		
		//Enter the values for the letters
		
		System.out.print("Enter the values for the following letters a, b, c, d, e and f in that order: ");

		double a = input.nextDouble();
		
		double b = input.nextDouble();
		
		double c = input.nextDouble();
		
		double d = input.nextDouble();
		
		double e = input.nextDouble();
		
		double f = input.nextDouble();

	
	
		double x = ((e*d) - (b*f)) / ((a*d) - (b*c)); 	
		double y = ((a*f) - (e*c)) / ((a*d) - (b*c));	
		if ( ((a*d) - (b*c)) == 0)
		
		{
			
			System.out.println("The equation has no solution");
		
		}
		
		else
		
		{
			
			System.out.println("x is " + x + " and y is " + y);

		}

	}

}



