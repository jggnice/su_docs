package pac0;


class Rectangle 
{
	double width = 1.0;
	double height = 1.0;
	public Rectangle(){}
	public Rectangle(double d,double e)
	{
		this.width = d;
		this.height = e;		
	}
	public double getArea()
	{
		return this.height*this.width;		
	}
	public double getPerimeter()
	{
		return 2*(this.height+this.width);		
	}
	public String toString()
	{
		return 
				"width = "+this.width
				+"\nheight = "+this.height
				+"\nArea = "+this.getArea()
				+"\nPerimeter = "+this.getPerimeter()
				+"\n";
	}
}

