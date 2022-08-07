package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution11 {
    public int minArray(int[] numbers) {
        int lo = 0;
        int hi = numbers.length-1;
        while(lo <= hi) {
            int m = (lo+hi)/2;
            if(m+1>=numbers.length) break;
            if(numbers[m] > numbers[m+1]) return numbers[m+1];

            //要把相等的情况处理一下
            if(m<hi && numbers[m] == numbers[lo] && numbers[m] == numbers[hi]) {
                while(m < hi && numbers[m] == numbers[m+1]) m++;
                if(m==hi) {
                    m = (lo+hi)/2;
                    while(m > lo && numbers[m] == numbers[lo] && numbers[m] == numbers[hi]) m--;
                    if(m == lo) m = hi;
                }else if(numbers[m] > numbers[m+1]) return numbers[m+1];
            }
            if(numbers[m] <= numbers[lo] && numbers[m] <= numbers[hi]) hi = m-1;
            else if(numbers[m] >= numbers[lo] && numbers[m] >= numbers[hi]) lo = m+1;
            else break;
        }
        return numbers[0];
    }
}
