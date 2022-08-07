package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.ListNode;

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for(int i = k-1; i > 0; i--) {
            if(node == null) return null;
            else node=node.next;
        }
        ListNode preNode = head;
        while(node.next != null) {
            node=node.next;
            preNode=preNode.next;
        }
        return preNode;
    }
}
