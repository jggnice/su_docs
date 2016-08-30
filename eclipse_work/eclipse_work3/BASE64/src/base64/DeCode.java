package base64;

import java.io.IOException;

public class DeCode {

	public static int decode(String[] args) throws IOException {
		/**
		 * Read TXT
		 */
		java.io.FileInputStream file_txt = new java.io.FileInputStream(args[0]);
		/**
		 * Write binary
		 */
		java.io.FileOutputStream file1 = new java.io.FileOutputStream(args[1]);
		int k = 0, mark1 = 0, mark2 = 0;

		int[] ch = new int[4];
		int temp;

		for (; file_txt.available() > 0;) {
			// k was 0 at first;
			/*
			 * if (file_txt.available() % 4!=0) {
			 * System.out.println("length error! remain" + file_txt.available()
			 * + "letter(s)!"); break; }
			 */
			int str = file_txt.read();
			if (str >= 'A' && str <= 'Z')
				ch[k++] = str - 'A';
			else if (str >= 'a' && str <= 'z')
				ch[k++] = str - 'a' + 26;
			else if (str >= '0' && str <= '9')
				ch[k++] = str - '0' + 52;
			else if (str == '+')
				ch[k++] = 62;
			else if (str == '/')
				ch[k++] = 63;
			else if (str == '=') {
				if (k == 2)
					mark1 = 2;
				if (k == 3)
					mark2 = 3;
				ch[k++] = '=';
			} else {
				System.out
						.println("the sourse file contains unrecognized character");
				break;
			}
			// **********processing***********************
			if (k == 4 && mark1 == 0 && mark2 == 0) {
				k = 0;
				ch[0] = ch[0] << 2;/* MUL 100B */
				temp = ch[1];
				temp = temp >> 4;/* DIV 10000B */

				ch[0] += temp;

				ch[1] = ch[1] << 4;/* MUL 10000B */
				temp = ch[2];
				temp = temp >> 2;/* DIV 100B */
				ch[1] += temp;

				ch[2] = ch[2] << 6;/* MUL 1000000B */
				temp = ch[3];
				ch[2] += temp;
				file1.write(ch[0]);
				file1.write(ch[1]);
				file1.write(ch[2]);
				// fprintf(pic, "%c%c%c", ch[0], ch[1], ch[2]);
			}
			if (k == 4 && mark1 == 0 && mark2 == 3) {
				k = 0;
				ch[0] = ch[0] << 2;
				temp = ch[1];
				temp = temp >> 4;

				ch[0] += temp;

				ch[1] = ch[1] << 4;
				temp = ch[2];
				temp = temp >> 2;
				ch[1] += temp;
				file1.write(ch[0]);
				file1.write(ch[1]);
				// fprintf(pic, "%c%c", ch[0], ch[1]);
			}
			if (k == 4 && mark1 == 2 && mark2 == 3) {
				k = 0;
				ch[0] = ch[0] << 2;
				temp = ch[1];
				temp = temp >> 4;
				ch[0] += temp;
				file1.write(ch[0]);
				// fprintf(pic, "%c", ch[0]);
			}
		}
		file_txt.close();
		file1.close();
		return 0;
	}
}
