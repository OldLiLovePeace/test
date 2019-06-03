package cn.asiainfo.test.extend.test;
/*
	看程序写结果：
		A:成员变量	就近原则
		B:this和super的问题
			this访问本类的成员
			super访问父类的成员
		C:子类构造方法执行前默认先执行父类的无参构造方法
		D:一个类的初始化过程
			成员变量进行初始化
				默认初始化
				显示初始化
				构造方法初始化
				
	结果：
		fu
		zi
		30
		20
		10
*/
class Fu1{
	public int num = 10;
	public Fu1(){
		System.out.println("fu");
	}
}
class Zi1 extends Fu1{
	public int num = 20;
	public Zi1(){
		System.out.println("zi");
	}
	public void show(){
		int num = 30;
		System.out.println(num); //30
		System.out.println(this.num); //20
		System.out.println(super.num); //10
	}
}
class ExtendsTest {
	public static void main(String[] args) {
		Zi1 z = new Zi1();
		z.show();
	}
}