package ex11_2;

public class Person 
{	
	private String Name;
	private String Address;
	private String Phone;
	private String Email;
	public Person()	{}
	public Person(String name, String address,String phone,String email)
	{
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
		this.setEmail(email);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return Phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	public String toString()
	{
		return "Person " + this.getName();
	}
}
