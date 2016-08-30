/**
 * 
 */
package com.b510.mp3.util;

import java.io.File;
import java.io.IOException;

import com.b510.mp3.common.Common;

/**
 * @author Hongten
 * @created Jul 29, 2014
 */
public class CommonUtil {

	public static String getPostfix(String path) {
		if (path == null || Common.EMPTY.equals(path.trim())) {
			return Common.EMPTY;
		}
		if (path.contains(Common.FULL_SPOT)) {
			return path.substring(path.lastIndexOf(Common.FULL_SPOT) + 1, path.length());
		}
		return Common.EMPTY;
	}

	public static long getFileSize(String filePath) {
		long size = 0;
		File file = new File(filePath);
		if (file.exists() && file.isFile()) {
			size = file.length();
		}
		return size;
	}

	public static String addPoint(String str, int size) {
		int point = size - str.getBytes().length;
		if (point > 0) {
			for (int i = 0; i < point; i++) {
				str += Common.FULL_SPOT;
			}
		} else {
			str = str.substring(0, size - 1);
		}
		return str.toString();
	}

	public static String getEllipsisString(String string) {
		string = string.replace(Common.DOUBLE_ELLIPSIS, Common.ELLIPSIS_SIGN).replace(Common.BLACKSLASH, Common.ELLIPSIS_SIGN);
		StringBuffer sb = new StringBuffer();
		if (null != string && !Common.EMPTY.equals(string.trim())) {
			if (string.length() > 70) {
				String[] temp = string.split(Common.ELLIPSIS_SIGN);
				if (temp.length > 1) {
					string = addPoint(string.substring(0, 45), 48) + Common.ELLIPSIS_SIGN + temp[temp.length - 1];
				}
			}
			if (string.length() < 70) {
				sb.append(string);
				for (int i = 0; i < (70 - string.length()); i++) {
					sb.append(Common.BLANK);
				}
			}
		}
		return sb.toString();
	}
	
	public static String getLastName(String string){
		if(null == string || Common.EMPTY.equals(string)){
			return Common.EMPTY;
		}
		return string.substring(string.lastIndexOf('/') + 1, string.lastIndexOf('.'));
	}
	
	public static void accessURL(String url) {
		if(null == url || Common.EMPTY.equals(url)){
			return;
		}
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String str = getEllipsisString("E:/ELS/ELS-861/The Same Caveator or Common Title/Angeli Test/Wu Jun Test 24-Jul-2014/Wu Jun Jul 24, 2014");
		System.out.println(str);
		System.out.println("E:/ELS/ELS-861/.../Wu Jun Jul 24, 2014       ".equals(str));
		
		String string = "com/b510/mp3/resources/images/head/wenlan_1.jpg";
		string = getLastName(string);
		System.out.println(string);
		
		String url = "http://www.cnblogs.com/hongten";
		accessURL(url);
	}
}
