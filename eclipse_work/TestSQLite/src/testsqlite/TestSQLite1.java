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
		/*** Connection���� **/
		Connection conn = null;
		/*** �������� **/
		String jdbcName = "org.sqlite.JDBC";
		/*** ���ݿ��ַ **/
		String dbUrl = "jdbc:sqlite:Dict.db";
		if(null == word)
			return;
		if(null == data)
			return;
		try
		{
			/*** ��ȡ������ **/
			Class.forName(jdbcName);
			/** ���ز�ע��SQLServer2012��JDBC���� */
			conn = DriverManager.getConnection(dbUrl);
			/** ��д�����ַ�������������ȡ���� */
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
			conn.close(); // �������ݿ������

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}