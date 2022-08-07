package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.HashMap;

import org.lengyu.algorithm.Answer;

public class Solution562 {
    
    //有限状态自动机
    public int singleNumberC(int[] nums) {
        
        return 0;
    }

    //统计法，时间复杂度O(n)，空间复杂度O(1)，不如有限状态自动机
    @Answer
    public int singleNumber(int[] nums) {
        int r = 0;
        int m;
        int beacon = 1;
        for(int i = 0; i < 32; i++) {
            m = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & beacon) == 0);
                else m++;
            }
            if(m % 3 == 1) r = r | beacon;
            beacon = beacon << 1;
        }

        return r;
    }
    
    //哈希法，时间复杂度O(n)，空间复杂度O(n)，很容易想到
    public int singleNumberB(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n))map.put(n, 1);
            else map.put(n,map.get(n)+1);
        }
        for(int k: map.keySet()) {
            if(map.get(k) == 1) return k;
        }
        return 0;
    }
}
