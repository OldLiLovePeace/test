package cn.asiainfo.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
	public static void main(String[] args) {
		
	}
//    * StringUtils.indexOf(null, *, *)          = -1
//    * StringUtils.indexOf("", *, *)            = -1
//    * StringUtils.indexOf("aabaabaa", 'b', 0)  = 2
//    * StringUtils.indexOf("aabaabaa", 'b', 3)  = 5
//    * StringUtils.indexOf("aabaabaa", 'b', 9)  = -1
//    * StringUtils.indexOf("aabaabaa", 'b', -1) = 2
	
	@Test
	public void testIndexOf01() {
	  System.out.println( StringUtils.indexOf(null, "b", 0));         // = -1
	  System.out.println(  StringUtils.indexOf("", "b", 0));             //= -1
	  System.out.println( StringUtils.indexOf("aabaabaa", "b", 0));  //= 2
	  System.out.println(  StringUtils.indexOf("aabaabaa", "b", 3)); // = 5
	  System.out.println(  StringUtils.indexOf("aabaabaa", "b", 9));  //= -1
	  System.out.println(  StringUtils.indexOf("aabaabaa", "b", -1)); //= 2
	} 
	
	@Test
	public void testIndexOf02() {
//		b在ASCII码表中十进制是98，char类型用单引号修饰
		System.out.println( StringUtils.indexOf(null, 98, 0));         // = -1
		System.out.println(  StringUtils.indexOf("", 98, 0));             //= -1
		System.out.println( StringUtils.indexOf("aabaabaa", 98, 0));  //= 2
		System.out.println(  StringUtils.indexOf("aabaabaa", 98, 3)); // = 5
		System.out.println(  StringUtils.indexOf("aabaabaa", 98, 9));  //= -1
		System.out.println(  StringUtils.indexOf("aabaabaa", 98, -1)); //= 2
//		八进制142=十进制98
		System.out.println(  StringUtils.indexOf("aabaabaa", 0142, -1)); //= 2
	} 
}              
