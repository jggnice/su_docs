package dbsql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import lei.NewUser;
//import org.vo.*;
/*
 * 
 *  UserID		char(10)		not null primary key,
	UserType	int				not null default 0,
	UserName	char(10)		not null,
	UserPassword char(15)		not null,
	Sex			char(2)			not null default '男',
	Spec		char(20)		not null,
 * 
 * 
 * 
 */
/**
// * @author 旺
 *
 */
public class DBsql1 {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	public DBsql1() {}	
	
	/**
	 *  SQL : connection with Server
	 */
	public Connection getConn() 
	{
		try {
			if (this.conn == null || this.conn.isClosed()) 
			{
				DBConn mc = new DBConn();			// 创建数据库连接类
				this.conn = mc.getConn();					// 获取Connection对象
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 *  SQL : Add a User 
	 *  
	 *  in: NewUser 
	 *  out : NewUser 
	 */
	
	public boolean addNewUser(NewUser reader) 
	{
		if("".equals(reader.getUserID().trim())||"".equals(reader.getName().trim()))
		{return false;}
		
		String sql 
		= "insert into Students (UserID,UserType,UserName,UserPassword,Sex,Spec) "
		+ "values(?,?,?,?,?,?)";
		try {
			psmt = this.getConn().prepareStatement(sql);	// 获取PreparedStatement对象
			/*Prepare a User to Add in*/
			psmt.setString(1, reader.getUserID());
			   psmt.setInt(2, reader.getUserType());
			psmt.setString(3, reader.getName());
			psmt.setString(4, reader.getUserID());
			psmt.setString(5, reader.getSex());			
			psmt.setString(6, reader.getSpec());			
			// EXECUTE SQL EXPRESSION
			psmt.execute();									
			
		} catch (Exception e) 
		{
			return false;
		} 
		finally {
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
		return true;
	}
	public void tablelist(DefaultTableModel dtm,String UserID,String UserName,String Spec)throws Exception
	{
		StringBuffer sb=new StringBuffer("select UserID,UserName,Spec from Students where UserID is NOT NULL ");
		if(!("".equals(UserID.trim()))){
			sb.append(" and UserID like '%"+UserID+"%'");
		}
		if(!("".equals(UserName.trim()))){
			sb.append(" and UserName like '%"+UserName+"%'");
		}
		if(!("".equals(Spec.trim()))){
			sb.append(" and Spec like '%"+Spec+"%'");
		}
		psmt = this.getConn().prepareStatement(sb.toString());
		//EXECUTE
	  rs =  psmt.executeQuery();
	  while (rs.next()) 
		{
			Vector<String> v = new Vector<String>();
			v.add(rs.getString("UserID"));
			v.add(rs.getString("UserName"));
			v.add(rs.getString("Spec"));
			dtm.addRow(v);
		}
	  
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
	

	/**
	 *  SQL : list Users between startline and endline 
	 *  
	 *  in: NewUser 
	 *  out : list of  NewUser 
	 */
		public List<NewUser> showStudent(int amount,  int startline) throws SQLException {
		
		// 分页查询读者			
		String sql 
		= "select top("+amount+") * from Students where UserID "
		+ "not in(select top("+startline+"-1) UserID from Students)";		
		// 创建一个ArrayList容器，将从数据库中查询的读者信息存放在容器中
		List<NewUser> readerList = new ArrayList<NewUser>();		
		try {
			psmt = this.getConn().prepareStatement(sql);
			//EXECUTE
			rs = psmt.executeQuery();
			//GET RESULT rs
			while (rs.next()) 
			{

				NewUser reader = new NewUser();
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

	/**
	 *  SQL : total number of users
	 */
	public int getTotal() throws SQLException {
		
		String sql
		= "select count(*) from Students";
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
	 *  SQL : Find user with UserID
	 */
	public  NewUser selectNewUser(String NewUserID) 
	{
		ResultSet rs = null;
		if(NewUserID.length() <= 2)
			return null;			
		else {
			String sql
			= "select * from Students where UserID = ? ";			
			
			//non parameter
			NewUser reader = new NewUser();			
			try {				
				psmt = this.getConn().prepareStatement(sql);
				psmt.setString(1,NewUserID);
				rs = psmt.executeQuery();
				if(rs.next()==false){	//System.out.println(" find null");
					return null;
				}
				
				else
			{
			//EVERY NEXT MEANS run to NEXT ROW
			//NOW WE AT FIRST ROW
			reader.setUserID(rs.getString("UserID"));			
			reader.setUserType(rs.getInt("UserType"));								
			reader.setName(rs.getString("UserName"));			
			reader.setUserPassword(rs.getString("UserPassword"));					
			reader.setSex(rs.getString("Sex"));
			reader.setSpec(rs.getString("Spec"));
			return reader;
			}				
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
			return null;
		}
	}

	/**
	 *  SQL : Update a user according to UserID 
	 *  
	 *  in: NewUser 
	 *  out : true or false 
	 */
	public boolean updateSaveNewUser(NewUser reader) 
	{
		
		String sql
		= "update Students"
		+ " set UserType = ? , UserName = ? , UserPassword = ? , Sex = ? , Spec = ? "
		+ " where UserID = ? ";
		try {
			psmt = this.getConn().prepareStatement(sql);	// 获取PreparedStatement对象			
			
			//FILL STATEMENT TO EXECUTE
		
			   psmt.setInt(1, reader.getUserType());
			psmt.setString(2, reader.getName());
			psmt.setString(3, reader.getUserPassword());
			psmt.setString(4, reader.getSex());			
			psmt.setString(5, reader.getSpec());
			psmt.setString(6, reader.getUserID());
			/*System.out.println(reader.getBorn());
			psmt.setTimestamp(4, new Timestamp(reader.getBorn().getTime()));			
			psmt.setInt(6, reader.getNum());
			psmt.setBytes(7, reader.getPhoto());*/
			
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
	 *  SQL : delete a user according to UserID 
	 *  out : true or false    
	 */
	public boolean deleteNewUser(String UserID) throws Exception {
		String sql = "delete from Students where UserID= ? ";		
		 {
			try {
				psmt = this.getConn().prepareStatement(sql);
				psmt.setString(1,UserID);
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
}