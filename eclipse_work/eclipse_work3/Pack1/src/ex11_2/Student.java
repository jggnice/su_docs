package ex11_2;

public class Student extends Person
{
	private int classstatus;
	static final int 大一 = 1;
	static final int 大二 = 2;
	static final int 大三 = 3;
	static final int 大四 = 4;	
	public Student(){	}
	public Student(String name, String address,String phone,String email,int classstatus)
	{
		super(name,address,phone,email);
		this.setClassstatus(classstatus);
	}
	
	/**
	 * @return the classstatus
	 */
	public int getClassstatus() {
		return classstatus;
	}
	/**
	 * @param classstatus the classstatus to set
	 */
	public void setClassstatus(int classstatus) {
		this.classstatus = classstatus;
	}
	public String toString()
	{
		return "Student " + this.getName();
	}		
}
