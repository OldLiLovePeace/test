package cn.asiainfo.test.duotai;

/*
多态的弊端：
	不能使用子类的特有功能。
	
我就想使用子类的特有功能?行不行?
	行。
	
怎么用呢?
	A:创建子类对象调用方法即可。(可以，但是很多时候不合理。而且，太占内存了)
	B:把父类的引用强制转换为子类的引用。(向下转型)
	
对象间的转型问题：
	向上转型：
		Fu4 f = new Zi4();
	向下转型：
		Zi4 z = (Zi4)f; //要求该f必须是能够转换为Zi4的。
*/
class Fu4 {
public void show() {
	System.out.println("show Fu4");
}
}

class Zi4 extends Fu4 {
public void show() {
	System.out.println("show Zi4");
	this.method();
	super.show();
}

public void method() {
	System.out.println("method Zi4");
}

}

class DuoTaiDemo4 {
public static void main(String[] args) {
	//测试
	Fu4 f = new Zi4();
	f.show();
	System.out.println("--------");
	//f.method();
	
	//创建子类对象
	//Zi4 z = new Zi4();
	//z.show();
	//z.method();
	
	//你能够把子的对象赋值给父亲，那么我能不能把父的引用赋值给子的引用呢?
	//如果可以，但是如下
	Zi4 z = (Zi4)f;
	z.show();
	System.out.println("--------");
	z.method();
}
}