package testsqlite;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import sscanf.util.Sscanf;

/**
 * ���Ǹ��ǳ��򵥵�SQLite��Java����, �����д������ݿ⡢��������Ȼ��������ݣ� ������������ʾ����
 * 
 * @author zieckey (http://zieckey.cublog.cn)
 */
public class TestSQLite
{
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	public static void creatDict()
	{
		/*** Connection���� **/
		Connection conn = null;
		/*** �������� **/
		String jdbcName = "org.sqlite.JDBC";
		/*** ���ݿ��ַ **/
		String dbUrl = "jdbc:sqlite:Dict.db";
		try
		{
			/*** ��ȡ������ **/
			Class.forName(jdbcName);
			/** ���ز�ע��SQLServer2012��JDBC���� */
			conn = DriverManager.getConnection(dbUrl);
			/** ��д�����ַ�������������ȡ���� */
			Statement stat = conn.createStatement();
			rs = stat
					.executeQuery("select count(*) from sqlite_master where type='table' and name='tableAq'");
			if (rs.getInt(1) == 1)
			{
				stat.execute("Drop table tableA");
			}
			stat.executeUpdate("create table tableA(word varchar(25) not null,data varchar(250) not null );");// ����һ����������

			String sql = "insert into tableA " + "values(?,?)";
			File fp = new File("dic.txt");
			Scanner in = new Scanner(fp);
			while (in.hasNext())
			{
				String line = in.nextLine();
				Object variables[] = Sscanf.scan(line, "%s %s", "1", "2");
				String word = (String) variables[0];
				String data = (String) variables[1];
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, word);
				psmt.setString(2, data);
				psmt.execute();
			}
			in.close();
			conn.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}