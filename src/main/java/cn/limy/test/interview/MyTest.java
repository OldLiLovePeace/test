package cn.limy.test.interview;

public class MyTest {
    /**
     * 写一个函数，输入两个String(str1，str2)，查找并返回在str1中，一共出现了多少次str2，可以使用jdk的函数
     */
    public static void main(String[] args) {
        String str1 = "0000";
        String str2 = "0";


        int count=0;
        int length2 = str2.length();
        while(str1.contains(str2)){
            int i = str1.indexOf(str2);
            str1 = str1.substring(i, length2);
            count++;
        }

        System.out.println(count);




    }
}
