package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 1) return new int[0];
        if(nums[0] >= target) return new int[0];

        int left = 0;
        int right = nums.length-1;
        int mid;

        while(right - left > 1) {
            mid = (left+right)/2;
            if(nums[mid] > target) right=mid;
            else if(nums[mid] <= target) left=mid;
        }

        left = 0;
        while(right > left) {
            if(nums[left]+nums[right] == target) return new int[]{nums[left],nums[right]};
            else if(nums[left]+nums[right] > target) right--;
            else left++;
        }
        return new int[0];
    }
}
