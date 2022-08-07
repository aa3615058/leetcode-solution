package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution62 {
    //递推公式 f(n,m) = (f(n-1,m)+m)%n
    public int lastRemaining(int n, int m) {
        int res = 0;
        for(int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
