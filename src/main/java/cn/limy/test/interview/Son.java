package cn.limy.test.interview;

/*父类在hello()方法中使用this关键字调用say()方法*/
class Parent {

    public void hello() {
        this.say();
    }

    public void say() {
        System.out.println("I am parent");
    }

}

/*子类重写say方法*/
public class Son extends Parent {

    @Override
    public void say() {
        System.out.println("I am son");
    }
}

/*孙子类*/
class GSon extends Son {


}

/*测试类*/
class TestImpl {

    public static void main(String[] args) {

        Parent son = new Son();
        son.hello();
        /*当子类重写父类方法时，输出为
            I am son
            当子类没有重写父类方法时，输出为
            I am parent
            说明 在继承中，this指的是new的对象，当子类没有重写父类的方法时，在父类中使用this调                    用本身的方法时，this是指new的实例，所以会调用new的实例的方法，如new实例没有重写该方法时，调用其父类的方法实现。
        */

        Parent gson = new GSon();
        gson.hello();
    }
}