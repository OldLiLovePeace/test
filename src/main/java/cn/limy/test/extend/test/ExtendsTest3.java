package cn.limy.test.extend.test;

/*
	学生案例和老师案例讲解
	
	学生：
		成员变量；姓名，年龄
		构造方法：无参，带参
		成员方法：getXxx()/setXxx()
	老师：
		成员变量；姓名，年龄
		构造方法：无参，带参
		成员方法：getXxx()/setXxx()
*/
//定义学生类
class Student {
	//姓名
	private String name;
	//年龄
	private int age;
	
	public Student() {
	}

	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

//定义老师类
class Teacher {
	//姓名
	private String name;
	//年龄
	private int age;
	
	public Teacher() {
	}

	public Teacher(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

class ExtendsTest3 {
	public static void main(String[] args) {
		//创建学生对象并测试
		//方式1
		Student s1 = new Student();
		s1.setName("林青霞");
		s1.setAge(27);
		System.out.println(s1.getName()+"---"+s1.getAge());
		
		//方式2
		Student s2 = new Student("林青霞",27);
		System.out.println(s2.getName()+"---"+s2.getAge());
		
		//对应的老师测试我不想了，留给你们自己练习。
	}
}