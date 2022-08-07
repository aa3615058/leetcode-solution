package org.lengyu.algorithm.solution.leetcode.offer;

public class SolutionBinarySearch {
    public int binarySearch(int[] a, int target) {
        if(a.length == 0) return -1;
        int left = 0;
        int right = a.length-1;
        int m;
        while(left <= right) {
            m = left + (right-left) / 2;
            if(a[m] == target) return m;
            else if(a[m] > target) right = m - 1;
            else left = m + 1;
        }
        return -1;
    }
}
