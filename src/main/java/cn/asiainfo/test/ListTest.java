package cn.asiainfo.test;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * 类说明：
 * 
 * @author Administrator
 * @date 2017年12月11日 下午3:42:02
 */
public class ListTest {
	public static void main(String[] args) {
		// ArrayList<String> arrayList = new ArrayList<String>();
		// arrayList.add("1");
		// arrayList.add("2");
		// arrayList.add("3");
		//
		// System.out.println(arrayList.toString());

		// 创建一个数值格式化对象

		Integer a = 133;
		Integer b = 234;
		NumberFormat numberFormat = NumberFormat.getInstance();

		// 设置精确到小数点后0位

		numberFormat.setMaximumFractionDigits(0);

		String result = numberFormat.format((float) a / (float) b * 100);
		String result2 = numberFormat.format((1-(float) a / (float) b )* 100);
		System.out.println(result);
		System.out.println(result2);
	}
}
