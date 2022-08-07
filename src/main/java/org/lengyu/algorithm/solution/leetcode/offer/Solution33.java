package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution33 {
    private int[] a;

    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0) return false;
        if(postorder.length == 1) return true;
        a = postorder;
        return verify(0, postorder.length - 1);
    }

    private boolean verify(int start, int end) {
        if(end - start <= 1) return true;
        int mid = end;
        int i = start;
        boolean f_left = true;
        while(i < end) {
            if(a[i] < a[end] && !f_left) return false;
            if(a[i] > a[end] && f_left) {
                mid = i;
                f_left = false;
            }
            i++;
        }
        //System.out.println("start:"+start+",end:"+end+",mid:"+mid);
        //System.out.println("mid:"+mid);
        return verify(start,mid-1) && verify(mid,end-1);
    }
}
