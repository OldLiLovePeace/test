package cn.limy.test;

public class Dog implements Animal {
 String dogsAge;
	@Override
	public void eat() {
		System.out.println("======eat");
	}

	@Override
	public void think() {
		System.out.println("=====think");
	}

}
