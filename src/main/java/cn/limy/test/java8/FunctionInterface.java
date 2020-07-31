package cn.limy.test.java8;

/**
 * 函数接口：只有一个方法的接口。作为Lambda表达式的类型
 * Created by Kevin on 2018/2/17.
 */
public interface FunctionInterface<T> {
//    void test();
    
//    void test02(int param);
    
//    void test03(T param);
    
    boolean test04(T param);
}