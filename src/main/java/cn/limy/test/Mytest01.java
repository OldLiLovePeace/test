package cn.limy.test;

import java.util.HashMap;
import java.util.Map;

public class Mytest01 {
	public static void main(String[] args) {
		// Object lastTimeObject=12L;
		// long lastTime =lastTimeObject !=null?(long) lastTimeObject:0;
		// System.out.println(lastTime);

		// int [] arr = new int[10];
		// for (int i : arr) {
		// System.out.println(arr[i]);
		// }

		
		
		// int x =100,y = 100;
		// String a="ss";
		// String b = a;
		// System.out.println(x == y);
		// System.out.println(a == b);
		// System.out.println(a.hashCode());
		// System.out.println(b.hashCode());

		
		
//		Thread t = new Thread() {
//			public void run() {
//				pong();
//			}
//
//		};

//		t.run();
//		System.out.println("pong");
		
		
		
		// 我们来看看ValueOf(int
        // i)的代码，可以发现他对传入参数i做了一个if判断。在-128<=i<=127的时候是直接用的int原始数据类型，而超出了这个范围则是new了一个对象。我们//知道"=="符号在比较对象的时候是比较的内存地址，而对于原始数据类型是直接比对的数据值。那么这个问题就解决了。
        // 至于为什么用int型的时候值会在-128<=i<=127范围呢呢?我们知道八位二进制的表示的范围正好就是-128到127。大概就是因为这吧。
		Integer i1 = Integer.valueOf("-128");
		Integer i2 = Integer.valueOf("-128");
		System.out.println(i1 == i2);
		
		Integer i3 = Integer.valueOf("128");
		Integer i4 = Integer.valueOf("128");
		System.out.println(i3 == i4);
		
		
		String str1 ="abc";
//		String str2 = "a" +new String("bc");
//		System.out.println(str1 == str2);
		String str3 = new String("abc");
		String str4 = "a" + "bc";
		
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
		System.out.println(str1 == str1.intern());
	}

	static void pong() {
		System.out.println("ping");
	}
	
	

}

class Solution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//统计两个数组中的元素之和，同时统计出现的次数，放入map
		for (int i : nums1) {
			for (int j : nums2) {
				int sum = i + j;
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		//统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
		for (int i : nums3) {
			for (int j : nums4) {
				res += map.getOrDefault(0 - i - j, 0);
			}
		}
		return res;
	}
}
