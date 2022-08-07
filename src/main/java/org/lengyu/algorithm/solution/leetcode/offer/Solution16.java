package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution16 {
    //坑一：Integer.MIN_VALUE 是 -2147483648，而 Integer.MAX_VALUE 是 2147483647，需要拓展到long
    //坑二：O(n) 的算法会超时
    public double myPow(double x, int n) {
        if(x == 1 || x == 0) return x;
        if(n == 0) return 1;

        long m = n >= 0 ? n : -(long)n;
        
        double res = 1;
        double pre = n >= 0 ? x : 1/x;
        while(m!=0) {
            if((m&1) == 1) {
                res *= pre;
            }
            m = m >> 1;
            pre *= pre;
        }

        return res;
    }
}
