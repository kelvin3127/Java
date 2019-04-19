
public class addMatrix 
{
	static int matrixSize = 1000;
	static int[][] matrix1 = new int[matrixSize][matrixSize];
	static int[][] matrix2 = new int[matrixSize][matrixSize];
	static int[][] matrixSum = new int[matrixSize][matrixSize];
	static int[][] matrix3 = new int[matrixSize][matrixSize];
	static int[][] matrix4 = new int[matrixSize][matrixSize];
	static int[][] matrixSum2 = new int[matrixSize][matrixSize];
	
	public static void main(String[] args) throws InterruptedException 
	{
	
		for (int i = 0; i < matrixSize; i++)
		{	
			for (int j = 0; j < matrixSize; j++)
			{
				matrix1[i][j] = getRandomInteger(100, 1);
				matrix2[i][j] = getRandomInteger(100, 1);
			}
		}
		
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < matrixSize; i++)
		{
			for (int j = 0; j < matrixSize; j++)
			{
				matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime + "ms");
		
	    
	    //THREADS ******************************************************************
	    
	    Task1 task1 = new Task1();
	    Task2 task2 = new Task2();
	    Task3 task3 = new Task3();
		Thread tread = new Thread(task1);
		Thread tread2 = new Thread(task2);
		Thread tread3 = new Thread(task3);
		
		long startTime2 = System.currentTimeMillis();
		tread.start();
		try
		{
			tread.join();
		} catch (InterruptedException ex)
		{
			System.out.println(ex);
		}
		tread2.start();
		try
		{
			tread2.join();
		} catch (InterruptedException ex)
		{
			System.out.println(ex);
		}
		tread3.start();

		long stopTime2 = System.currentTimeMillis();
	    long elapsedTime2 = stopTime2 - startTime2;
	    System.out.println( "Thread " + elapsedTime2 + "ms");
	   
	}
	
	static class Task3 implements Runnable
	{
		@Override
		public void run()
		{
			for (int i = 0; i < matrixSize; i++)
			{
				for (int j = 0; j < matrixSize; j++)
				{
					matrixSum2[i][j] = matrix1[i][j] + matrix2[i][j];
				}
			}
		}
	}
	
	static class Task1 implements Runnable
	{
		@Override
		public void run() 
		{
			for (int i = 0; i < 999; i++)
			{	
				for (int j = 0; j < matrixSize; j++)
				{
					matrix3[i][j] = getRandomInteger(100, 1);
					matrix4[i][j] = getRandomInteger(100, 1);
				}
			}
			
		}

	}
	
	static class Task2 implements Runnable
	{
		@Override
		public void run() 
		{
			for (int i = 1000; i < matrixSize; i++)
			{	
				for (int j = 0; j < matrixSize; j++)
				{
					matrix3[i][j] = getRandomInteger(100, 1);
					matrix4[i][j] = getRandomInteger(100, 1);
				}
			}
		}

	}
	
	public static int getRandomInteger(int maximum, int minimum)
	{ 
		return ((int) (Math.random()*(maximum - minimum))) + minimum; 
	}

}
