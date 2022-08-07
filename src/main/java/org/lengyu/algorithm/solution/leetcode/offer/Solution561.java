package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution561 {
    public int[] singleNumbers(int[] nums) {
        int[] r = new int[2];
        int xy = 0;
        for(int n : nums) {
            xy = xy^n;
        }
        int beacon = 1;
        while(beacon != 0) {
            if((xy & beacon) != 0) break;
            beacon = beacon << 1;
        }

        for(int n : nums) {
            if((n & beacon) == 0) r[0] = r[0] ^ n;
            else r[1] = r[1] ^ n;
        }

        return r;
    }
}
