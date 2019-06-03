package cn.asiainfo.test.extend.test;

/*
	看程序写结果：
		A:一个类的静态代码块,构造代码块,构造方法的执行流程
			静态代码块 > 构造代码块 > 构造方法
		B:静态的内容是随着类的加载而加载
			静态代码块的内容会优先执行
		C:子类初始化之前先会进行父类的初始化
		
	结果是：
		静态代码块Fu2
		静态代码块Zi2
		构造代码块Fu2
		构造方法Fu2
		构造代码块Zi2
		构造方法Zi2
*/
class Fu2 {
	static {
		System.out.println("静态代码块Fu2");
	}

	{
		System.out.println("构造代码块Fu2");
	}

	public Fu2() {
		System.out.println("构造方法Fu2");
	}
}

class Zi2 extends Fu2 {
	static {
		System.out.println("静态代码块Zi2");
	}

	{
		System.out.println("构造代码块Zi2");
	}

	public Zi2() {
		System.out.println("构造方法Zi2");
	}
}

public class ExtendsTest2 {
	public static void main(String[] args) {
		Zi2 z = new Zi2();
	}
}
