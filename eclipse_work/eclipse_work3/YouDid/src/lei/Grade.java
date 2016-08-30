package lei;

public class Grade 
{
	private String UserID;
	private String CourseID;
	private int Grade;
	
	public Grade(){}
	public Grade(String UserID,String CourseID)
	{
		this.UserID=UserID;
		this.CourseID=CourseID;
		this.Grade=100;
				
				
	}
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		UserID = userID;
	}
	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return CourseID;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return Grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		Grade = grade;
	}
	
	
}
