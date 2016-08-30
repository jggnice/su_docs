package testsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class TestSQLite1
{
	private static PreparedStatement psmt = null;
	// private static Statement stat = null;
	private static ResultSet rs = null;
	public static void wordToTable(DefaultTableModel dtm, String word,
			String data)
	{
		/*** Connection对象 **/
		Connection conn = null;
		/*** 驱动名称 **/
		String jdbcName = "org.sqlite.JDBC";
		/*** 数据库地址 **/
		String dbUrl = "jdbc:sqlite:Dict.db";
		if(null == word)
			return;
		if(null == data)
			return;
		try
		{
			/*** 获取连接类 **/
			Class.forName(jdbcName);
			/** 加载并注册SQLServer2012的JDBC驱动 */
			conn = DriverManager.getConnection(dbUrl);
			/** 编写连接字符串，创建并获取连接 */
			// stat = conn.createStatement();
			StringBuffer sb = new StringBuffer(
					"select * from tableA where word is NOT NULL ");
			if (!("".equals(word.trim())))
			{
				sb.append(" and word like '%" + word + "%'");
			}
			if (!("".equals(data.trim())))
			{
				sb.append(" and data like '%" + data + "%'");
			}
			psmt = conn.prepareStatement(sb.toString());
			rs = psmt.executeQuery();
			int i = 0;
			while (rs.next())
			{
				// System.out.println(rs.getString("word")+"  "+rs.getString("data"));
				Vector<String> v = new Vector<String>();
				v.add("" + (++i));
				v.add(rs.getString("word"));
				v.add(rs.getString("data"));
				dtm.addRow(v);
			}
			rs.close();
			conn.close(); // 结束数据库的连接

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}