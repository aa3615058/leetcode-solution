package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution41 {
    public class MedianFinder {
        //如果使用数组，findMedian()是O(1)，addNum()是O(n)
        //如果使用双端队列，比数组好，保存一个中位数指针，findMedian()是O(1)，addNum()是O(n)
        //一个小根堆，一个大根堆，维持两者节点数相等
        //addNum()是O(logn)，findMedian()是O(1)
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            minHeap = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if(minHeap.isEmpty()) minHeap.add(num);
            else {
                if(num >= minHeap.peek()) minHeap.add(num);
                else maxHeap.add(num);
                int a = maxHeap.size() - minHeap.size();
                
                if(a > 1) minHeap.add(maxHeap.poll());
                else if(a < -1) maxHeap.add(minHeap.poll());
            }
        }
        
        public double findMedian() {
            int a = maxHeap.size()-minHeap.size();
            if(a == 0) {
                return (double)(maxHeap.peek()+minHeap.peek())/2;
            }else if(a > 0) {
                return maxHeap.peek();
            }else {
                return minHeap.peek();
            }
        }
    }
}