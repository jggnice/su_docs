package tofile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToFile {
	/**
	*
	*这个是做教务管理系统时
	*写入和读出登录名和密码的
	*
	*/
	public ToFile() {
		super();
	}

	public static boolean file_delete(String filename)
	{
		java.io.File file1 = new java.io.File(filename);		
		return file1.delete();
	}
	public static boolean folder_exist(String foldername) {
		/**
		 * 
		 */
		File file = new File(foldername);
		if (!file.exists() || !file.isDirectory()) {
			file.mkdir();
			//System.out.println(file.getAbsolutePath());
			return false;
		}
		return true;

	}

	public static boolean file_exist(String filename) {
		java.io.File file1 = new java.io.File(filename);
		if (file1.exists() && !file1.isDirectory()) {
			//System.out.println(file1.getAbsolutePath());
			return true;
		}
		return false;
	}

	public static void setFile(String filename, String[] args)
			throws FileNotFoundException {

		/**
		 * WRITE FILE
		 */
		//System.out.println("NOW WRITE FILE");
		java.io.File file1 = new java.io.File(filename);
		java.io.PrintWriter into = new java.io.PrintWriter(file1);
		for (int ii = 0; ii < args.length; ii++) {
			into.println(args[ii]);
		}
		into.close();

	}

	public static void readFile(String filename, String[] args)
			throws FileNotFoundException {
		//System.out.println("NOW READ FILE");
		java.io.File file1 = new java.io.File(filename);
		Scanner input;
		input = new Scanner(file1);
		for (int ii = 0; (input.hasNext()); ii++) {
			args[ii] = input.next();
		}
		input.close();

	}
}