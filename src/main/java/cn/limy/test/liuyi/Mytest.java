package cn.limy.test.liuyi;

public class Mytest {
	public static void main(String[] args) {
		String str1 = "111";
//		String str2 = new String("111");
//		String str3 = new String("111");
		String str2 = new StringBuilder("111").toString();
		String str3 = new StringBuilder("111").toString();
//		str2.intern();
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);
		System.out.println(str1 == str2.intern());
		System.out.println(str3.intern() == str2.intern());
		
	}
}
