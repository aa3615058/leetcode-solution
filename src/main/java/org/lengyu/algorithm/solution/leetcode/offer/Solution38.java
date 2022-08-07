package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.HashMap;

public class Solution38 {
    //DFS深搜，没有考虑重复情况
    /*public String[] permutation(String s) {
        if(s == null) return new String[0];
        else if(s.length() <= 1) return new String[]{s};
        String[] res = new String[factorial(s.length())];
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            String[] tmp = permutation(s.substring(0, i)+s.substring(i+1));
            for(String s0 : tmp) {
                res[j] = s.charAt(i) + s0;
                j++;
            }
        }
        return res;
    }

    private int factorial(int i) {
        if(i == 0 || i == 1) return 1;
        else return i*factorial(i-1);
    }*/

    //用HashMap统计每个字符出现次数，这样可以提前算出 String[] 长度
    //此方法思路简单，实现比较复杂
    //递归如想追求效率，返回值要简单，如类似 public void dfs() ，用成员变量来充当全局变量
    public String[] permutation(String s) {
        if(s.length() == 1) return new String[]{s};
        char[] chs = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < chs.length; i++) {
            if(map.containsKey(chs[i])) map.put(chs[i], map.get(chs[i])+1);
            else map.put(chs[i],1);
        }
        
        String[] res = new String[calCapcity(s.length(), map)];
        int j = 0;
        for(int i = 0; i < chs.length; i++) {
            if(map.get(chs[i]) == 0) continue;
            else map.put(chs[i],0);
            for(String s1 : permutation(new StringBuilder(s).deleteCharAt(i).toString())) {
                res[j++] = chs[i]+s1;
            }
        }

        return res;
    }

    private int calCapcity(int len, HashMap<Character,Integer> map) {
        int res = 1;
        for(int i = 2; i <= len; i++) res *= i;
        for(Integer e : map.values()) {
            for(int i = e; i > 1; i--) {
                res /= i;
            }
        }
        return res;
    }
}
