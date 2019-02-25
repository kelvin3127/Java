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
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
	
	
	
public class HangmanFileIO 
{		
		//Boolean to check
		static boolean correctWord = false;
		public static void main(String[] args) throws IOException 
		{
			//Scanner call
			Scanner input = new Scanner(System.in);
			
			//ArrayList of words
			ArrayList<String> words = new ArrayList<String>();
			String wordsGuessed = "";
			
			boolean fileExists = false;
			//string for file
			String textFile = null;
			File fileCheck;

			System.out.println("Please enter the file you want to open");
			do
			{
				textFile = input.next();
				fileCheck = new File(textFile);
				if (fileCheck.exists())
				{
					fileExists = true;
				}	
				while (!fileExists)
				{
					System.out.println(" The file " + textFile + " was not found.");
					System.out.println(" Please enter a new filename: ");
					textFile = input.next();
					if (fileCheck.exists())
					{
						fileExists = true;
					}	
				}
				
			} while (!fileExists);
			FileInputStream fstream = new FileInputStream(textFile);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
			//bufferReader with try catch
			BufferedReader fileRead = new BufferedReader(new InputStreamReader(in));

			//counters
			String readerCount;
			int counter = 0;
			
			//while file is not at the end
			  while ((readerCount = fileRead.readLine()) != null) 
			  {
				  //add word into arraylist words
	                words.add(counter, readerCount);
	                counter++;
	                 
	          }
			  fileRead.close();
			
			//While Loop for those who are still want to play after
			String playGame = "y";
			while (playGame.equals("y"))
			{
			
				//somehow it became one big list so this splits it into array or words
				String[] wordLists = words.get(0).split(" ");
				
				//Random number generator for getting the word
				Random ranNum = new Random();
				int randomNum = ranNum.nextInt(wordLists.length) + 0;
				
				
				String word;
				word = wordLists[randomNum];
				
				//Get the word to be hidden
				String hiddenWord = HiddenWord(word);
				
				//Counter
				int count = 0;
				int a = 0;
				//While loop if the two words do not match
				while (!word.equals(hiddenWord))
				{
					//Message and input for word guess
					System.out.print("\n(Guess) Enter a letter in the word " + hiddenWord + " : ");
					char letter = input.next().charAt(0);
					
					//Condition to check for guessed word already found and display messages
					if (!wordCheck(hiddenWord, letter))
					{
						hiddenWord = guessWord(word, hiddenWord, letter);
						
						//Condition if letter is not in word display message and increase miss counter
						if (!correctWord)
						{
							System.out.println(letter + " is not in the word.");
							wordsGuessed += letter;
							System.out.print("Letters guessed: " + wordsGuessed);
							count++;
						}
						
					}
					else
					{
						System.out.println(letter + " is already in word.");
					}
				}
				
				//Print out the conclusion and if you want to play again
				System.out.println("The word is " + hiddenWord + ". you missed " + count + " time(s).");
				System.out.println("Do you want to guess another word? enter y or n: ");
				playGame = input.next();
				input.close();
				
				
			}
		}
			
			

		//Get the hidden word
	    public static String HiddenWord(String word) {
	    	
	    	//Create a hidden string
	        String hidden = "";
	        //Loop for the length of word and then add in length with *
	        for (int i = 0; i < word.length(); i++) {
	            hidden += "*";
	        }
	        //Return
	        return hidden;
	    }
	    
	    //A boolean to check if the word has already been found
	    public static boolean wordCheck(String hiddenWord, char letter)
	    {
	    	//Loop to find and check word
	    	for (int i = 0; i < hiddenWord.length(); i++)
	    	{
	    		//Condition to check if letter guess is already found
	    		if (letter == hiddenWord.charAt(i))
	    		{
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    //Check if guessed word is correct or not and replace words
	    public static String guessWord(String word, String hiddenWord, char letter)
	    {
	    	correctWord = false;
	    	//Temporary Storage for hidden word using String Builder
	    	StringBuilder tempWord = new StringBuilder(hiddenWord);
	    	
	    	//Loop the word
	    	for (int i = 0; i < word.length(); i++)
	    	{
	    		
	    		//Condition check for letter guess is in the word and if word is not already found
	    		if ( letter == word.charAt(i) && tempWord.charAt(i) == '*' )
	    		{
	    			
	    			//Word Found and conditions met it is true
	    			correctWord = true;
	    			//Delete and insert the letter
	    			tempWord = tempWord.deleteCharAt(i);
	    			tempWord = tempWord.insert(i, letter);
	    			
	    			
	    			//String tempWord = hiddenWord.substring(0, i) + letter + hiddenWord.substring(i + 1);
	    			//return tempWord.toString();
	    		}
	    		
	    	}
	    	return tempWord.toString();
			
	    }
	}

