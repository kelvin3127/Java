import java.util.Scanner;

public class Complex 
{
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		Complex a = new Complex(3.5, 5.5);
		Complex b = new Complex(-3.5, 1);
		
		Complex adding = add(a, b);
		Complex subtracting = subtract(a, b);
		Complex multiplying = multi(a, b);
		Complex dividing = divide(a, b);
		Complex absing = abs(a);
	
		
		System.out.println("Your first complex number: " + a.getRealNum() + " " + a.getFakeNum());
		System.out.println("Your second complex number: " + b.getRealNum() + " " + b.getFakeNum());
		System.out.println("Real (" + a.getRealNum() + " + " + a.getFakeNum() + "i) + (" + b.getRealNum() + " + " + b.getFakeNum() + "i) = " + adding.getRealNum() + " + " + adding.getFakeNum() + "i");
		System.out.println("Real (" + a.getRealNum() + " - " + a.getFakeNum() + "i) + (" + b.getRealNum() + " - " + b.getFakeNum() + "i) = " + subtracting.getRealNum() + " + " + subtracting.getFakeNum() + "i");
		System.out.println("Real (" + a.getRealNum() + " * " + a.getFakeNum() + "i) + (" + b.getRealNum() + " * " + b.getFakeNum() + "i) = " + multiplying.getRealNum() + " + " + multiplying.getFakeNum() + "i");
		System.out.println("Real (" + a.getRealNum() + " / " + a.getFakeNum() + "i) + (" + b.getRealNum() + " / " + b.getFakeNum() + "i) = " + dividing.getRealNum() + " + " + dividing.getFakeNum() + "i");
		System.out.println("Real |( " + a.getFakeNum() + " + " + a.getFakeNum() + "i)| = " + absing.getRealNum());
		
		try {
			
			Complex cloneA = (Complex) a.clone();
			Complex cloneB = (Complex) b.clone();
			
			Complex cloneAdding = add(cloneA, cloneB);
			Complex cloneSubtracting = subtract(cloneA, cloneB);
			Complex cloneMultiplying = multi(cloneA, cloneB);
			Complex cloneDividing = divide(cloneA, cloneB);
			Complex cloneAbsing = abs(cloneA);
			
			System.out.println("Your cloned first complex number: " + a.getRealNum() + " " + a.getFakeNum());
			System.out.println("Your cloned second complex number: " + b.getRealNum() + " " + b.getFakeNum());
			System.out.println("Cloned (" + cloneA.getRealNum() + " + " + a.getFakeNum() + "i) + (" + cloneB.getRealNum() + " + " + b.getFakeNum() + "i) = " + cloneAdding.getRealNum() + " + " + cloneAdding.getFakeNum() + "i");
			System.out.println("Cloned (" + cloneA.getRealNum() + " - " + a.getFakeNum() + "i) + (" + cloneB.getRealNum() + " - " + b.getFakeNum() + "i) = " + cloneSubtracting.getRealNum() + " + " + cloneSubtracting.getFakeNum() + "i");
			System.out.println("Cloned (" + cloneA.getRealNum() + " * " + a.getFakeNum() + "i) + (" + cloneB.getRealNum() + " * " + b.getFakeNum() + "i) = " + cloneMultiplying.getRealNum() + " + " + cloneMultiplying.getFakeNum() + "i");
			System.out.println("Cloned (" + cloneA.getRealNum() + " / " + a.getFakeNum() + "i) + (" + cloneB.getRealNum() + " / " + b.getFakeNum() + "i) = " + cloneDividing.getRealNum() + " + " + cloneDividing.getFakeNum() + "i");
			System.out.println("Cloned |( " + cloneA.getFakeNum() + " + " + a.getFakeNum() + "i)| = " + cloneAbsing.getRealNum());
		}
		catch (CloneNotSupportedException err)
		{
			err.printStackTrace();
		}

		

	}
	
	public static Complex add(Complex a, Complex b) 
	{
		
		Complex temp = new Complex(0, 0);
		
		temp.realNum = a.realNum + b.realNum;
		temp.fakeNum = a.fakeNum + b.fakeNum;
		
		return temp;
	
	}
	
	public static Complex subtract(Complex a, Complex b)
	{
		Complex temp = new Complex(0, 0);
		
		temp.realNum = a.realNum - b.realNum;
		temp.fakeNum = a.fakeNum - b.fakeNum;
		
		return temp;
	}
	
	public static Complex multi(Complex a, Complex b) 
	{
		
		Complex temp = new Complex(0, 0);
		
		temp.realNum = (a.realNum * b.realNum) - (a.fakeNum * b.fakeNum);
		temp.fakeNum = (a.fakeNum * b.realNum) + (a.realNum * b.fakeNum);
		
		
		return temp;
	
	}
	
	public static Complex divide(Complex a, Complex b) 
	{
		
		Complex temp = new Complex(0, 0);
		
		temp.realNum = ((a.realNum * b.realNum) + (a.fakeNum * b.fakeNum)) / ((Math.pow(b.realNum, 2) + Math.pow(b.fakeNum, 2)) );
		temp.fakeNum = ((a.fakeNum * b.realNum) - (a.realNum * b.fakeNum)) / ((Math.pow(b.realNum, 2) + Math.pow(b.fakeNum, 2)) );
		
		return temp;
	
	}
	
	public static Complex abs(Complex a) 
	{
		
		Complex temp = new Complex(0, 0);
		
		temp.realNum = Math.sqrt((Math.pow(a.realNum, 2) + Math.pow(a.fakeNum, 2)));
		return temp;
	
	}
}
