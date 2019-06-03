package cn.asiainfo.test.extend;
/*
	看程序写结果：
		A:成员变量的问题
			int x = 10; //成员变量是基本类型
			Student s = new Student(); //成员变量是引用类型
		B:一个类的初始化过程
			成员变量的初始化
				默认初始化
				显示初始化
				构造方法初始化
		C:子父类的初始化(分层初始化)
			先进行父类初始化，然后进行子类初始化。
			
	结果：
		YXYZ
		
	问题：
		虽然子类中构造方法默认有一个super()
		初始化的时候，不是按照那个顺序进行的。
		而是按照分层初始化进行的。
		它仅仅表示要先初始化父类数据，再初始化子类数据。
*/
class X {
	static {
		System.out.println("x静态");
	}
	Y b = new Y("x");
	X() {
		System.out.println("X");
	}
}

class Y {
	static {
		System.out.println("y静态");
	}
	Y(String a) {
		System.out.println("Y在"+a+"里初始化");
	}
}

public class Z extends X {
	static {
		System.out.println("z静态");
	}
	Y y = new Y("z");
	Z() {
		//super
		System.out.println("Z");
	}
	public static void main(String[] args) {
		new Z(); 
	}
}