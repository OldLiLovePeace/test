package cn.limy.test.java8;

import java.util.function.Supplier;

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }
 
    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }
 
    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }
 
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
    
    public static void main(String[] args) {
//		Car car = new Supplier<Car>() {
//
//			@Override
//			public Car get() {
//				return new Car();
//			}
//		}.get();
    	
    	Car car = Car.create( Car::new );
    	car = Car.create( ()-> new Car());
    	car = Car.create( ()-> {return new Car();});
    	
            
	}
}
