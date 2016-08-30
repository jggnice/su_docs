package ex11_2;

public class Faculty extends Employee 
{
	private String WorkTime;
	private String Rank;
	
	public Faculty(){}
	public Faculty(String name, String address,String phone,String email,String office,double salary,MyDate dateEmployeed,String workTime,String rank)
	{
		super(name,address,phone,email,office,salary,dateEmployeed);
		this.setWorkTime(workTime);
		this.setRank(rank);
	}
	/**
	 * @return the workTime
	 */
	public String getWorkTime() {
		return WorkTime;
	}
	/**
	 * @param workTime the workTime to set
	 */
	public void setWorkTime(String workTime) {
		WorkTime = workTime;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return Rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		Rank = rank;
	}
	public String toString()
	{
		return "Faculty " + this.getName();
	}
}
