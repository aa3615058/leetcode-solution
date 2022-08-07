package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution51 {
    //归并排序过程中统计逆序数
    //O(nlogn)
    public int reversePairs(int[] nums) {
        count=0;
        mergeSort(nums);
        return count;
    }

    private int[] merge_aux;
    private int count;
    
    private int[] mergeSort(int[] a) {
        if(a == null || a.length <= 1) return a;
        if(merge_aux == null || merge_aux.length < a.length) {
            merge_aux = new int[a.length];
        }
        mergeSort_sort(a,0,a.length-1);
        return a;
    }

    private void mergeSort_sort(int[] a, int lo, int hi) {
        if(hi - lo <= 0) return;
        else if(hi - lo == 1) {
            if(a[lo] > a[hi]) {
                int tmp = a[lo];
                a[lo] = a[hi];
                a[hi] = tmp;
                //
                count++;
            }
        }else {
            int mid = (lo+hi)/2;
            mergeSort_sort(a, lo, mid);
            mergeSort_sort(a, mid+1, hi);
            mergeSort_merge(a, lo, mid, hi);
        }
    }

    private void mergeSort_merge(int[] a, int lo, int mid, int hi) {
        for(int i = lo; i <= hi; i++) {
            merge_aux[i] = a[i];
        }

        int i = lo;
        int j = mid+1;
        int k = lo;

        while(k <= hi) {
            if(i > mid) a[k++] = merge_aux[j++];
            else if(j > hi) a[k++] = merge_aux[i++];
            else if(merge_aux[j] < merge_aux[i]) {
                a[k++] = merge_aux[j++];
                //
                count+=mid-i+1;
            }
            else a[k++] = merge_aux[i++];
        }
    }
}
