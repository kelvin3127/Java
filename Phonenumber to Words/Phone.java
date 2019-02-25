
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/************************************************************************************
Course:JAC444 - Winter
Last Name: Chen
First Name: Cheng Kun
ID: 129306171
Section: B
This assignment represents my own work in accordance with Seneca Academic Policy.
Cheng Kun Chen
Date: 2/14/19
************************************************************************************/	
public class Phone
{
	public static void main(String[] args)
	{
	Phonenumber phoneNum = new Phonenumber();
	Scanner input = new Scanner(System.in);
	String []stringNum;
	String []word = new String[7]; 
	int number;

	//Get the number
	System.out.println("Please enter a phone number: ");
	do 
	{
		while (!input.hasNextInt())
		{
			System.out.println("Phonenumber must all be numbers"); //checks higher number here
			input.next();
		}
		number = input.nextInt();
		phoneNum.setPhoneNumber(number);
		stringNum = phoneNum.getStringNum(number);
		if ( stringNum.length > 7 || stringNum.length < 7)
		{
			System.out.println("Phone number must be 7 digits");
		}
	} while ( stringNum.length > 7 || stringNum.length < 7);
	
	//close the scanner
	input.close();
	
	//Try and catch for file
	try {
		//make new file called phonenumber
	    File file = new File("phonenumber.txt");
	    //check if the file exists, if not make the file
	    if (!file.exists()) {
	    	file.createNewFile();
	    }
	    
	    //Create filwriter
	    FileWriter fw = new FileWriter(file);
	    //create bufferwriter
	    BufferedWriter writer = new BufferedWriter(fw);
	    
			//Loop for letters a,b,c
			for (int i = 0; i < 3; i++)
			{
				word[0] = phoneNum.setLetter(Integer.parseInt(stringNum[0]), i);
				//Loop for letters c,d,e
				for (int j = 0; j < 3; j++)
				{
					word[1] = phoneNum.setLetter(Integer.parseInt(stringNum[1]), j);
					//Loop for letters f,g,h
					for (int k = 0; k < 3; k++)
					{
						word[2] = phoneNum.setLetter(Integer.parseInt(stringNum[2]), k);
						//Loop for letters i,j,k
						for (int l = 0; l < 3; l++)
						{
							word[3] = phoneNum.setLetter(Integer.parseInt(stringNum[3]), l);
							//Loop for letters l,m,n
							for (int m = 0; m < 3; m++)
							{
								word[4] = phoneNum.setLetter(Integer.parseInt(stringNum[4]), m);
								//Loop for letters o,p,q
								for (int n = 0; n < 3; n++)
								{
									word[5] = phoneNum.setLetter(Integer.parseInt(stringNum[5]), n);
									//Loop for letters r,s,t
									for (int o = 0; o < 3; o++)
									{
										word[6] = phoneNum.setLetter(Integer.parseInt(stringNum[6]), o);
										
										
										//loop to get the 7 letters and then place them into a string
										for (int c =  0; c < 7; c++)
										{		
											phoneNum.setFileContent(word[c]);
										}
										//write the word into the file
										writer.write(phoneNum.getFileContent());
										//print out the words
										System.out.print(phoneNum.getFileContent() + "\n");
										//Clear if there is string is not empty
										if( phoneNum.getFileContent() != null)
										{
												phoneNum.ClearFileContnet();
										}							 
									}							
								}
							}
						}
					}
				}
			}
			
		//Print message if file sucessfully written
		System.out.println("File written Successfully to \"" + file + "\"");
		//Close the file
		writer.close();
		} catch (IOException ex) {
			//print the error
			System.out.println(ex);
		}
	}

}
