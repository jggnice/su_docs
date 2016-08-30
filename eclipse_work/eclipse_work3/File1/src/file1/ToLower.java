package file1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ToLower
{
	public static void remainletter(String[] args) throws IOException
	{
		File f1 = new File(args[0]);
		File f2 = new File(args[1]);
		File[] arg = {f1, f2};
		remainletter(arg);
	}
	public static void remainletter(File[] args) throws IOException
	{
		FileInputStream input = new FileInputStream(args[0]);
		FileOutputStream output = new FileOutputStream(args[1]);
		while (input.available() > 0)
		{
			int ch = input.read();
			if ((ch >= 97 && ch < 97 + 26))
			{
				output.write(ch);
			} else if ((ch >= 65 && ch < 65 + 26))
			{
				output.write(ch + 32);
			} else
			{
				output.write(' ');
			}

		}
		input.close();
		output.close();
	}
}