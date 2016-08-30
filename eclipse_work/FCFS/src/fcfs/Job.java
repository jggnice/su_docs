package fcfs;

public class Job implements Comparable<Job>
{
	static int currenttime;
	private Integer arrivingtime;
	private Integer runtime;
	private Integer alltime;
	
	public Job(int arrivingtime, int runtime)
	{
		super();
		this.arrivingtime = arrivingtime;
		this.runtime = runtime;
	}
	/**
	 * 
	 * @return the arrivingtime
	 */
	public Integer getArrivingtime()
	{
		return arrivingtime;
	}
	/**
	 * @param arrivingtime the arrivingtime to set
	 */
	public void setArrivingtime(int arrivingtime)
	{
		this.arrivingtime = arrivingtime;
	}
	/**
	 * @return the runtime
	 */
	public Integer getRuntime()
	{
		return runtime;
	}
	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(int runtime)
	{
		this.runtime = runtime;
	}
	/**
	 * @return the alltime
	 */
	public Integer getAlltime()
	{
		return alltime;
	}
	/**
	 * @param alltime the alltime to set
	 */
	public void setAlltime(int alltime)
	{
		this.alltime = alltime;
	}
	@Override
	public int compareTo(Job arg0)
	{
		return this.getArrivingtime().compareTo(arg0.getArrivingtime());
	}
}
