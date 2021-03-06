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
 * 这是个非常简单的SQLite的Java程序, 程序中创建数据库、创建表、然后插入数据， 最后读出数据显示出来
 * 
 * @author zieckey (http://zieckey.cublog.cn)
 */
public class TestSQLite
{
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	public static void creatDict()
	{
		/*** Connection对象 **/
		Connection conn = null;
		/*** 驱动名称 **/
		String jdbcName = "org.sqlite.JDBC";
		/*** 数据库地址 **/
		String dbUrl = "jdbc:sqlite:Dict.db";
		try
		{
			/*** 获取连接类 **/
			Class.forName(jdbcName);
			/** 加载并注册SQLServer2012的JDBC驱动 */
			conn = DriverManager.getConnection(dbUrl);
			/** 编写连接字符串，创建并获取连接 */
			Statement stat = conn.createStatement();
			rs = stat
					.executeQuery("select count(*) from sqlite_master where type='table' and name='tableAq'");
			if (rs.getInt(1) == 1)
			{
				stat.execute("Drop table tableA");
			}
			stat.executeUpdate("create table tableA(word varchar(25) not null,data varchar(250) not null );");// 创建一个表，两列

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