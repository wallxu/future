package com.wallxu.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author: wallxu
 * @email: wallxu
 * @date: 2020/6/28 10:10
 * @since 1.0.0
 */
public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++){
                map.put(nums[i], i);
            }

            for(int i=0; i<nums.length; i++){
                //map里是否有另一个数
                if(map.containsKey(target-nums[i]) && (map.get(target-nums[i]) != i)){
                    result[1] = i;
                    result[0] = map.get(target-nums[i]);
                }
            }

            // System.out.println(result[0] + "," + result[1]);
            return result;
        }
    }
}
