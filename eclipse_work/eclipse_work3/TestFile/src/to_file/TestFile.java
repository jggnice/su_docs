package to_file;

import java.io.FileNotFoundException;

public class TestFile {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * File("/d"); ��ʾ��Ŀ¼�� File("d"); ��ʾ��ǰĿ¼��
		 */
		// create_folder("/d1/d2/d3/d4/test.txt");
		FFrame f1 = new FFrame();
		f1.setVisible(true);
		/*
		 * File file = new File("/d"); // ����ļ��в������򴴽� if (!file.exists() &&
		 * !file.isDirectory()) { // System.out.println("//������"); file.mkdir();
		 * } else { System.out.println(file.getAbsolutePath()); //
		 * System.out.println("//Ŀ¼����"); }
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
 * 1���ж��ļ��Ƿ���ڣ������ڴ����ļ� [java] view plaincopyprint? File file=new
 * File("C:\\Users\\QPING\\Desktop\\JavaScript\\2.htm"); if(!file.exists()) {
 * try { file.createNewFile(); } catch (IOException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } }
 * 
 * 
 * 2���ж��ļ����Ƿ���ڣ������ڴ����ļ��� [java] view plaincopyprint? File file =new
 * File("C:\\Users\\QPING\\Desktop\\JavaScript"); //����ļ��в������򴴽� if (!file
 * .exists() && !file .isDirectory()) { System.out.println("//������"); file
 * .mkdir(); } else { System.out.println("//Ŀ¼����"); }
 * 
 * 
 * 
 * 
 * �����ļ���Ŀ¼�Ĺؼ����������£� [java] view plaincopy <pre name="code" class="java">
 * 1��File���createNewFile���ݳ���·������һ���µĿ��ļ���������·���ƶ����ļ�����ʱ������ʧ��
 * 2��File���mkdir�������ݳ���·������Ŀ¼ 3��File���mkdirs�������ݳ���·������Ŀ¼�������������赫�����ڵĸ�Ŀ¼
 * 4��File���createTempFile����������ʱ�ļ�
 * �������ƶ���ʱ�ļ����ļ���ǰ׺����׺���ļ����ڵ�Ŀ¼�������ָ��Ŀ¼��������ϵͳ����ʱ�ļ����¡�
 * 5����mkdirs�����⣬���Ϸ����ڴ����ļ���Ŀ¼ʱ�����뱣֤Ŀ���ļ������ڣ����Ҹ�Ŀ¼���ڣ�����ᴴ��ʧ��
 * 
 * ʵ����ʾ
 * 
 * [java] view plaincopy package book.io;
 * 
 * import java.io.File; import java.io.IOException;
 * 
 * public class CreateFileUtil {
 * 
 * public static boolean createFile(String destFileName) { File file = new
 * File(destFileName); if(file.exists()) { System.out.println("���������ļ�" +
 * destFileName + "ʧ�ܣ�Ŀ���ļ��Ѵ��ڣ�"); return false; } if
 * (destFileName.endsWith(File.separator)) { System.out.println("���������ļ�" +
 * destFileName + "ʧ�ܣ�Ŀ���ļ�����ΪĿ¼��"); return false; } //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
 * if(!file.getParentFile().exists()) { //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
 * System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������"); if(!file.getParentFile().mkdirs())
 * { System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�"); return false; } } //����Ŀ���ļ� try { if
 * (file.createNewFile()) { System.out.println("���������ļ�" + destFileName + "�ɹ���");
 * return true; } else { System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
 * return false; } } catch (IOException e) { e.printStackTrace();
 * System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�" + e.getMessage()); return
 * false; } }
 * 
 * 
 * public static boolean createDir(String destDirName) { File dir = new
 * File(destDirName); if (dir.exists()) { System.out.println("����Ŀ¼" +
 * destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѿ�����"); return false; } if
 * (!destDirName.endsWith(File.separator)) { destDirName = destDirName +
 * File.separator; } //����Ŀ¼ if (dir.mkdirs()) { System.out.println("����Ŀ¼" +
 * destDirName + "�ɹ���"); return true; } else { System.out.println("����Ŀ¼" +
 * destDirName + "ʧ�ܣ�"); return false; } }
 * 
 * 
 * public static String createTempFile(String prefix, String suffix, String
 * dirName) { File tempFile = null; if (dirName == null) { try{ //��Ĭ���ļ����´�����ʱ�ļ�
 * tempFile = File.createTempFile(prefix, suffix); //������ʱ�ļ���·�� return
 * tempFile.getCanonicalPath(); } catch (IOException e) { e.printStackTrace();
 * System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage()); return null; } } else {
 * File dir = new File(dirName); //�����ʱ�ļ�����Ŀ¼�����ڣ����ȴ��� if (!dir.exists()) { if
 * (!CreateFileUtil.createDir(dirName)) {
 * System.out.println("������ʱ�ļ�ʧ�ܣ����ܴ�����ʱ�ļ����ڵ�Ŀ¼��"); return null; } } try {
 * //��ָ��Ŀ¼�´�����ʱ�ļ� tempFile = File.createTempFile(prefix, suffix, dir); return
 * tempFile.getCanonicalPath(); } catch (IOException e) { e.printStackTrace();
 * System.out.println("������ʱ�ļ�ʧ�ܣ�" + e.getMessage()); return null; } } }
 * 
 * public static void main(String[] args) { //����Ŀ¼ String dirName =
 * "D:/work/temp/temp0/temp1"; CreateFileUtil.createDir(dirName); //�����ļ� String
 * fileName = dirName + "/temp2/tempFile.txt";
 * CreateFileUtil.createFile(fileName); //������ʱ�ļ� String prefix = "temp"; String
 * suffix = ".txt"; for (int i = 0; i < 10; i++) { System.out.println("��������ʱ�ļ���"
 * + CreateFileUtil.createTempFile(prefix, suffix, dirName)); } //��Ĭ��Ŀ¼�´�����ʱ�ļ�
 * for (int i = 0; i < 10; i++) { System.out.println("��Ĭ��Ŀ¼�´�������ʱ�ļ���" +
 * CreateFileUtil.createTempFile(prefix, suffix, null)); } }
 * 
 * } ��������
 * 
 * 
 * ����Ŀ¼D:/work/temp/temp0/temp1�ɹ��� Ŀ���ļ�����Ŀ¼�����ڣ�׼����������
 * ���������ļ�D:/work/temp/temp0/temp1/temp2/tempFile.txt�ɹ��� ��������ʱ�ļ���D:work emp emp0
 * emp1 emp5171.txt ��������ʱ�ļ���D:work emp emp0 emp1 emp5172.txt ��������ʱ�ļ���D:work emp
 * emp0 emp1 emp5173.txt ��������ʱ�ļ���D:work emp emp0 emp1 emp5174.txt ��������ʱ�ļ���D:work
 * emp emp0 emp1 emp5175.txt ��������ʱ�ļ���D:work emp emp0 emp1 emp5176.txt
 * ��������ʱ�ļ���D:work emp emp0 emp1 emp5177.txt ��������ʱ�ļ���D:work emp emp0 emp1
 * emp5178.txt ��������ʱ�ļ���D:work emp emp0 emp1 emp5179.txt ��������ʱ�ļ���D:work emp emp0
 * emp1 emp5180.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and SettingsAdministratorLocal
 * SettingsTemp emp5181.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and
 * SettingsAdministratorLocal SettingsTemp emp5182.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents
 * and SettingsAdministratorLocal SettingsTemp emp5183.txt
 * ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and SettingsAdministratorLocal SettingsTemp
 * emp5184.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and SettingsAdministratorLocal
 * SettingsTemp emp5185.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and
 * SettingsAdministratorLocal SettingsTemp emp5186.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents
 * and SettingsAdministratorLocal SettingsTemp emp5187.txt
 * ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and SettingsAdministratorLocal SettingsTemp
 * emp5188.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and SettingsAdministratorLocal
 * SettingsTemp emp5189.txt ��Ĭ��Ŀ¼�´�������ʱ�ļ���C:Documents and
 * SettingsAdministratorLocal SettingsTemp emp5190.txt
 */