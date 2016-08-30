package to_file;

import java.io.FileNotFoundException;

public class TestFile {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * File("/d"); 表示根目录下 File("d"); 表示当前目录下
		 */
		// create_folder("/d1/d2/d3/d4/test.txt");
		FFrame f1 = new FFrame();
		f1.setVisible(true);
		/*
		 * File file = new File("/d"); // 如果文件夹不存在则创建 if (!file.exists() &&
		 * !file.isDirectory()) { // System.out.println("//不存在"); file.mkdir();
		 * } else { System.out.println(file.getAbsolutePath()); //
		 * System.out.println("//目录存在"); }
		 */
		/*java.io.File file1 = new java.io.File("d1/d2/d3/d4/test.txt");

		java.io.PrintWriter out = new java.io.PrintWriter(file1);
		out.println("tsddddddddet");
		out.close();
		System.out.println("haha");
		Scanner input = new Scanner(file1);
		while (input.hasNext()) {
			String t1 = input.next();
			System.out.println("file:" + t1);
		}
		input.close();*/
	}

}
/*
 * 1、判断文件是否存在，不存在创建文件 [java] view plaincopyprint? File file=new
 * File("C:\\Users\\QPING\\Desktop\\JavaScript\\2.htm"); if(!file.exists()) {
 * try { file.createNewFile(); } catch (IOException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } }
 * 
 * 
 * 2、判断文件夹是否存在，不存在创建文件夹 [java] view plaincopyprint? File file =new
 * File("C:\\Users\\QPING\\Desktop\\JavaScript"); //如果文件夹不存在则创建 if (!file
 * .exists() && !file .isDirectory()) { System.out.println("//不存在"); file
 * .mkdir(); } else { System.out.println("//目录存在"); }
 * 
 * 
 * 
 * 
 * 创建文件和目录的关键技术点如下： [java] view plaincopy <pre name="code" class="java">
 * 1、File类的createNewFile根据抽象路径创建一个新的空文件，当抽象路径制定的文件存在时，创建失败
 * 2、File类的mkdir方法根据抽象路径创建目录 3、File类的mkdirs方法根据抽象路径创建目录，包括创建必需但不存在的父目录
 * 4、File类的createTempFile方法创建临时文件
 * ，可以制定临时文件的文件名前缀、后缀及文件所在的目录，如果不指定目录，则存放在系统的临时文件夹下。
 * 5、除mkdirs方法外，以上方法在创建文件和目录时，必须保证目标文件不存在，而且父目录存在，否则会创建失败
 * 
 * 实例演示
 * 
 * [java] view plaincopy package book.io;
 * 
 * import java.io.File; import java.io.IOException;
 * 
 * public class CreateFileUtil {
 * 
 * public static boolean createFile(String destFileName) { File file = new
 * File(destFileName); if(file.exists()) { System.out.println("创建单个文件" +
 * destFileName + "失败，目标文件已存在！"); return false; } if
 * (destFileName.endsWith(File.separator)) { System.out.println("创建单个文件" +
 * destFileName + "失败，目标文件不能为目录！"); return false; } //判断目标文件所在的目录是否存在
 * if(!file.getParentFile().exists()) { //如果目标文件所在的目录不存在，则创建父目录
 * System.out.println("目标文件所在目录不存在，准备创建它！"); if(!file.getParentFile().mkdirs())
 * { System.out.println("创建目标文件所在目录失败！"); return false; } } //创建目标文件 try { if
 * (file.createNewFile()) { System.out.println("创建单个文件" + destFileName + "成功！");
 * return true; } else { System.out.println("创建单个文件" + destFileName + "失败！");
 * return false; } } catch (IOException e) { e.printStackTrace();
 * System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage()); return
 * false; } }
 * 
 * 
 * public static boolean createDir(String destDirName) { File dir = new
 * File(destDirName); if (dir.exists()) { System.out.println("创建目录" +
 * destDirName + "失败，目标目录已经存在"); return false; } if
 * (!destDirName.endsWith(File.separator)) { destDirName = destDirName +
 * File.separator; } //创建目录 if (dir.mkdirs()) { System.out.println("创建目录" +
 * destDirName + "成功！"); return true; } else { System.out.println("创建目录" +
 * destDirName + "失败！"); return false; } }
 * 
 * 
 * public static String createTempFile(String prefix, String suffix, String
 * dirName) { File tempFile = null; if (dirName == null) { try{ //在默认文件夹下创建临时文件
 * tempFile = File.createTempFile(prefix, suffix); //返回临时文件的路径 return
 * tempFile.getCanonicalPath(); } catch (IOException e) { e.printStackTrace();
 * System.out.println("创建临时文件失败！" + e.getMessage()); return null; } } else {
 * File dir = new File(dirName); //如果临时文件所在目录不存在，首先创建 if (!dir.exists()) { if
 * (!CreateFileUtil.createDir(dirName)) {
 * System.out.println("创建临时文件失败，不能创建临时文件所在的目录！"); return null; } } try {
 * //在指定目录下创建临时文件 tempFile = File.createTempFile(prefix, suffix, dir); return
 * tempFile.getCanonicalPath(); } catch (IOException e) { e.printStackTrace();
 * System.out.println("创建临时文件失败！" + e.getMessage()); return null; } } }
 * 
 * public static void main(String[] args) { //创建目录 String dirName =
 * "D:/work/temp/temp0/temp1"; CreateFileUtil.createDir(dirName); //创建文件 String
 * fileName = dirName + "/temp2/tempFile.txt";
 * CreateFileUtil.createFile(fileName); //创建临时文件 String prefix = "temp"; String
 * suffix = ".txt"; for (int i = 0; i < 10; i++) { System.out.println("创建了临时文件："
 * + CreateFileUtil.createTempFile(prefix, suffix, dirName)); } //在默认目录下创建临时文件
 * for (int i = 0; i < 10; i++) { System.out.println("在默认目录下创建了临时文件：" +
 * CreateFileUtil.createTempFile(prefix, suffix, null)); } }
 * 
 * } 输出结果：
 * 
 * 
 * 创建目录D:/work/temp/temp0/temp1成功！ 目标文件所在目录不存在，准备创建它！
 * 创建单个文件D:/work/temp/temp0/temp1/temp2/tempFile.txt成功！ 创建了临时文件：D:work emp emp0
 * emp1 emp5171.txt 创建了临时文件：D:work emp emp0 emp1 emp5172.txt 创建了临时文件：D:work emp
 * emp0 emp1 emp5173.txt 创建了临时文件：D:work emp emp0 emp1 emp5174.txt 创建了临时文件：D:work
 * emp emp0 emp1 emp5175.txt 创建了临时文件：D:work emp emp0 emp1 emp5176.txt
 * 创建了临时文件：D:work emp emp0 emp1 emp5177.txt 创建了临时文件：D:work emp emp0 emp1
 * emp5178.txt 创建了临时文件：D:work emp emp0 emp1 emp5179.txt 创建了临时文件：D:work emp emp0
 * emp1 emp5180.txt 在默认目录下创建了临时文件：C:Documents and SettingsAdministratorLocal
 * SettingsTemp emp5181.txt 在默认目录下创建了临时文件：C:Documents and
 * SettingsAdministratorLocal SettingsTemp emp5182.txt 在默认目录下创建了临时文件：C:Documents
 * and SettingsAdministratorLocal SettingsTemp emp5183.txt
 * 在默认目录下创建了临时文件：C:Documents and SettingsAdministratorLocal SettingsTemp
 * emp5184.txt 在默认目录下创建了临时文件：C:Documents and SettingsAdministratorLocal
 * SettingsTemp emp5185.txt 在默认目录下创建了临时文件：C:Documents and
 * SettingsAdministratorLocal SettingsTemp emp5186.txt 在默认目录下创建了临时文件：C:Documents
 * and SettingsAdministratorLocal SettingsTemp emp5187.txt
 * 在默认目录下创建了临时文件：C:Documents and SettingsAdministratorLocal SettingsTemp
 * emp5188.txt 在默认目录下创建了临时文件：C:Documents and SettingsAdministratorLocal
 * SettingsTemp emp5189.txt 在默认目录下创建了临时文件：C:Documents and
 * SettingsAdministratorLocal SettingsTemp emp5190.txt
 */