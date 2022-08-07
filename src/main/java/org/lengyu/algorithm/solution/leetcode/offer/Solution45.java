package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.Arrays;

public class Solution45 {
    public String minNumber(int[] nums) {
        String[] values = new String[nums.length];
        int length=0;
        for(int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            values[i] = s;
            length += s.length();
        }
        StringBuilder s0 = new StringBuilder(length);
        Arrays.sort(values,(a,b)->{
            return (a+b).compareTo(b+a);
        });
        for(String s: values) {
            s0.append(s);
        }
        return s0.toString();
    }

    //首先比较首位数字，首位数字小的排前面
    //首位数字一致的，比较次位数字，次位数字小的排前面
    //次位数字也一致的，再比较次次位
    //比较到一个数耗尽了也没有比较出结果来，短的那个数再翻到首位去比较
    /*public String minNumber(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (Integer a,Integer b)->{
            if(a==b) return 0;
            String sa = a>b ? a.toString() : b.toString();
            String sb = a>b ? b.toString() : a.toString();
            int i = 0;
            int j = 0;
            boolean flag = true;
            while(i<sa.length() && j<sb.length()) {
                if(sa.charAt(i) < sb.charAt(j)) return a > b ? -1 : 1;
                else if(sa.charAt(i) > sb.charAt(j)) return a > b ? 1: -1;
                i++;
                j++;
                if(j==sb.length() && flag) j=0;
                else if(i==sa.length() && flag) {
                    i=0;
                    flag=false;
                }
            }
            return 0;
        });
        StringBuilder s = new StringBuilder();
        for(Integer i : arr) s.append(i);
        return s.toString();
    }*/
}
