package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.HashSet;

public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i : nums) {
            if(hash.contains(i)) return i;
            else hash.add(i);
        }
        return -1;
    }
}