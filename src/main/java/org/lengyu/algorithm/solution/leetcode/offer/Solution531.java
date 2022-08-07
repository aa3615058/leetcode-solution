package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution531 {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return binarySearchLeftBinary(nums, target+1)-binarySearchLeftBinary(nums, target);
    }

    //针对可能有重复数字的排序数组，找出第一个target所在的位置，即左边界
    //若数组中不存在这个数字，返回和这个数组最接近的第一个数所在的位置
    private int binarySearchLeftBinary(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi) {
            int m = (lo+hi)/2;
            //此处如果改为 <= 可以寻找右边界
            if(nums[m]>=target) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }
}
