
public class Complex implements Cloneable
{
	
	double realNum;
	double fakeNum;
	
	public Complex()
	{
		realNum = 0;
		fakeNum = 0;
	}
	
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	
	
	public Complex( double rlNum, double fkNum)
	{
		realNum = rlNum;
		fakeNum = fkNum;
	}
	
	public double getRealNum()
	{
		return realNum;
	}
	
	public void setRealNum( float rlNum)
	{
		realNum = rlNum;
	}
	
	public double getFakeNum()
	{
		return fakeNum;
	}
	
	public void setFakeNum( float fkNum)
	{
		fakeNum = fkNum;
	}
		
	@Override
	public String toString()
	{
		String hi = null;
		return hi;
	}

}
