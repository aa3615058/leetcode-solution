package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.LinkedList;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length <= 1) return true;
        int len = pushed.length;
        LinkedList<Integer> stack = new LinkedList<>();

        int i = 0;
        int j = 0;

        while(j < len) {
            if(!stack.isEmpty() && stack.peek() == popped[j]) stack.pop();
            else {
                int right = i;
                boolean flag = false;
                while(!flag && right < len) {
                    if(pushed[right] == popped[j]) flag = true;
                    else right++;
                }
                if(flag) {
                    for(int k = i; k < right; k++) stack.push(pushed[k]);
                    i = right+1;
                }else return false;
            }
            j++;
        }

        return true;
    }
}
