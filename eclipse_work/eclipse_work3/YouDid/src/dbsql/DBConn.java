package dbsql;
import java.sql.*;

public class DBConn {
	/*** Connection对象 **/
	private Connection conn = null;
	/*** 用户名 **/
	static String dbUserName = "sa";
	/*** 密码 **/
	static String dbPassword = "";
	/*** 驱动名称 **/
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/*** 数据库地址 **/
	private String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=JWDB";

	public DBConn() {
		this.setConn(this.getConnection()); // 获取数据库连接
	}

	public static boolean tryConnection() {
		Connection conn1 = null;
		DBConn m = new DBConn();
		conn1 = m.getConn();
		if (conn1 == null)
			return false;
		else {
			try {
				conn1.close();
				conn1 = null;
			} catch (SQLException e) {
				return true;
			}
			return true;
		}

	}

	public Connection getConnection() {
		try {
			/*** 获取连接类 **/
			Class.forName(jdbcName);
			/** 加载并注册SQLServer2012的JDBC驱动 */
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			/** 编写连接字符串，创建并获取连接 */
		} catch (Exception e) {
			return null;
		}
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public static String getDbUserName() {
		return dbUserName;
	}

	public static void setDbUserName(String dbUserName) {
		DBConn.dbUserName = dbUserName;
	}

	public static String getDBPassword() {
		return dbPassword;
	}

	public static void setDBPassword(String dbPassword) {
		DBConn.dbPassword = dbPassword;
	}

	public String getJdbcName() {
		return jdbcName;
	}

	public void setJdbcName(String jdbcName) {
		this.jdbcName = jdbcName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

}
