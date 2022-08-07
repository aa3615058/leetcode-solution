package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0) return new int[0];
        int[] hash = new int[10001];
        for(int a: arr) {
            hash[a]++;
        }
        int[] res = new int[k];
        int j = 0;
        for(int i = 0; i < hash.length; i++) {
            while(hash[i] > 0 && j < k) {
                res[j] = i;
                hash[i]--;
                j++;
            }
        }
        return res;
    }
}
