package org.lengyu.algorithm.solution.leetcode.offer;
import org.lengyu.algorithm.Answer;

import java.util.LinkedList;

public class Solution592 {
    public class MaxQueue {
        private LinkedList<Integer> list;
        private int max;
        private int maxCount;

        public MaxQueue() {
            list = new LinkedList<>();
            max = -1;
            maxCount = 0;
        }
        
        public int max_value() {
            if(list.isEmpty()) return -1;
            if(maxCount <= 0) {
                max = list.peekFirst();
                for(int i : list) {
                    if(i > max) max = i;
                }
                maxCount = 1;
            }
            return max;
        }
        
        public void push_back(int value) {
            list.add(value);
            if(list.size() == 1 || value > max) {
                max = value;
                maxCount = 1;
            }
            else if(value == max) maxCount++;
        }
        
        public int pop_front() {
            if(list.isEmpty()) return -1;
            int temp = list.poll();
            if(temp == max) maxCount--;
           return temp;
        }
    }

    @Answer
    public class MaxQueueB {
        private LinkedList<Integer> list;
        private LinkedList<Integer> maxList;

        public MaxQueueB() {
            list = new LinkedList<>();
            maxList = new LinkedList<>();
        }
        
        public int max_value() {
            return maxList.isEmpty() ? -1:maxList.peekFirst();
        }
        
        public void push_back(int value) {
            list.add(value);
            while(!maxList.isEmpty()) {
                if(value <= maxList.peekLast()) {
                    maxList.add(value);
                    break;
                }else maxList.removeLast();
            }
            if(maxList.isEmpty()) maxList.add(value);
        }
        
        public int pop_front() {
            if(list.isEmpty()) return -1;
            int temp = list.poll();
            if(temp == maxList.peekFirst()) maxList.poll();
            return temp;
        }
    }
}
