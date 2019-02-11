
import java.util.Scanner;
import java.util.Random;

public class task4
{
	
	//Boolean to check
	static boolean correctWord = false;
	
	public static void main(String[] args) 
	{
		//Scanner call
		Scanner input = new Scanner(System.in);
			
		//Array for a string of words
		String wordList[];
		wordList = new String[] {"java","program","eatter"};
		
		//Get the length of the array
		int arraySize = wordList.length;
		
		//While Loop for those who are still want to play after
		String playGame = "y";
		while (playGame.equals("y"))
		{
			//Random number generator for getting the word
			Random ranNum = new Random();
			int randomNum = ranNum.nextInt(arraySize) + 0;
			
			//get the word for the game
			String word = wordList[randomNum];
			
			//Get the word to be hidden
			String hiddenWord = HiddenWord(word);
			
			//Counter
			int count = 0;
			
			//While loop if the two words do not match
			while (!word.equals(hiddenWord))
			{
				//Message and input for word guess
				System.out.print("(Guess) Enter a letter in the word " + hiddenWord + " : ");
				char letter = input.next().charAt(0);
				
				//Condition to check for guessed word already found and display messages
				if (!wordCheck(hiddenWord, letter))
				{
					hiddenWord = guessWord(word, hiddenWord, letter);
					
					//Condition if letter is not in word display message and increase miss counter
					if (!correctWord)
					{
						System.out.println(letter + " is not in the word.");
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
	
	/*//Get the Word from the array
	public static String getWord()
	{
		
		Random ranNum = new Random();
		int randomNum = ranNum.nextInt(2) + 0;
		return wordList[randomNum]
	}
	*/
	
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



