package cn.limy.test.duotai;

/*
ClassCastException:类型转换异常
一般在多态的向下转型中容易出现
*/
class Animal5 {
public void eat(){}
}

class Dog5 extends Animal5 {
public void eat() {}

public void lookDoor() {

}
}

class Cat5 extends Animal5 {
public void eat() {

}

public void playGame() {
	
}
}

class DuoTaiDemo5 {
public static void main(String[] args) {
	//内存中的是狗
	Animal5 a = new Dog5();
	Dog5 d = (Dog5)a;
	
	//内存中是猫
	a = new Cat5();
	Cat5 c = (Cat5)a;
	
	//内存中是猫
	Dog5 dd = (Dog5)a; //ClassCastException
}
}