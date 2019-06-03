package cn.asiainfo.test.extend;
/*
	方法重写的注意事项
		A:父类中私有方法不能被重写
			因为父类私有方法子类根本就无法继承
		B:子类重写父类方法时，访问权限不能更低
			最好就一致
		C:父类静态方法，子类也必须通过静态方法进行重写
			其实这个算不上方法重写，但是现象确实如此，至于为什么算不上方法重写，多态中我会讲解
			
		子类重写父类方法的时候，最好声明一模一样。
*/
class Father10 {
	protected String age="22";
	//private void show() {}
	
	/*
	public void show() {
		System.out.println("show Father10");
	}
	*/
	
	void show() {
		System.out.println("show Father10");
	}
	
	public static void staticmethod() {
		System.out.println("Father static method");
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void method() {
		System.out.println(this.age);
		System.out.println(((Son10)this).age);
	}
}

class Son10 extends Father10 {
	String age="11";
	//private void show() {}

	/*
	public void show() {
		System.out.println("show Son10");
	}
	*/
	
	public void show() {
		System.out.println("show Son10");
	}
	
	
//	public static void staticmethod() {
//		System.out.println("Son static method");
//	}
	

//	public void method() {
//		System.out.println(this.age);
////		private的字段无法被继承，但是可以调用父类的get set方法获取
//		System.out.println(super.getAge());
//	}

}

class ExtendsDemo10 {
	public static void main(String[] args) {
		Son10 s = new Son10();
		s.show();
//		继承父类的方法，父类的方法中的this指父类对象，即使this后面的字段父子都有
		s.method();
		s.staticmethod();
	}
}