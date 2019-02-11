
public class Square extends GeometricObject
{
	
	private double width;
	private double height;
	
	//Constructor
	public Square()
	{
		width = 1;
		height = 1;
	}
	
	public Square(double wth, double hgt)
	{
		width = wth;
		height = hgt;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setWidth(double wtd)
	{
		width = wtd;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setHeight(double hgt)
	{
		height = hgt;
	}
	
	public double getArea()
	{
		double area = width * height;
		return area;
	}
	
	@Override
	public void howToColor()
	{
		if (getArea() > 0)
		{
			System.out.println("Color all four sides");
		}
	}
}
