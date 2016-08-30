package dbsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import lei.Course;

/**
 * create table TeacherCourse UserID varchar(10) not null , CourseID varchar(10)
 * not null ,
 */
public class DBsqlTeachCourse {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public DBsqlTeachCourse() {
	}

	/**
	 * SQL : connection with Server
	 */
	public Connection getConn() {
		try {
			if (this.conn == null || this.conn.isClosed()) {
				DBConn mc = new DBConn(); // 创建数据库连接类
				this.conn = mc.getConn(); // 获取Connection对象
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * select CourseName from TeacherCourse,Course where Course.CourseID =
	 * TeacherCourse.CourseID and UserID = 'Wang'
	 */

	public void showMyCourse(DefaultTableModel dtm, String UserID)
			throws SQLException {
		try {
			String sql = " select CourseID from TeacherCourse where " 
					+" UserID = ? ";
			psmt = this.getConn().prepareStatement(sql);
			/* Prepare a User to Add in */
			psmt.setString(1, UserID);
			rs = psmt.executeQuery();			
			// GET RESULT rs			
			while (rs.next()) 
			{
				Course tep;
				String str = rs.getString("CourseID");
				DBsqlCourse sql2 = new DBsqlCourse();
				tep =  sql2.selectCourse(str);				
				Vector<String> v = new Vector<String>();
				v.add(tep.getCourseID());
				v.add(tep.getCourseName());
				v.add(""+tep.getCredit());
				v.add(tep.getDescription());				
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close(); // 关闭ResultSet对象
					rs = null;
				}
				if (psmt != null) {
					psmt.close(); // 关闭PreparedStatement对象
					psmt = null;
				}
				if (conn != null) { // 关闭Connection对象
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}