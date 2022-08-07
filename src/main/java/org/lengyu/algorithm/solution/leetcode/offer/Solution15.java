package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.Answer;

public class Solution15 {
    @Answer
    public int hammingWeight(int n) {
        int count = 0;
        boolean negative = false;
        if(n < 0) {
            negative =true;
            n=~n;
        }
        while(n!=0) {
            if((n&1)==1)count++;
            n=n>>1;
        }
        return negative ? 32-count: count;
    }

    //JDK中Integer.bitCount()方法，复杂度O(1)
    public int hammingWeightB(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }
}
