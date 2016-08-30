package osmemory;

import java.util.ArrayList;

public class TestPart
{
	static int count = 0;
	static ArrayList<Part> partlist = new ArrayList<Part>();
	public static void link(Part p)
	{
		count++;
		Part p1 = new Part(false, 0, 0, count);
		partlist.add(p1);
		p.next = p1;

	}
	 public static void main(String[] args)
	 {
	
	 Part p1 = new Part(false, 0, 0, 100000000);
	 Part p2 = new Part(false, 0, 0, 100000000);
	 Part p3 = new Part(false, 0, 0, 100000000);
	
	 partlist.add(p1);
	 partlist.add(p2);
	 partlist.add(p3);
	
	 link(p1);
	 link(p2);
	 link(p3);
	 System.out.println(Job.currenttime);
	 for (int i = 0; i < partlist.size(); i++)
	 System.out.println(partlist.get(i).next.endtime + "," + partlist.size());
	 }
}
