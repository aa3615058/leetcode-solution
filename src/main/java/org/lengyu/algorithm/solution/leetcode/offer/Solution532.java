package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.Answer;

public class Solution532 {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i) {
                if(nums[i] < nums.length) {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }else break;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums.length) return i;
        }
        return nums.length;
    }

    //数学方法
    @Answer
    public int missingNumberB(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        for(int a: nums) sum -= a;
        return sum;
    }    
}
