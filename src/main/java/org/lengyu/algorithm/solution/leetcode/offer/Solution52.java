package org.lengyu.algorithm.solution.leetcode.offer;
import org.lengyu.algorithm.Answer;
import org.lengyu.algorithm.common.ListNode;

public class Solution52 {
    @Answer
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        
        while(a.next!=null) {
            a=a.next;
            lenA++;
        }
        while(b.next!=null) {
            b=b.next;
            lenB++;
        }
        if(a!=b)return null;

        a = headA;
        b = headB;
        for(int i = 0; i < lenA-lenB; i++) a=a.next;
        for(int i = 0; i < lenB-lenA; i++) b=b.next;
        
        while(a!=null) {
            if(a==b) return a;
            a=a.next;
            b=b.next;
        }
        
        return null;
    }

    public ListNode getIntersectionNodeB(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        boolean fa = false;
        boolean fb = false;
        while(a != null) {
            if(a==b)return a;
            if(a.next==null && !fa) {
                fa=true;
                a = headB;
            }else a = a.next;
            if(b.next==null && !fb) {
                fb=true;
                b = headA;
            }else b = b.next;
        }
        return null;
    }
}
