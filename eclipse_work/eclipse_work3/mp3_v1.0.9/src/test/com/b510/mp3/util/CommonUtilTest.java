/**
 * 
 */
package test.com.b510.mp3.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.b510.mp3.common.Common;
import com.b510.mp3.util.CommonUtil;

/**
 * @author Hongten
 * @created 2014-7-29
 */
public class CommonUtilTest {

	@Test
	public void testGetPostfix() {
		String path = CommonUtilTest.class.getClassLoader().getResource(Common.SCREENSHOT_BG).toString();
		String postfix = CommonUtil.getPostfix(path);
		assertEquals("png", postfix);
	}
	
	@Test
	public void testGetFileSize() {
		String path = CommonUtilTest.class.getClassLoader().getResource(Common.SCREENSHOT_BG).toString();
		path = path.substring(6, path.length());
		long size = CommonUtil.getFileSize(path);
		assertEquals(59121, size);
	}

}
