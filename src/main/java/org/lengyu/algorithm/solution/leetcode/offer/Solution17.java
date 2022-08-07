package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution17 {
    public int[] printNumbers(int n) {
        int size = (int)(Math.pow(10,n))-1;
        int[] res = new int[size];
        for(int i = 0; i < size; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
