package osmemory;

import java.util.Comparator;

public class Part
{
//	public Part(boolean status, Integer start, long memory)
//	{
//		super();
//		this.status = status;
//		this.start = start;
//		this.size = memory;
//	}
	public Part(boolean status, Integer start, long memory, int time)
	{
		super();
		this.status = status;
		this.start = start;
		this.size = memory;
		this.endtime = Job.currenttime + time;
	}
	Part next;
	Part pre;
	boolean status;
	Integer endtime;
	Integer start;
	long size;
}
class startComparator implements Comparator<Part>
{

	@Override
	public int compare(Part o1, Part o2)
	{
		return o1.start.compareTo(o2.start);
	}
}
class timeComparator implements Comparator<Part>
{

	@Override
	public int compare(Part o1, Part o2)
	{
		return o1.endtime.compareTo(o2.endtime);
	}
}