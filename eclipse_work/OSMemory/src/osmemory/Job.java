package osmemory;

import java.util.Comparator;

public class Job
{
	static int currenttime = 0;
	Integer arrive;
	Integer time;
	Integer memory;
	public Job(Integer arrive, Integer time, Integer memory)
	{
		super();
		this.arrive = arrive;
		this.time = time;
		this.memory = memory;
	}
}
//class timeComparator implements Comparator<Job>
//{
//
//	@Override
//	public int compare(Job o1, Job o2)
//	{
//		return o1.time.compareTo(o2.time);		
//	}
//
//}
class memComparator implements Comparator<Job>
{

	@Override
	public int compare(Job o1, Job o2)
	{
		return o1.memory.compareTo(o2.memory);
	}

}