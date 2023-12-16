package cn.limy.test.extend;

/**
 * https://blog.csdn.net/Lemon_MY/article/details/88880209
 * https://www.cnblogs.com/wenruo/articles/5349525.html
 */
public class SecondInit extends First {
    public SecondInit() {
        aMethod();
    }

    public void aMethod() {
        System.out.println("in second class");
    }

    public static void main(String[] args) {
        new SecondInit();
    }
}

class First {
    public First() {
        aMethod();
    }

    public void aMethod() {
        System.out.println("in first class");
    }
}
