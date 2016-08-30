package dbsql;


import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import lei.Grade;

/**
 * create table Grade
 
	(	UserID		varchar(10)		not null ,
		CourseID	varchar(10)		not null ,
		Gmark		int				null,
	)
*/
public class DBsqlAttendCourse {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	public DBsqlAttendCourse() {}	
	
	/**
	 *  SQL : connection with Server
	 */
	public Connection getConn() 
	{
		try {
			if (this.conn == null || this.conn.isClosed()) {
				DBConn mc = new DBConn();					// �������ݿ�������
				this.conn = mc.getConn();					// ��ȡConnection����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 *addAttendCourse(String UserID,String courseID) 
	 */
	
	public boolean addAttendCourse(String UserID,String courseID) 
	{
		String sql 
		= "insert into Grade (UserID,CourseID) "
		+ "values(?,?)";
		try {
			psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����
			/*Prepare a User to Add in*/
			psmt.setString(1, UserID);			
			psmt.setString(2, courseID);					
			// EXECUTE SQL EXPRESSION
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(psmt != null) {
					psmt.close();							// �ر�PreparedStatement����
					psmt = null;
				}
				if(conn != null) {
					conn.close();							// �ر�Connection����
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;	
			}
		}
		return true;
											
	}
	public void showAttendList2(DefaultTableModel dtm,String UserID) throws SQLException {
		
		/*
		select CourseName,Gmark from Grade,Course where 
	Course.CourseID = Grade.CourseID and
	UserID = '1507402068'
		*/			
	String sql 
	= "select CourseName,Gmark from Grade,Course where "	
	+ "Course.CourseID = Grade.CourseID and "
	+ "UserID = ? ";
	try {
		psmt = this.getConn().prepareStatement(sql);
		/*Prepare a User to Add in*/
		psmt.setString(1, UserID);
		rs = psmt.executeQuery();
		//GET RESULT rs
		while (rs.next()) 
		{
			Vector<String> v = new Vector<String>();
			v.add(rs.getString("CourseName"));
			v.add(""+rs.getInt("Gmark"));
			dtm.addRow(v);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) {
				rs.close();								// �ر�ResultSet����
				rs = null;
			}
			if(psmt != null) {
				psmt.close();							// �ر�PreparedStatement����
				psmt = null;
			}
			if(conn != null) {							// �ر�Connection����
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	/**
	 *  SQL : list Users between startline and endline 
	 *  
	 *  in: NewUser 
	 *  out : list of  NewUser 
	 */
		public List<Grade> showAttendList(int amount,  int startline,String UserID) throws SQLException {
		
			/*
			select top(1) * from Grade where UserID= '130013'
			and CourseID not in
			(select top(1) CourseID from Grade where UserID= '130013')
			*/			
		String sql 
		= "select top("+amount+") * from Grade where UserID = ? "
		+ " and CourseID not in"
		+ "(select top("+startline+"-1) CourseID from Grade where UserID = ? "
		+ " )";
		
		List<Grade> readerList = new ArrayList<Grade>();		
		try {
			psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����
			/*Prepare a User to Add in*/
			psmt.setString(1, UserID);			
			psmt.setString(2, UserID);	
			//EXECUTE
			rs = psmt.executeQuery();
			//GET RESULT rs
			while (rs.next()) 
			{
				//PUT INTO ArrayList
				//NOW FIRST LINE
				Grade reader = new Grade();
				//PUT INTO USER
				reader.setUserID(rs.getString("UserID"));
				reader.setCourseID(rs.getString("CourseID"));
				reader.setGrade(rs.getInt("Gmark"));
				
				//PUT INTO LIST
				readerList.add(reader);						
			}
			//RETURN LIST
			return readerList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();								// �ر�ResultSet����
					rs = null;
				}
				if(psmt != null) {
					psmt.close();							// �ر�PreparedStatement����
					psmt = null;
				}
				if(conn != null) {							// �ر�Connection����
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
		public void showMyStudentsList(DefaultTableModel dtm,String CourseID) throws SQLException {
			
			String sql 
			="select Students.UserID,UserName,Gmark from Grade,Students where "			
			+" Grade.UserID = Students.UserID "
			+" and CourseID = ? ";
			
		try {
			psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����
			/*Prepare a User to Add in*/
			psmt.setString(1, CourseID);
			//EXECUTE
			rs = psmt.executeQuery();
			//GET RESULT rs
			while (rs.next()) 
			{
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("UserID"));
				v.add(rs.getString("UserName"));
				v.add(""+rs.getInt("Gmark"));
				dtm.addRow(v);					
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();								// �ر�ResultSet����
					rs = null;
				}
				if(psmt != null) {
					psmt.close();							// �ر�PreparedStatement����
					psmt = null;
				}
				if(conn != null) {							// �ر�Connection����
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *  SQL : total number of users
	 */
	
	public  int getTotal(String userID) throws SQLException {
		
		String sql
		= "select count(*) from Grade "
		+ "where UserID = ? " ;
		
		ResultSet rs = null;
		int a = 0;
		try {
			psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����			
			
			//FILL STATEMENT TO EXECUTE
			psmt.setString(1, userID);				
			// NOW EXECUTE
			rs = psmt.executeQuery();
			if(rs.next()) {
				
				a = rs.getInt(1);
				
				
			}
		} catch (Exception e) {
			e.toString();
		}
		
 		return a;											// ���ض��ߵļ�¼��
	}	
public  int getMyStudensTotal(String CourseID) throws SQLException {
		
		String sql
		= "select count(*) from Grade "
		+ "where CourseID = ? " ;
		
		ResultSet rs = null;
		int a = 0;
		try {
			psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����			
			
			//FILL STATEMENT TO EXECUTE
			psmt.setString(1, CourseID);				
			// NOW EXECUTE
			rs = psmt.executeQuery();
			if(rs.next()) {
				
				a = rs.getInt(1);
				
				
			}
		} catch (Exception e) {
			e.toString();
		}
		
 		return a;											// ���ض��ߵļ�¼��
	}	
	
	/**
	 *  SQL : Update a user according to UserID 
	 *  
	 *  in: NewUser 
	 *  out : true or false 
	 */
	public boolean updateGrade(String userID,String CourseID,int grade) 
	{
		
		String sql
		= "update Grade"
		+ " set Gmark = ? "
		+ "where UserID = ? "
		+ "and CourseID = ? ";
		
		try {
			psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����
			psmt.setInt(1, grade);
			psmt.setString(2, userID);
			psmt.setString(3, CourseID);
			// NOW EXECUTE
			psmt.execute();	
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				psmt.close();								// �ر�PreparedStatement����
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();								// �ر�Connection����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;										// ���ض��߶���
	}

	/**
	 *  SQL : delete a user according to UserID 
	 *  out : true or false    
	 */
	public boolean deleteAttendCourse(String UserID,String CourseID) throws Exception {
		String sql
		= "delete from Grade "
		+ "where UserID = ? " 
		+ "and CourseID = ? ";
		
		 {
			try {
				psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����
				/*Prepare a User to Add in*/
				psmt.setString(1, UserID);			
				psmt.setString(2, CourseID);	
				//EXECUTE
				psmt.execute();
			
			} catch (Exception e) {
				e.printStackTrace();
				return false;
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
		return true; 
	}
	public boolean isAttendCourse(String UserID,String CourseID)
	{
		String sql
		= "select * from Grade "
		+ "where UserID = ? " 
		+ "and CourseID = ? ";
		 {
				try {
					psmt = this.getConn().prepareStatement(sql);	// ��ȡPreparedStatement����
					/*Prepare a User to Add in*/
					psmt.setString(1, UserID);			
					psmt.setString(2, CourseID);	
					//EXECUTE
					rs = psmt.executeQuery();
					if(rs.next()) 	
					{
						/*System.out.println("_TRUE");*/	return true ;
					}
					else		
					{
						/*System.out.println("_FALSE");*/	return false ;
					}
				
				} catch (Exception e) {
					e.printStackTrace();
					return false;
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
	}
}