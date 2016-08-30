package ex11_2;

public class Staff extends Employee 
{
	private String Title;
	public Staff(){}
	public Staff(String name, String address,String phone,String email,String office,double salary,MyDate dateEmployeed,String title)
	{
		super(name,address,phone,email,office,salary,dateEmployeed);
		this.setTitle(title);
	}	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}
	public String toString()
	{
		return "Staff " + this.getName();
	}
}
