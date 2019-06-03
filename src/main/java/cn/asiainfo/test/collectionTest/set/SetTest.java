package cn.asiainfo.test.collectionTest.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 类说明：
 * @author Administrator
 * @date 2017年11月24日 下午2:01:50
 */
public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new  HashSet<String>();
		set.add("123");
		set.add("456");
		set.add("789");
		set.add("123");
		for (String object : set) {
			System.out.println(object);
		}
	}
}
