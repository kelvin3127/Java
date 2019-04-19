
public class Adresses 
{
	String line;
	String firstName;
	String lastName;
	String city;
	String prov;
	String post;
	
	public Adresses() 
	{
		firstName = "";
		lastName = "";
		city = "";
		prov = "";
		post = "";
	}

	public Adresses(String fName, String lName, String cit, String pro, String pos)
	{
		firstName = fixedLength(fName, 15);
		lastName = fixedLength(lName, 15);
		city = fixedLength(cit, 15);
		prov = fixedLength(pro, 15);
		post = fixedLength(pos, 15);
	}
	
	public void setLine(String string)
	{
		line = fixedLength(string, 15);
	}
	
	public void setFirstName(String string)
	{
		firstName = fixedLength(string, 15);
	}
	
	public void setLastName(String string)
	{
		lastName = fixedLength(string, 15);
	}
	
	public void setCity(String string)
	{
		city = fixedLength(string, 15);
	}
	
	public void setProv(String string)
	{
		prov = fixedLength(string, 5);
	}
	
	public void setPost(String string)
	{
		post = fixedLength(string, 15);
	}	
	
	
	public String fixedLength(String string, int length) 
	{
		return String.format("%-" + length + "s", string); 
	}
}
