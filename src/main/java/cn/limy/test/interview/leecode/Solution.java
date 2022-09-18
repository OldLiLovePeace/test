package cn.limy.test.interview.leecode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[]  twoSum(int[] nums,int target){
        int n = nums.length;
        for (int i=0; i<n; i++){
            for (int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[]  twoSum2(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; i++){
            int a = target - nums[i];
            if(map.containsKey(a)){
                return new int[]{i,map.get(a)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,3,1};
        System.out.println(JSON.toJSONString(Solution.twoSum2(nums, 5)));
    }
}
