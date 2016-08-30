package lei;

public class NewUser 
{
	
	private int UserType;
	private String UserID;
	private String UserName;
	private String UserPassword;
	private String Sex;
	private String Spec;
	
	public NewUser()
	{this("",0,"23333","13333","男","信息");}
	
	public NewUser (String UserID,int UserType)
	{
		this(UserID,UserType,UserID,UserID,"男","信息");
	}
	public NewUser (String UserID,int UserType,String UserName,String UserPassword,String Sex,String Spec)
	{
		this.setName(UserName);
		this.setUserID(UserID);
		this.setUserType(UserType);		
		this.setUserPassword(UserPassword);
		this.setSex(Sex);
		this.setSpec(Spec);
	}
	public String toDescription()
	{
		return  "\nUserID="+this.getUserID()+
				"\nUserType="+this.getUserType()+
				"\nUserName="+this.getName()+
				"\nSex="+this.getSex()+
				"\nSpec="+this.getSpec()+
				"\n";
	}
	public String toString()
	{
		return  this.getUserID()+this.getName();
		
	}
	
	/**
	 * @return the UserName
	 */
	public String getName() {
		return UserName;
	}
	/**
	 * @param UserName the UserName to set
	 */
	public void setName(String UserName) {
		this.UserName = UserName;
	}
	/**
	 * @return the userType
	 */
	public int getUserType() {
		return UserType;
	}
	
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(int userType) {
		UserType = userType;
	}
	/**
	 * @return the userNumber
	 */
	public String getUserID() {
		return UserID;
	}
	/**
	 * @param userNumber the userNumber to set
	 */
	public void setUserID(String userNumber) {
		UserID = userNumber;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return UserPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return Sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		Sex = sex;
	}
	/**
	 * @return the spec
	 */
	public String getSpec() {
		return Spec;
	}
	/**
	 * @param spec the spec to set
	 */
	public void setSpec(String spec) {
		Spec = spec;
	}
	
	
}
