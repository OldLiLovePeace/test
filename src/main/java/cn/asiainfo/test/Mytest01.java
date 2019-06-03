package cn.asiainfo.test;

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
