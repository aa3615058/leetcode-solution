package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.Answer;

public class SolutionSort {
    public int[] sort(int[] a) {
        return mergeSort(a);
    }

    //冒泡排序
    //每一轮把最大的沉底，相邻元素不停比较
    @Answer
    public int[] bubbleSort(int[] a) {
        boolean flag = false;
        for(int i = 0; i < a.length; i++) {
            flag = false;
            for(int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]) {
                    int swap = a[j];
                    a[j] = a[j+1];
                    a[j+1] = swap;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return a;
    }

    //选择排序
    //每次选出最小的数，在数组前面按顺序放好
    @Answer
    public int[] choiceSort(int[] a) {
        int minIndex;
        for(int i = 0; i < a.length; i++) {
            minIndex = i;
            for(int j = i+1; j < a.length; j++) {
                if(a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int swap = a[i];
                a[i] = a[minIndex];
                a[minIndex] = swap;
            }

        }
        return a;
    }

    //插入排序
    //想象玩扑克的时候整理手牌，那个排序方式就是插入排序
    //java.util.Arrays.sort()中的插入排序源码
    @Answer
    public int[] insertSort(int[] a) {
        for (int i = 0, j = i; i < a.length-1; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == 0) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
        return a;
    }

    private int[] merge_aux;

    @Answer
    //归并排序
    public int[] mergeSort(int[] a) {
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
            else if(merge_aux[j] < merge_aux[i]) a[k++] = merge_aux[j++];
            else a[k++] = merge_aux[i++];
        }
    }

    //快速排序
    private int[] quickSort(int[] a) {
        return a;
    }
}
