import java.io.Serializable;

public class Account implements Serializable
{
	private int id;
	private int pinNum;
	private String firstName;
	private String lastName;
	private double balance;
	
	
	
	public Account()
	{
		balance = 0;
		id = 0;
		firstName = "";
		lastName = "";
	}
	
	public Account(int i, String fName, String lName, double bal, int pin)
	{
		firstName = fName;
		lastName = lName;
		balance = bal;
		id = i;
		pinNum = pin;
	}
	
	public void setLastName(String name)
	{
		lastName = name;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setFirstName(String name)
	{
		firstName = name;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setPin(int p)
	{
		pinNum = p;
	}
	public int getPin()
	{
		return pinNum;
	}
	
	public void setId(int i)
	{
		id = i;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setBalance(double bal)
	{
		balance = bal;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	
	
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public boolean validate(int id, int pin)
	{
		int tempId = id;
		int tempPin = pin;
		if (pinNum == tempPin && tempId == this.id)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
