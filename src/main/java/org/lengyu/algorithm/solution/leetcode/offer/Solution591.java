package org.lengyu.algorithm.solution.leetcode.offer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.lengyu.algorithm.Answer;

public class Solution591{
    //非严格单调递减双端队列
    //考虑使用一个双端队列来存储滑动窗口，可以观察到如下的现象
    //例如窗口为：1,2,2,2,5,2,2,2,4
    //容易发现，其实 5 前面那些 1,2,2,2 没有任何用，不会影响最大值
    //进一步地，其实 有用的就是 5,4
    //滑动窗口 存储一个非严格递减双端队列
    //入队a：检查队尾元素，如果比a小，出队，一直到队列清空或队尾元素不小于a为止，a入队
    //出队a：检查队首元素，如果是a直接出队
    //这其实是一个包含 O(1) max 函数的队列
    //易于理解出队和入队操作都最多进行n次，而双端队列的出队和入队操作复杂度为O(1)
    //O(n)
    @Answer
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        deque.add(nums[0]);
        for(int i = 1; i < k; i++) {
            while(!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        int j = 0;
        while(j < res.length) {
            res[j] = deque.peek();
            if(nums[j] == deque.peek()) deque.poll();
            if(j+k < nums.length) {
                while(!deque.isEmpty() && nums[j+k] > deque.getLast()) {
                    deque.removeLast();
                }
                deque.add(nums[j+k]);
            }
            j++;
        }
        return res;
    }

    //优先队列+HashMap，用HashMap来记录所有被删除节点的删除次数，优先队列出队时检索此map
    //O(nlogn)，优先队列的入队和出队操作用时O(logn)
    public int[] maxSlidingWindowB(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int j = 0;
        while(j < res.length) {
            res[j]=pq.peek();
            if(j+k < nums.length) pq.add(nums[j+k]);
            if(nums[j]==pq.peek()) {
                pq.poll();
                Integer peek = pq.peek();
                while(peek!=null && map.containsKey(peek)) {
                    int count = map.get(peek);
                    for(int i=0; i < count; i++) {
                        pq.poll();
                    }
                    map.remove(peek);
                    peek = pq.peek();
                }
            }else {
                if(map.containsKey(nums[j]))map.put(nums[j],map.get(nums[j])+1);
                else map.put(nums[j],1);
            }
            j++;
        }
        return res;
    }
}
