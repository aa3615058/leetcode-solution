package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution64 {
    public int sumNums(int n) {
        int sum = 0;
        boolean b = (n - 1 > 0) && ((sum = sumNums(n-1))>0);
        return n + sum;
    }
}
