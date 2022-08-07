package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.ListNode;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode n = head;
        ListNode pre = null;
        while(n != null) {
            if(n.val == val) {
                if(n == head)return head.next;
                else {
                    pre.next = n.next;
                    break;
                }
            }
            pre = n;
            n = n.next;
        }

        return head;
    }
}
