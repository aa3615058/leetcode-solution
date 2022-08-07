package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.Arrays;

import org.lengyu.algorithm.Answer;

public class Solution61 {

    public boolean isStraightB(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < 5) {
            if(nums[i] > 0) break;
            else i++;
        }
        int count = i;
        i++;
        while(i < 5) {
            int f0 = nums[i] - nums[i-1] - 1;
            if(f0 < 0) return false;
            count -= f0;
            if(count < 0) return false;
            i++;
        }
        return true;
    }

    //更好的方法，可以不遍历，直接做减法
    @Answer
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-1) {
            if(nums[i] > 0) break;
            else i++;
        }
        for(int j = i; j < nums.length-1; j++) {
            if(nums[j] == nums[j+1]) return false;
        }
        return nums[nums.length-1] - nums[i] - (nums.length-1 - i) <= i; 
    }
}
