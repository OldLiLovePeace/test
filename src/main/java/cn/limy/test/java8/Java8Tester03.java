package cn.limy.test.java8;

public class Java8Tester03 {

    public static void main(String args[]) {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
        
        
        
//    lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
//        int num = 1;  
//        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
//        s.convert(2);
//        num = 5;  
        //报错信息：Local variable num defined in an enclosing scope must be final or effectively  final
    
//        在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量
//        String first = "";  
//        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());  //编译会出错 
    
    }
 
    public interface Converter<T1, T2> {
        void convert(int i);
    }
    
    
}
