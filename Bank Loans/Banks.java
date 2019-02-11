import java.util.ArrayList;

public class Banks 
{
	//*
	private int bankNum;
	//*
	private int bankId;
	//*
	private float totalAssets;
	//*
	private int banksLoaned;
	//*
	private float balance;
	//*
	private float totalLoan;
	//
	private boolean isSafe;
	//*
	private ArrayList<Number> loans = new ArrayList<Number>();
	//
	
	
	
	
			
	public Banks()
	{
		bankId = 0;
		totalAssets = 0;
		banksLoaned = 0;
		totalLoan = 0;
		balance = 0;
		isSafe = true;
		
	}
	
	
	

	
	//Loans*********************************************
	public void setLoans(int howMany)
	{
		int tempAmt = 0;
		for (int i = 0; i < howMany; i++)
		{
			loans.add(tempAmt);
		}
		
	}
	
	public void addLoans(int bankId, float amount, int howMany)
	{
		
			Number tempLoan = loans.get(bankId);
			
			if (tempLoan.floatValue() == 0)
			{
				loans.set(bankId, amount);
			}
		
		
	}
	
	public void setloanSafe( Boolean[] safeCheck, int howMany)
	{
		int temp = 0;		
		for (int i = 0; i < howMany; i++)
		{
			if (safeCheck[i].equals(false))
			{
				loans.set(i, temp);
			}
		}
		
	}
	
	
	
	//IsSafe*****************************************
	public void setIsSafe(float limit)
	{
		isSafe = true;
		
		if ( totalAssets < limit )
		{
			isSafe = false;
		}
		
	}
	
	public boolean getIsSafe()
	{
		return isSafe;
	}
	
	//TotalLaon************************************
	public void setTotalLoan(int howMany)
	{
		totalLoan = 0;
		for ( int i = 0; i < howMany; i++)
		{
			Number tempLoan = loans.get(i);
			if (tempLoan.floatValue() > 0)
			{
				totalLoan += tempLoan.floatValue();
			}
		}
		
	}
	
	public float getTotalLoan()
	{
		return totalLoan;
	}
	
	//BanksLoaned*******************************
	public int getBanksLoaned()
	{
		return banksLoaned;
	}
	
	public void setBanksLoaned(int i)
	{
		banksLoaned = i;
	}
	
	//BankId**************************************
	public void setId(int i)
	{
		bankId = i;
	}
	
	public int getId()
	{
		return bankId;
	}
	
	//Total Assets********************************
	public void setTotalAssets()
	{
		totalAssets = balance + totalLoan;
	}
	
	public float getTotalAssets()
	{
		return totalAssets;
	}
	
	//Balance*************************************
	public float getBalance()
	{
		return balance;
	}
	
	public void setBalance(float bal)
	{
		balance = bal;
	}
	
	//BankNum**************************************
	public int getBankNum()
	{
		return bankNum;
	}
	
	public void setBankNum(int howMany)
	{
		bankNum = howMany;
	}
}





