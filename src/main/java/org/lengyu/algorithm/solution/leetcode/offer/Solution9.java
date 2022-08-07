package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.LinkedList;

public class Solution9 {
    public class CQueue {
        private LinkedList<Integer> sa;
        private LinkedList<Integer> sb;

        public CQueue() {
            sa = new LinkedList<>();
            sb = new LinkedList<>();
        }

        public void appendTail(int value) {
            sa.push(value);
        }

        public int deleteHead() {
            if(!sb.isEmpty()) return sb.pop();
            if(sa.isEmpty()) return -1;
            while(!sa.isEmpty()) {
                sb.push(sa.pop());
            }
            return sb.pop();
        }
    }
}
