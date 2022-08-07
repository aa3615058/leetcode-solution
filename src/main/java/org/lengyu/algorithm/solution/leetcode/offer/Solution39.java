package org.lengyu.algorithm.solution.leetcode.offer;
import java.util.HashMap;

import org.lengyu.algorithm.Answer;

public class Solution39 {
    @Answer
    public int majorityElement(int[] nums) {
        int b=0;
        int m=nums[0];
        for(int a : nums) {
            if(b==0) {
                m=a;
                b=1;
            }else {
                if(a==m) b++;
                else b--;
            }
        }
        return m;
    }

    public int majorityElementB(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();        

        for(int a : nums) {
            if(hash.containsKey(a)) {
                int count = hash.get(a);
                count++;
                if(count > nums.length/2) return a;
                hash.put(a, count);
            }else {
                hash.put(a,1);
            }
        }

        return nums[0];
    }    
}
