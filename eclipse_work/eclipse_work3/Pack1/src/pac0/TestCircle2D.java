package pac0;

public class TestCircle2D 
{
	public static void main(String[] args)
	{
		Circle2D c1 = new Circle2D(2,2,5.5);
		System.out.println(
				"For circle c1:"+
				c1.toString()+
				"\n contains point(3,3) ? "+
				c1.contains(3, 3)+
				"\n contains Circle2D(4,5,10.5) ? "+
				c1.contains(new Circle2D(4,5,10.5))+
				"\n overlaps Circle2D(3,5,2.3) ? "+
				c1.overlaps(new Circle2D(3,5,2.3)));
	}
}
