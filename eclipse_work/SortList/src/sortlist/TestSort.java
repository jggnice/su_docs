package sortlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import file1.ToLower;

public class TestSort
{

	static File file = null;
	static File tepfile = null;
	static int limit = 10;
	static int countallwords = 0;
	static int alldifferent = 0;
	static boolean onlyletter = false;

	public static boolean isOnlyletter()
	{
		return onlyletter;
	}

	public static void setOnlyletter(boolean onlyletter)
	{
		TestSort.onlyletter = onlyletter;
	}

	public static int getLimit()
	{
		return limit;
	}

	public static void setLimit(int limit)
	{
		TestSort.limit = limit;
	}

	public static void chooseFile() throws IOException
	{

		JFileChooser filechooser = new JFileChooser();
		// FileNameExtensionFilter filter = new
		// FileNameExtensionFilter("*.mp3/*.wav","mp3","wav");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt",
				"txt");
		filechooser.setFileFilter(filter);
		if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			file = (filechooser.getSelectedFile());
			File[] arg = {file, new File("本文件已经经过处理" + System.currentTimeMillis() + ".txt")};
			new Thread(new Runnable() {
				public void run()
				{
					try
					{
						ToLower.remainletter(arg);
					} catch (IOException exception)
					{

					}
				}
			}).start();
			// ToLower.remainletter(arg);
			tepfile = arg[1];
			if (onlyletter)
			{
				setFile(tepfile);
			}
		}
	}
	public static void switchFile() throws IOException
	{

		setFile(tepfile);

	}

	public static java.io.File getFile()
	{
		return file;
	}

	public static void setFile(File file)
	{
		if (file == null)
			return;
		File f = getFile();
		TestSort.file = file;
		tepfile = f;
	}

	static void startSortWords(DefaultTableModel dtm, java.io.File file1)
			throws FileNotFoundException
	{
		if (dtm == null || file1 == null)
		{
			JOptionPane.showMessageDialog(null, "请先选择");
			return;
		}
		Scanner in = new Scanner(file1);
		
		ArrayList<Person> listA = new ArrayList<Person>();
		for (; (in.hasNext());)
		{
			boolean flag = false;
			String buf[] = {in.next().trim(), ""};
			clearPreStr(buf);
			clearStr(buf);
			clearStr(buf);
			clearStr(buf);
			char str1[] = buf[1].toCharArray();
				

			if ((str1.length > 0) && (Character.isLetter(str1[0])))
			{
				countallwords++;
			}
			Person p1 = new Person(buf[1].toLowerCase(), 1);
			for (Person p : listA)
			{
				if (p.getName().equals((p1).getName()))
				{
					p.setOrder(1 + p.getOrder());
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				char str[] = p1.getName().toCharArray();
				if ((str.length > 0) && (Character.isLetter(str[0])))
					listA.add(p1);

			}

		}
		Collections.sort(listA);
		alldifferent = listA.size();
		in.close();
		ListIterator<Person> li = listA.listIterator();// 获得ListIterator对象
		for (li = listA.listIterator(); li.hasNext();)
		{// 将游标定位到列表结尾
			li.next();
		}
		int ii = 0;
		for (; (ii < limit) && li.hasPrevious();)
		{// 逆序输出列表中的元素
			Vector<String> v = new Vector<String>();
			Person pp = li.previous();
			v.add((ii + 1) + "");
			v.add(pp.getName());
			v.add("" + pp.getOrder());
			dtm.addRow(v);
			// System.out.print(pp + "\n");
			ii++;
		}
	}

	private static void clearPreStr(String[] buf)
	{
		if (buf[0] == null || buf[0].equals(""))
		{
			buf[1] = buf[0];
			return;
		}

		char ch = buf[0].charAt(0);
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
		{
			buf[1] = buf[0];
		} else
		{

			buf[1] = buf[0].substring(1, buf[0].length());

		}
		buf[0] = buf[1];
	}

	private static void clearStr(String[] buf)
	{
		if (buf[0] == null || buf[0].equals(""))
		{
			buf[1] = buf[0];
			return;
		}
		char ch = buf[0].charAt(buf[0].length() - 1);
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
		{
			buf[1] = buf[0];
		} else
		{

			buf[1] = buf[0].substring(0, buf[0].length() - 1);

		}
		buf[0] = buf[1];
	}
}
