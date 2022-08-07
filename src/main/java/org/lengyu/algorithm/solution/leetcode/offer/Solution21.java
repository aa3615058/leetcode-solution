package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution21 {
    public int[] exchange(int[] nums) {
        int i = 0;
        
        int j = nums.length -1;
        while(i < j) {
            while(nums[i] % 2 != 0) {
                i++;
                if(i >=j || i > nums.length/2) return nums;
            }
            while(nums[j] % 2 == 0) {
                j--;
                if(i >= j || j < nums.length/2) return nums;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }    
}
