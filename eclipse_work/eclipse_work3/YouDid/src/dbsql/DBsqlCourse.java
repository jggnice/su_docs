package dbsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lei.Course;

public class DBsqlCourse {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs ;
	public DBsqlCourse() {}	
	
	/**
	 *  SQL : connection with Server
	 */
	public Connection getConn() 
	{
		try {
			if (this.conn == null || this.conn.isClosed()) {
				DBConn mc = new DBConn();					// 创建数据库连接类
				this.conn = mc.getConn();					// 获取Connection对象
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 *  create table Course
	(	CourseID	varchar(10)		not null primary key,	
		CourseName	varchar(20)			null,
		Credit			int				null default 4,
		Teacher		varchar(15)			null,
		Daytime		varchar(20)			null,
		Description1 varchar(50)		null
	)
	 */
	
	public boolean addCourse(Course reader) 
	{
		String sql 
		= "insert into Course (CourseID,CourseName,Credit,Teacher,Daytime,Description1) "
		+ "values(?,?,?,?,?,?)";
		try {
			psmt = this.getConn().prepareStatement(sql);	// 获取PreparedStatement对象
			//Prepare a User to Add in
			psmt.setString(1,reader.getCourseID() );
			psmt.setString(2,reader.getCourseName() );
			psmt.setInt(3,reader.getCredit());
			psmt.setString(4,reader.getTeacher() );
			psmt.setString(5,reader.getDaytime());			
			psmt.setString(6,reader.getDescription() );	
			// EXECUTE SQL EXPRESSION
			psmt.execute();									
			
		} catch (Exception e) {
			e.printStackTrace();
			return false ;
		} finally {
			try {
				if(psmt != null) {
					psmt.close();							// 关闭PreparedStatement对象
					psmt = null;
				}
				if(conn != null) {
					conn.close();							// 关闭Connection对象
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;										// 返回Course对象给Action
	}

	/**
	 *  SQL : list Courses between startline and endline 
	 *  
	 *  in: Course 
	 *  out : list of  Course 
	 */
		public List<Course> showCourseList(int amount,  int startline) throws SQLException {
		
		// 分页查询读者			
		String sql 
		= "select top("+amount+") * from Course where CourseID "
		+ "not in(select top("+startline+"-1) CourseID from Course)";		
		// 创建一个ArrayList容器，将从数据库中查询的读者信息存放在容器中
		List<Course> readerList = new ArrayList<Course>();		
		try {
			psmt = this.getConn().prepareStatement(sql);
			//EXECUTE
			rs = psmt.executeQuery();
			//GET RESULT rs
			while (rs.next()) 
			{
				//PUT INTO ArrayList
				//NOW FIRST LINE
				Course reader = new Course();
				//PUT INTO USER
				reader.setCourseID(rs.getString("CourseID"));			
				reader.setCourseName(rs.getString("CourseName"));								
				reader.setCredit(rs.getInt("Credit"));			
				reader.setTeacher(rs.getString("Teacher"));					
				reader.setDaytime(rs.getString("Daytime"));
				reader.setDescription(rs.getString("Description1"));
				//PUT USER INTO LIST				
				readerList.add(reader);
			}
			//RETURN LIST
			return readerList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();								// 关闭ResultSet对象
					rs = null;
				}
				if(psmt != null) {
					psmt.close();							// 关闭PreparedStatement对象
					psmt = null;
				}
				if(conn != null) {							// 关闭Connection对象
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 *  SQL : total number of users
	 */
	public int getTotal() throws SQLException {
		
		String sql
		= "select count(*) from Course";
		Statement stmt = null;
		ResultSet rs = null;
		int a = 0;
		try {
			stmt = this.getConn().createStatement();		// 获取Statement对象			
			rs = stmt.executeQuery(sql);					// EXECUTE SQL
			
			if(rs.next()) {
				
				a = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.toString();
		}
 		return a;											// 返回读者的记录数
	}	
	
	/**
	 *  SQL : Find user with CourseID
	 */
	public  Course selectCourse(String ID) throws SQLException
	{
		String sql
		= "use JWDB select * from Course "
		+ "where CourseID = ?";
		ResultSet rs = null;
		
		//non parameter
		Course reader = new Course();
		if(ID.length() <= 5)return null;			
			
			try {
				
				psmt = this.getConn().prepareStatement(sql);	// 获取PreparedStatement对象			
				
				//FILL STATEMENT TO EXECUTE
				psmt.setString(1, ID);				
				// NOW EXECUTE
				psmt.execute();					
				
				rs = psmt.executeQuery();						// EXECUTE SQL				
				
				if(rs.next()==false){	System.out.println(" find null");
					return null;
				}
				
				else
			{
			//EVERY NEXT MEANS run to NEXT ROW
			//NOW WE AT FIRST ROW
			reader.setCourseID(rs.getString("CourseID"));			
			reader.setCourseName(rs.getString("CourseName"));								
			reader.setCredit(rs.getInt("Credit"));			
			reader.setTeacher(rs.getString("Teacher"));					
			reader.setDaytime(rs.getString("Daytime"));
			reader.setDescription(rs.getString("Description1"));
			return reader;
			}				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	

	/**
	 *  SQL : Update a user according to CourseID 
	 *  
	 *  in: Course 
	 *  out : true or false 
	 */
/*	public boolean updateSaveCourse(Course reader) 
	{
		
		String sql
		= "update Course"
		+ " set CourseID=?,UserType=?,UserName=?,UserPassword=?,Sex=?,nSpec=?"
		+ " where CourseID="+ reader.getUserID();
		try {
			psmt = this.getConn().prepareStatement(sql);	// 获取PreparedStatement对象			
			
			//FILL STATEMENT TO EXECUTE
			psmt.setString(1, reader.getUserID());
			   psmt.setInt(2, reader.getUserType());
			psmt.setString(3, reader.getName());
			psmt.setString(4, reader.getUserID());
			psmt.setString(5, reader.getSex());			
			psmt.setString(6, reader.getSpec());
			System.out.println(reader.getBorn());
			psmt.setTimestamp(4, new Timestamp(reader.getBorn().getTime()));			
			psmt.setInt(6, reader.getNum());
			psmt.setBytes(7, reader.getPhoto());
			
			// NOW EXECUTE
			psmt.execute();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();								// 关闭PreparedStatement对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();								// 关闭Connection对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;										// 返回读者对象
	}

	/**
	 *  SQL : delete a user according to CourseID 
	 *  out : true or false    
	 */
	public boolean deleteCourse(String CourseID) throws Exception 
	{
		String sql = "delete from Course where CourseID= ?";		
		 {
			try {
				psmt = this.getConn().prepareStatement(sql);
				psmt.execute();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false; 
	}
	
	
	/**
	  create table Students
	(	UserID		varchar(10)		not null primary key,
		UserType	int				null default 0,
		UserName	varchar(10)		null,
		UserPassword varchar(15)	null,
		Sex			char(2)			null default '男',
		Spec		varchar(20)		null default '信息',
	)


	create table Course
	(	CourseID	varchar(10)		not null primary key,	
		CourseName	varchar(20)			null,
		Credit			int				null default 4,
		Teacher		varchar(15)			null,
		Daytime		varchar(20)			null,
		Description1 varchar(50)		null
	)


	create table Grade
	(	UserID		varchar(10)		not null ,
		CourseID	varchar(10)		not null ,
		Gmark		int				null,
	)*/
}

