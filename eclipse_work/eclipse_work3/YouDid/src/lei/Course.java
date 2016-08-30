package lei;

public class Course 
{
	public Course(){}
	
	public Course(String courseID,String courseName,int credit,String teacher,String Daytime,String description)
	{
		this.CourseID=courseID;
		this.CourseName=courseName;
		this.Credit=credit;
		this.Teacher=teacher;
		
		this.Daytime=Daytime;
		this.Description = description;
	}
	public String toString()
	{
		return		this.CourseName
				+"\n"+this.Teacher
				+"\n"+this.Description;
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return CourseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return Credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		Credit = credit;
	}
	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return Teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	/**
	 * @return the weekday
	 */
	public int[][] getWeekday() {
		String timeString =  this.getDaytime();
		int[][] Weekday = new int[timeString.length()/2][2];
		for(int ii = 0; ii < timeString.length(); ii++)
		{
			Weekday[ii/2][ii%2] =  timeString.charAt(ii) - '0';
		}
		return Weekday;
	}
	
	
	/**
	 * @return the daytime
	 */
	public String getDaytime() {
		return Daytime;
	}
	/**
	 * @param daytime the daytime to set
	 */
	public void setDaytime(String daytime) {
		Daytime = daytime;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	private String CourseID;
	private String CourseName;
	private int Credit;
	private String Teacher;
	private String Daytime;
	private String Description;

}
