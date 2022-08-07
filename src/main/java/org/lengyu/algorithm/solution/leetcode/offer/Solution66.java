package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.Answer;

public class Solution66 {
    public int[] constructArrB(int[] a) {
        if(a == null || a.length <= 1)return a;
        int[] leftMults = new int[a.length];
        int[] rightMults = new int[a.length];
        leftMults[0]=a[0];
        rightMults[a.length-1]=a[a.length-1];
        for(int i = 1; i < a.length; i++) {
            leftMults[i]=leftMults[i-1]*a[i];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            rightMults[i]=rightMults[i+1]*a[i];
        }
        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            int left = i == 0 ? 1:leftMults[i-1];
            int right = i == a.length-1? 1:rightMults[i+1];
            result[i] = left*right;
        }
        return result;
    }
    @Answer
    public int[] constructArr(int[] a) {
        if(a == null || a.length <= 1)return a;
        int[] result = new int[a.length];
        result[0] = 1;
        for(int i = 1; i < a.length; i++) {
            result[i] = result[i-1]*a[i-1];
        }
        int temp = 1;
        for(int i = a.length-2; i >= 0; i--) {
            temp *= a[i+1];
            result[i] *= temp;
        }
        return result;
    }
}
