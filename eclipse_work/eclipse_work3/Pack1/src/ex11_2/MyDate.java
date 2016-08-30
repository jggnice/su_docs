package ex11_2;

public class MyDate 
{
	private int year;
	private int month;
	private int day;
	public MyDate()
	{
		this(2015,1,1);
	}
	public MyDate(int year,int month,int day)
	{
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
}
