package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.lengyu.algorithm.Answer;

public class Solution49 {
    //优先队列，额外使用HashSet去重，O(nlogn)
    public int nthUglyNumberA(int n) {
        if(n <= 6) return n;
        long[] factors = new long[]{2,3,5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> hash = new HashSet<>();
        for(long f : factors) {
            hash.add(f);
            queue.add(f);
        }
        while(n > 2) {
            long x = queue.poll();
            for(long f : factors) {
                if(!hash.contains(x*f)) {
                    hash.add(x*f);
                    queue.add(x*f);
                }
            }
            n--;
        }
        
        return (int)queue.poll().longValue();
    }

    //优先队列（红黑树）
    public int nthUglyNumberC(int n) {
        if(n <= 6) return n;
        long[] factors = new long[]{2,3,5};
        TreeSet<Long> queue = new TreeSet<>();
        for(long f : factors) {
            queue.add(f);
        }
        while(n > 2) {
            long x = queue.pollFirst();
            for(long f : factors) {
                queue.add(x*f);
            }
            n--;
        }
        return (int)queue.pollFirst().longValue();
    }

    //动态规划
    @Answer
    public int nthUglyNumber(int n) {
        if(n <= 6) return n;
        int[] nums = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        nums[0] = 1;
        int i = 1;
        while(i < n) {
            int num1 = nums[a] * 2;
            int num2 = nums[b] * 3;
            int num3 = nums[c] * 5;
            int m = Math.min(Math.min(num1,num2),num3);
            nums[i] = m;
            if(m == num1) a++;
            if(m == num2) b++;
            if(m == num3) c++;
            i++;
        }
        return nums[n-1];
    }
}
