package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.LinkedList;

import org.lengyu.algorithm.Answer;

public class Solution581{
    @Answer
    public String reverseWords(String s) {
        s=s.trim();
        if(s == null || s.length() == 0) return s;
        StringBuilder s0 = new StringBuilder(s.length());
        int former = -1;
        int latter = -1;
        boolean flag = false;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(!flag) continue;
                else {
                    flag = false;
                    former = i+1;
                    //复制单词
                    s0.append(s.substring(former, latter+1));
                    s0.append(' ');
                }
            }else {
                if(!flag) {
                    flag = true;
                    latter = i;
                }else continue;
            }
        }
        if(flag) {
            flag = false;
            former = 0;
            s0.append(s.substring(former, latter+1));
        }else s0.deleteCharAt(s0.length()-1);
        return s0.toString();
    }

    //Naive
    public String reverseWordsB(String s) {
        if(s == null || s.length()==0) return s;
        StringBuilder sa = new StringBuilder(s.length()+1);
        LinkedList<Character> stack = new LinkedList<>();
        boolean flag = false;

        for(int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c==' ') {
                if(flag) {
                    while(!stack.isEmpty()) sa.append(stack.pop());
                    sa.append(' ');
                    flag = false;
                }else continue;
            }
            else {
                if(!flag) flag =true;
                stack.push(c);
            }
        }
        if(flag) while(!stack.isEmpty()) sa.append(stack.pop());
        else if(sa.length()>0) sa.deleteCharAt(sa.length()-1);
        
        return sa.toString();
    }
}
