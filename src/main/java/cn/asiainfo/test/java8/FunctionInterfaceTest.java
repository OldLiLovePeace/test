package cn.asiainfo.test.java8;

import org.junit.Test;

/**
 * 函数接口测试
 * Created by Kevin on 2018/2/17.
 */
public class FunctionInterfaceTest {

    @Test
    public void testLambda() {
//        func(new FunctionInterface() {
//            @Override
//            public void test() {
//                System.out.println("Hello World!");
//            }
//        });
        //使用Lambda表达式代替上面的匿名内部类
//    	1无返回，无入参
//        func(() -> System.out.println("Hello World"));
    	
//    	2有入参
//    	func((x) -> System.out.println("Hello World" + x));
    	
//    	3有入参，泛型
//    	func((Integer x) -> {System.out.println("Hello World" + x)});
//    	4有入参和出参
		func((Integer x) -> {
			System.out.println("Hello World" + x);
			return true;
		});
    }

    private void func(FunctionInterface<Integer> functionInterface) {
//        functionInterface.test();
        
       int x = 1;
//       functionInterface.test03(x);
       boolean test04 = functionInterface.test04(x);
    }
}
