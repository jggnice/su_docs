package youdid;

import base64.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import tofile.ToFile;
import util.DBFrame;
import dbsql.DBConn;

public class App2
{
	public final static String filename = "/Program Files/test.dat";
	public final static String foldername = "/Program Files";
	public final static String filename1 = "/Program Files/test.mdf";
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		String[] Decode = new String[2];		
		Decode[0]=filename1;
		Decode[1]=filename;
		/**
		 * CHECK FOLDER
		 */
		ToFile.folder_exist(foldername);
		if(ToFile.file_exist(filename1))
		{
			String[] argv = new String[2];			
			DeCode.decode(Decode);			
			ToFile.readFile(filename, argv);			
			ToFile.file_delete(filename);
			
			String[] rsaen_arg = new String[2];
			rsaen_arg[0] = argv[0];
			not_file.TestRSAnoPadding.S2S2(rsaen_arg);
			argv[0] = rsaen_arg[1];				
			rsaen_arg[0] = argv[1];
			not_file.TestRSAnoPadding.S2S2(rsaen_arg);
			argv[1] = rsaen_arg[1];
			if(argv[0]!=null)
			{
				DBConn.setDbUserName(argv[0]);
				DBConn.setDBPassword(argv[1]);
				if(DBConn.tryConnection())
				{
					OurFrame f0 = new OurFrame();
					f0.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "连接数据库失败");
					file_not_found();
				}
				
			}
			else
			{
				file_not_found();
			}
		}
		else
		{
			file_not_found();
		}
		
	}
	public static void file_not_found()
	{
		DBFrame f1 = new DBFrame();
		f1.setVisible(true);
	}
}
