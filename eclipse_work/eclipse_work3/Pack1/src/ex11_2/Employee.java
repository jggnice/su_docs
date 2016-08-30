package ex11_2;

public class Employee extends Person 
{
	private String Office;
	private double Salary;
	private MyDate DateEmployeed;
	public Employee(){}
	
	public Employee(String name, String address,String phone,String email,String office,double salary,MyDate dateEmployeed)
	{
		super(name,address,phone,email);
		this.setOffice(office);
		this.setSalary(salary);
		this.setDateEmployeed(dateEmployeed);
	}
	/**
	 * @return the office
	 */
	public String getOffice() {
		return Office;
	}
	/**
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		Office = office;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return Salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	/**
	 * @return the dateEmployeed
	 */
	public MyDate getDateEmployeed() {
		return DateEmployeed;
	}
	/**
	 * @param dateEmployeed the dateEmployeed to set
	 */
	public void setDateEmployeed(MyDate dateEmployeed) {
		DateEmployeed = dateEmployeed;
	}
	public String toString()
	{
		return "Employee " + this.getName();
	}
}
