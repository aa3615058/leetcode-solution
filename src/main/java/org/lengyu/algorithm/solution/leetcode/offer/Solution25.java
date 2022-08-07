package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.common.ListNode;

public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode a = l1;
        ListNode b = l2;
        ListNode blankNode = new ListNode(0);
        ListNode newNode = blankNode;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                newNode.next = a;
                a = a.next;
            }else {
                newNode.next = b;
                b = b.next;
            }
            newNode = newNode.next;
        }
        if(a != null) {
            newNode.next = a;
        }
        if(b != null) {
            newNode.next = b;
        }

        return blankNode.next;
    }    
}
