package dbsql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lei.NewUser;
//import org.vo.*;
/*
 * 
 *  UserID		char(10)		not null primary key,
	UserType	int				not null default 0,
	UserName	char(10)		not null,
	UserPassword char(15)		not null,
	Sex			char(2)			not null default 'ÄÐ',
	Spec		char(20)		not null,
 * 
 * 
 * 
 */
public class BDsqlQuery {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	public BDsqlQuery() {}	
	
	/**
	 *  SQL : connection with Server
	 */
	public Connection getConn() 
	{
		try {
			if (this.conn == null || this.conn.isClosed()) {
				DBConn mc = new DBConn();	
				this.conn = mc.getConn();			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 *  SQL : list Users between startline and endline 
	 *  
	 *  in: NewUser 
	 *  out : list of  NewUser 
	 */
		public List<NewUser> showStudent(int amount,  int startline) throws SQLException {
		
	
		String sql 
		= "select top("+amount+") * from Students where UserID "
		+ "not in(select top("+startline+"-1) UserID from Students)";		

		List<NewUser> readerList = new ArrayList<NewUser>();		
		try {
			psmt = this.getConn().prepareStatement(sql);
			//EXECUTE
			rs = psmt.executeQuery();
			//GET RESULT rs
			while (rs.next()) 
			{
				//PUT INTO ArrayList
				//NOW FIRST LINE
				NewUser reader = new NewUser();
				//PUT INTO USER
				reader.setUserID(rs.getString("UserID"));
				reader.setUserType(rs.getInt("UserType"));
				reader.setName(rs.getString("UserName"));
				reader.setUserPassword(rs.getString("UserPassword"));
				reader.setSex(rs.getString("Sex"));				
				reader.setSpec(rs.getString("Spec"));	
				readerList.add(reader);						
			}
			//RETURN LIST
			return readerList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();							
					rs = null;
				}
				if(psmt != null) {
					psmt.close();						
					psmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}