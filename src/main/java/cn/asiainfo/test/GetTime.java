package cn.asiainfo.test;

abstract class GetTime {
	public final void getTime() { // 此功能如果不需要复写，可加final限定
		long start = System.currentTimeMillis();
		code(); // 不确定的功能部分，提取出来，通过抽象方法实现
		long end = System.currentTimeMillis();
		System.out.println("毫秒是：" + (end - start));
	}

	public abstract void code(); // 抽象不确定的功能，让子类复写实现
}

class SubDemo extends GetTime {
	public void code() { // 子类复写功能方法
		for (int y = 0; y < 100; y++) {
			System.out.println("y");
		}
	}
}


class AbstractDemo {
	public static void main(String[] args) {
		GetTime getTime = new SubDemo();
		getTime.code();
	}
}
