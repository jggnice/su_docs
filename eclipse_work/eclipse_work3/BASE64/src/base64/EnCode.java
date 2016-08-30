package base64;

import java.io.IOException;

public class EnCode {

	/*
	 * System.out.println("NOW WRITE FILE"); java.io.FileOutputStream file1 =
	 * new java.io.FileOutputStream("filename.txt");
	 *//**
	 * Write binary
	 */
	/*
	 * file1.write(65); file1.write(65); file1.write(65); file1.write('\n');
	 * file1.write('a'); file1.write(65); file1.write(65); file1.close();
	 *//**
	 * Read TXT
	 */
	/*
	 * System.out.println("NOW READ FILE"); java.io.File file11 = new
	 * java.io.File("filename.txt"); Scanner input; input = new Scanner(file11);
	 * for (; (input.hasNext());) { String t1 = input.next();
	 * System.out.println("file:" + t1); } input.close();
	 */

	public static int encode(String[] args) throws IOException {

		/**
		 * Read binary
		 */
		java.io.FileInputStream file_bin = new java.io.FileInputStream(args[0]);
		/**
		 * WRITE txt
		 */
		java.io.File file_txt = new java.io.File(args[1]);
		java.io.PrintWriter into = new java.io.PrintWriter(file_txt);
		// into.print("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/==");
		String stochar64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		char[] tochar = stochar64.toCharArray();
		int[] ch = new int[3];
		int[] ch4 = new int[4];
		int length1 = file_bin.available();
		// System.out.println("->" + file_bin.available());
		while ((length1) > 0) {
			if (length1 > 2) {
				ch[0] = file_bin.read();
				ch[1] = file_bin.read();
				ch[2] = file_bin.read();
				ch4[0] = (ch[0] >> 2);
				ch4[1] = (((ch[0] & 3) << 4) | (ch[1] >> 4));
				ch4[2] = (((ch[1] & 0xF) << 2) | (ch[2] >> 6));
				ch4[3] = (ch[2] & 63);
				into.print(tochar[ch4[0]]);
				into.print(tochar[ch4[1]]);
				into.print(tochar[ch4[2]]);
				into.print(tochar[ch4[3]]);
			}
			if (length1 == 2) {
				ch[0] = file_bin.read();
				ch[1] = file_bin.read();
				ch4[0] = (char) (ch[0] >> 2);
				ch4[1] = (char) (((ch[0] & 3) << 4) | (ch[1] >> 4));
				ch4[2] = (char) ((ch[1] & 0xF) << 2);
				into.print(tochar[ch4[0]]);
				into.print(tochar[ch4[1]]);
				into.print(tochar[ch4[2]]);
				into.print('=');
			}
			if (length1 == 1) {
				ch[0] = file_bin.read();
				ch4[0] = (char) (ch[0] >> 2);
				ch4[1] = (char) ((ch[0] & 3) << 4);
				into.print(tochar[ch4[0]]);
				into.print(tochar[ch4[1]]);
				into.print('=');
				into.print('=');
			}

			// System.out.println("->" + file_bin.available());
			length1 = file_bin.available();
		}
		file_bin.close();
		into.close();
		return 0;
	}

}
