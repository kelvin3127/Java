
import java.util.Scanner;
public class task3
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Loan Amount: ");
		double loan = input.nextDouble();
		double balance = loan;
		
		System.out.println("Number of Years: ");
		int numberOfYears = input.nextInt();
		
		System.out.println("Annual Interest Rate: ");
		double rate = input.nextDouble();
		double monthlyInterestRate = rate / 1200;
		
		double monthlyPayment = loan * (monthlyInterestRate / ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		System.out.format("\nMonthly Payment: %-10.2f\n", monthlyPayment);
		
		double total = monthlyPayment * 12 + numberOfYears;
		System.out.format("Total Payment: %-10.2f\n", total);
		
		System.out.println("\nPayment#\tInterest\tPrincipal\tBalance");
		double principal;
		double interest;
		
		for(int i=1; i <= numberOfYears * 12; i++) {
			interest = monthlyInterestRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal*1.0;
			System.out.format("%-16d%5.2f%17.2f%17.2f\n",i,interest,principal,balance);
			//System.out.println(i + "\t\t" + interest + "\t" + principal + "\t" + balance);
		}
	}
}