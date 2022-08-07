package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.LinkedList;

import org.lengyu.algorithm.Answer;

public class Solution30 {
    @Answer
    public class MinStack {
        LinkedList<Integer> as;
        LinkedList<Integer> mins;

        public MinStack() {
            as = new LinkedList<>();
            mins = new LinkedList<>();
        }
        
        public void push(int x) {
            as.push(x);
            if(as.size() == 1) mins.push(x);
            else {
                if(x < mins.peek()) {
                    mins.push(x);
                }else mins.push(mins.peek());
            }
        }
        
        public void pop() {
            as.pop();
            mins.pop();
        }
        
        public int top() {
            return as.peek();
        }
        
        public int min() {
            return mins.peek();
        }
    }

    @Answer
    public class MinStackB {
        LinkedList<Integer> as;
        LinkedList<Integer> mins;
        
        public MinStackB() {
            as = new LinkedList<>();
            mins = new LinkedList<>();
        }
        
        public void push(int x) {
            as.push(x);
            if(as.size() == 1) mins.push(x);
            else {
                if(x < mins.peek()) {
                    mins.push(x);
                }else mins.push(mins.peek());
            }
        }
        
        public void pop() {
            as.pop();
            mins.pop();
        }
        
        public int top() {
            return as.peek();
        }
        
        public int min() {
            return mins.peek();
        }
    }
}