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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LetterCount
{
	public static void main(String[] args) throws IOException
	{
	
		//Scanner call
		Scanner input = new Scanner(System.in);
		LetterCounter letters = new LetterCounter();
		//check file is real
		boolean fileExists = false;
		//string for file
		String textFile = null;
		File fileCheck;
		//Check which file to open
		System.out.println("Please enter the file you want to open");
		do
		{

			textFile = input.next();
			fileCheck = new File(textFile);
			if (fileCheck.exists())
			{
				fileExists = true;
			}	
			System.out.println(" The file " + textFile + " was not found.");
			System.out.println(" Please enter a new filename: ");
				
			
		} while (!fileExists);
		
		//bufferReader with try catch
		BufferedReader fileRead = new BufferedReader(new FileReader(textFile));
		try 
		{
			int readerCount = 0;
			
			while((readerCount = fileRead.read()) != -1) 
			{
				char character = (char) readerCount;
				String letter = Character.toString(character);
				
				switch (letter.toUpperCase())
				{
					case "A":
						letters.setA();
						break;
					case "B":
						letters.setB();
						break;
					case "C":
						letters.setC();
						break;
					case "D":
						letters.setD();
						break;
					case "E":
						letters.setE();
						break;
					case "F":
						letters.setF();
						break;
					case "G":
						letters.setG();
						break;
					case "H":
						letters.setH();
						break;
					case "I":
						letters.setI();
						break;
					case "J":
						letters.setJ();
						break;
					case "K":
						letters.setK();
						break;
					case "L":
						letters.setL();
						break;
					case "M":
						letters.setM();
						break;
					case "N":
						letters.setN();
						break;
					case "O":
						letters.setO();
						break;
					case "P":
						letters.setP();
						break;
					case "Q":
						letters.setQ();
						break;
					case "R":
						letters.setR();
						break;
					case "S":
						letters.setS();
						break;
					case "T":
						letters.setT();
						break;
					case "U":
						letters.setU();
						break;
					case "V":
						letters.setV();
						break;
					case "W":
						letters.setW();
						break;
					case "X":
						letters.setX();
						break;
					case "Y":
						letters.setY();
						break;
					case "Z":
						letters.setZ();		
						break;
				}
				
				readerCount = -1;
			}
			System.out.println("Number of A's: " + letters.getA());
			System.out.println("Number of B's: " + letters.getB());
			System.out.println("Number of C's: " + letters.getC());
			System.out.println("Number of D's: " + letters.getD());
			System.out.println("Number of E's: " + letters.getE());
			System.out.println("Number of F's: " + letters.getF());
			System.out.println("Number of G's: " + letters.getG());
			System.out.println("Number of H's: " + letters.getH());
			System.out.println("Number of I's: " + letters.getI());
			System.out.println("Number of J's: " + letters.getJ());
			System.out.println("Number of K's: " + letters.getK());
			System.out.println("Number of L's: " + letters.getL());
			System.out.println("Number of M's: " + letters.getM());
			System.out.println("Number of N's: " + letters.getN());
			System.out.println("Number of O's: " + letters.getO());
			System.out.println("Number of P's: " + letters.getP());
			System.out.println("Number of Q's: " + letters.getQ());
			System.out.println("Number of R's: " + letters.getR());
			System.out.println("Number of S's: " + letters.getS());
			System.out.println("Number of T's: " + letters.getT());
			System.out.println("Number of U's: " + letters.getU());
			System.out.println("Number of V's: " + letters.getV());
			System.out.println("Number of W's: " + letters.getW());
			System.out.println("Number of X's: " + letters.getX());
			System.out.println("Number of Y's: " + letters.getY());
			System.out.println("Number of Z's: " + letters.getZ());
		} catch (FileNotFoundException sasd) {
			System.out.println("File does not exist, please enter a new file");
		}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

