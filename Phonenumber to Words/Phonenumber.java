
public class Phonenumber 
{
	private String fileContent = "";
	private int phoneNumber;
	String letter;

	public String setLetter(int stringNum, int i)
	{
	 
	 if(stringNum == 2)
	 {
		if(i == 0)
		{
			letter = "a";
		}
		if(i == 1) 
		{
			letter = "b";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "c";
	  	}
	 }
	 if(stringNum == 3)
	 {
		if(i == 0)
		{
			letter = "d";
		}
		if(i == 1) 
		{
			letter = "e";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "f";
	  	}
	 }
	 if(stringNum == 4)
	 {
		if(i == 0)
		{
			letter = "g";
		}
		if(i == 1) 
		{
			letter = "h";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "i";
	  	}
	 }
	 if(stringNum == 5)
	 {
		if(i == 0)
		{
			letter = "j";
		}
		if(i == 1) 
		{
			letter = "k";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "l";
	  	}
	 }
	 if(stringNum == 6)
	 {
		if(i == 0)
		{
			letter = "m";
		}
		if(i == 1) 
		{
			letter = "n";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "o";
	  	}
	 }
	 if(stringNum == 7)
	 {
		if(i == 0)
		{
			letter = "p";
		}
		if(i == 1) 
		{
			letter = "q";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "r";
	  	}
	 }
	 if(stringNum == 8)
	 {
		if(i == 0)
		{
			letter = "s";
		}
		if(i == 1) 
		{
			letter = "t";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "u";
	  	}
	 }
	 if(stringNum == 9)
	 {
		if(i == 0)
		{
			letter = "v";
		}
		if(i == 1) 
		{
			letter = "w";
		} 
	  	if(i == 2) 
	  	{
	  		letter = "x";
	  	}
	 }
	return letter;
	 
	
	 
	}
	
	
	public void setFileContent( String letter )
	{
		fileContent += letter;
	}
	
	public String getFileContent()
	{
		return fileContent;
	}
	
	public void ClearFileContnet()
	{
		fileContent = "";
	}
	//sets phone number
	public void setPhoneNumber(int phoneNum)
	{
		phoneNumber = phoneNum;
	}
	
	//returns phone number
	public int getPhoneNumber()
	{
		return phoneNumber;
	}
	
	//convert to string to get numbers for check
	public String[] getStringNum(int phoneNum)
	{
		return Integer.toString(phoneNum).split("");
	}
	
}
