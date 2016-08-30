package pac0;

public class Circle2D 
{
	private double x;
	private double y;
	private double radius;
	
	public Circle2D()
	{
		this(0,0,1.0);
	}
	public Circle2D(double x,double y,double radius)
	{
		this.setX(x);
		this.setY(y);
		this.setRadius(radius);
	}
	public double getArea()
	{
		return this.radius*this.radius*Math.PI;		
	}
	public double getPerimeter()
	{
		return 2*this.radius*Math.PI;
	}
	public boolean contains(double x1,double y1)
	{
		double distance = Math.sqrt((this.x-x1)*(this.x-x1)+(this.y-y1)*(this.y-y1));
		if(distance < this.getRadius()) return true;
		else return false;
	}
	public boolean contains(Circle2D circle)
	{
		double distance=Math.sqrt((circle.getX()-this.getX())*(circle.getX()-this.getX())+(circle.getY()-this.getY())*(circle.getY()-this.getY()));
		if(Math.abs(this.getRadius() - circle.getRadius())<=distance)	return true;
		else return false;		
	}
	public boolean overlaps(Circle2D circle)
	{
		double distance=Math.sqrt((circle.getX()-this.getX())*(circle.getX()-this.getX())+(circle.getY()-this.getY())*(circle.getY()-this.getY()));
		if((Math.abs(this.getRadius() - circle.getRadius())<=distance)&&(distance<=this.getRadius()+circle.getRadius()))	return true;
		else return false;
		
	}
	public String toString()
	{
		return "\nArea = "+this.getArea()
				+"\nPerimeter = "+this.getPerimeter()
				+"\n";
	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
}
