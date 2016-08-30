package dbsql;
import java.sql.*;

public class DBConn {
	/*** Connection���� **/
	private Connection conn = null;
	/*** �û��� **/
	static String dbUserName = "sa";
	/*** ���� **/
	static String dbPassword = "";
	/*** �������� **/
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/*** ���ݿ��ַ **/
	private String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=JWDB";

	public DBConn() {
		this.setConn(this.getConnection()); // ��ȡ���ݿ�����
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
			/*** ��ȡ������ **/
			Class.forName(jdbcName);
			/** ���ز�ע��SQLServer2012��JDBC���� */
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			/** ��д�����ַ�������������ȡ���� */
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
