import java.util.Scanner;

public class BankLoans
{
	public static void main(String[] args)
	{
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the number of banks: ");
		int howMany;
		do 
		{
			while (!input.hasNextInt())
			{
				System.out.println("That is not a number");
				input.next();
			}
			howMany = input.nextInt();
			if ( howMany < 2)
			{
				System.out.println("There must be at least 2 banks participating");
			}
		} while ( howMany < 2);
		
		System.out.println("Please enter the minimum asset limit for all banks: ");
		float limit;
		do
		{
			while (!input.hasNextFloat())
				{
				System.out.println("That is not a number");
				input.next();
				}
			limit = input.nextFloat();
			if ( limit <= 0 )
			{
				System.out.println("Please enter a limit greater than 0");
			}
		} while (limit <= 0);
		
		//Create 5 bank objects
		Banks bank[] = new Banks[(howMany)];
		
		//Loop to create 5 arrays
		for (int i = 0; i < howMany; i++)
		{
			bank[i] = new Banks();
		}
		
		for (int i = 0; i < howMany; i++)
		{
			bank[i].setId(i);
			bank[i].setBankNum(howMany);
			System.out.println("Bank " + bank[i].getId());
			
			System.out.println("Balance: ");
			float bal;
			do
			{
				while (!input.hasNextFloat())
				{
					System.out.println("That is not a number");
					input.next();
				}
				bal = input.nextFloat();
				
				if (bal < 0)
				{
					System.out.println("Please enter a correct balance");
				}
				
			} while (bal < 0);
			
			bank[i].setBalance(bal);
			bank[i].setLoans(howMany);
			
			//********************** GET THE NUMBER OF BANKS LOANED **************************/
			System.out.println("Number of banks loaned:");
			int bankLoaned;
			do 
			{
			    while (!input.hasNextInt()) 
			    {
			        System.out.println("That's not a number");
			        input.next(); // this is important!	        
			    }	    
			    bankLoaned = input.nextInt();		    
			    if (bankLoaned < 0 || bankLoaned > (howMany - 1))
			    {
			    	System.out.println("You can't have negative amount of banks or greater than " + (howMany - 1));
			    }	    
			} while (bankLoaned < 0 || bankLoaned > (howMany - 1));
			
			bank[i].setBanksLoaned(bankLoaned);
			
			//***************************LOAN TO THE OTHER BANKS********************************/
			for (int j = 0; j < bankLoaned; j++)
			{
				
				System.out.println("Bank ID: ");
				int id;
				do
				{
					while (!input.hasNextInt())
					{
						System.out.println("That is not a number");
						input.next();
					}
					
					id = input.nextInt();
					
					if (id < 0 || id > howMany || id == bank[i].getId() )
					{
						System.out.println("You can't loan to yourself or Invalid bank Id");
					}
				
				} while (id < 0 || id > howMany || id == bank[i].getId());
				
				
				System.out.println("Amount loaned: ");
				float loanAmt;
				do
				{
					while(!input.hasNextFloat())
					{
						System.out.println("That is not a number");
						input.next();
					}
					
					loanAmt = input.nextFloat();
					
					if (loanAmt <= 0)
					{
						System.out.println("Loan amount must be higher than 0");
					}
					
				} while ( loanAmt <= 0);
				
				bank[i].addLoans(id, loanAmt, howMany);				
			}			
		}	
		
		input.close();
		
		for ( int i = 0; i < howMany; i++)
		{
			//Set totalLaon and Assets to start the check
			bank[i].setTotalLoan(howMany);
			bank[i].setTotalAssets();
			
			//Check if the bank is safe
			bank[i].setIsSafe(limit);
		}
		
		Boolean[] safeCheck = new Boolean[howMany];
		for (int i = 0; i < howMany; i++)
		{
		safeCheck[i] = bank[i].getIsSafe();
		System.out.println("Bank: "+ i + " is " + safeCheck[i]);	
		}
		
		for (int i = 0; i < howMany; i++)
		{
			bank[i].setloanSafe( safeCheck, howMany);
			bank[i].setTotalLoan(howMany);
			bank[i].setTotalAssets();
			bank[i].setIsSafe(limit);	
			System.out.println("\nBank "+ i + " information");
			System.out.println("Balance : "+ bank[i].getBalance());
			System.out.println("Total loans : "+ bank[i].getTotalLoan());
			System.out.println("Total assets : "+ bank[i].getTotalAssets());
		}
			
		System.out.println("\nBanks Status: " );
		for (int i = 0; i < howMany; i++)
		{
			System.out.print("Bank " + bank[i].getId() + ": " );
			if (bank[i].getIsSafe() == true)
			{
				System.out.println("Safe");
			}
			else 
			{
				System.out.println("Unsafe");
			}
		}
			
	}
		
	
	
}

