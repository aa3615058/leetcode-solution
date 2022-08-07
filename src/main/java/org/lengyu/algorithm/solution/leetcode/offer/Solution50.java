package org.lengyu.algorithm.solution.leetcode.offer;
public class Solution50 {
    public char firstUniqChar(String s) {
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int j  = s.charAt(i) - 'a';
            if(hash[j] > 0) hash[j] = -1;
            if(hash[j] != -1) hash[j] = i+1;
        }

        int minIndex = s.length();
        for(int i = 0; i < hash.length; i++) {
            if(hash[i] > 0) {
                if(hash[i]-1 < minIndex) minIndex = hash[i]-1;
            }
        }

        return minIndex == s.length()? ' ': s.charAt(minIndex);
    }    
}
