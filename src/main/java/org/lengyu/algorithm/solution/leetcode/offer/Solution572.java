package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.ArrayList;

public class Solution572 {
    public int[][] findContinuousSequence(int target) {
        if(target < 3) return new int[0][0];
        int a = 2;
        ArrayList<Integer> listA = new ArrayList<>();//起始数字
        ArrayList<Integer> listB = new ArrayList<>();//数组长度
        
        while(target >= (a*(a+1)>>1)) {
            int s = target*2 - a*a + a;
            if(s % (2*a) == 0) {
                listA.add(s/(2*a));
                listB.add(a);
            }
            a++;
        }

        if(listA.isEmpty())return new int [0][0];
        int len = listA.size();
        int[][] results = new int[len][];

        for(int i = 0; i < len; i++) {
            results[len-1-i] = new int[listB.get(i)];
            for(int j = 0; j < listB.get(i); j++) {
                results[len-1-i][j] = listA.get(i)+j;
            }
        }

        return results;
    }
}
