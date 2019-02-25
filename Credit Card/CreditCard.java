
import java.util.Scanner;

public class CreditCard
	public static void main(String[] args)
	{
	    // Create a Scanner
	    Scanner input = new Scanner(System.in);
	    
	    //Loop for adding more cards
		String addCard = "y";
		while (addCard.equals("y"))
		{
				
		    //Scanner to input credit card number
		    System.out.print("Enter a credit card as a long integer: ");
		    
		    String creditNumber = input.nextLine();
		    
		    boolean valid1 = validCard(creditNumber);
		    boolean valid2 = letterCheck(creditNumber);
		    boolean valid3 = checkPrefix(creditNumber);
		    
		    if (!valid2)
		    {
		    	System.out.println("Credit card " + creditNumber + " must be a number");
		    }
		    //Condition check and message display
		    else if(!valid3)
		    {
		    	System.out.println("Credit card " + creditNumber + " must be a valid card type");
		    }
		    else if(!valid1)
		    {
		    	System.out.println("Credit card " + creditNumber + " is not valid number");
		    }
		    else
		    {
		    	System.out.println("Credit card " + creditNumber + " is valid");
		    }
		    
		System.out.println("Do you want to enter another credit card? enter y or n: ");
		addCard = input.nextLine();
		}
	    input.close();
	}
	
	public static boolean validCard(String creditNumber)
	{
		boolean valid = false;
		
		//initialize integers
		int rightLeftOdd, rightLeftEven;
		
		//Get size of credit number
		int creditSize = cardSize(creditNumber);
		
		if(creditSize >= 13 && creditSize <=16)
		{
			//Get the methods through the steps
			rightLeftOdd = rightToLeftOdd(creditNumber);
			rightLeftEven = rightToLeftEven(creditNumber);
			
			//Add and check if valid
			if((rightLeftOdd + rightLeftEven) % 10 == 0)
			{
				valid = true;
			}
		}
		return valid;
		
	}
	
	//Find the sum of the right to left using even numbers
	public static int rightToLeftEven(String cardNum)
	{
		int evenNumSum = 0;
		//Loop to get the odd numbers and add the sum, check for double digits
		for( int i = cardNum.length() - 2; i > 0; i -= 2)
		{
			
				int sum = Integer.parseInt(cardNum.substring(i, i + 1));
				sum = checkDouble(sum);
				evenNumSum += sum;

		}
		
		return evenNumSum;
	}
	
	//Find the sum of the right to left using odd numbers
	public static int rightToLeftOdd(String cardNum)
	{
		int oddNumSum = 0;
		
		//loop to get odd numbers and add the sum
		for(int i = cardNum.length() - 1; i >= 0; i -= 2)
		{
			
				int sum = Integer.parseInt(cardNum.substring(i, i + 1));
				oddNumSum += sum;
				
		}
		
		return oddNumSum;
	}
	
	//Find the size of the credit card
	public static int cardSize(String cardNum)
	{
		return cardNum.length();
	}
	
	//Check for double digit and make them single
	public static int checkDouble(int num)
	{
		
		int number = num * 2;
		
		if(number > 9)
		{
			
			return (number % 10) + 1;
		}
		else
		{
			
			return number;
		}
	}
	
	//Check if the card is valid using prefix
	public static boolean checkPrefix(String cardNum)
	{
		//Create the boolean
		boolean result;
		
		//Conditions for the different type of cards
		if (cardNum.charAt(0) == '5')
		{
			result = true;
		}
		else if (cardNum.charAt(0) == '4')
		{
			result = true;
		}
		else if (cardNum.charAt(0) == '6')
		{
			result = true;
		}
		else if (cardNum.charAt(0) == '3' && cardNum.charAt(1) == '7')
		{
			result = true;
		}
		else 
		{
			result = false;
		}
		
		//Return the boolean
		return result;
	}
	
	public static boolean letterCheck(String cardNum)
	{
		boolean result = true;
		
		for (char c : cardNum.toCharArray()) 
		{
            if (Character.isLetter(c)) 
            {
            	result = false;
            }
        }
		return result;
	}
	
	
}
