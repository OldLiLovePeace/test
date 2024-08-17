package cn.limy.test.leetcode.testSolution;

import cn.limy.test.leetcode.Test;
import com.alibaba.fastjson.JSON;

public class TestSolution {
    public static void main(String[] args) {
        new TestSolution().testSolution977();
    }
     void testSolution977(){
        Test.Solution977 solution977 = new Test().new Solution977();
        int [] array = {-4,-1,0,1,1,3,10};
        int[] ints = solution977.sortedSquares(array);
        System.out.println(JSON.toJSON(ints));

    }
}
