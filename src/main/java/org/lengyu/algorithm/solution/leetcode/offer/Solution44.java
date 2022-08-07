package org.lengyu.algorithm.solution.leetcode.offer;
import java.util.ArrayList;

public class Solution44 {
    private int[] listA = new int[]{10, 180, 2700, 36000, 450000, 5400000, 63000000, 720000000};
    private int[] listB = new int[]{10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890};

    public int findNthDigit(int n) {
        int digits = 9;
        for(int i = 0; i < listB.length; i++) {
            if(n < listB[i]) {
                digits = i+1;
                break;
            }
        }
        if(digits == 1) return n;
        int m = (n - listB[digits-2]) / digits + (int)Math.pow(10,digits-1);
        int j = digits - 1 - (n - listA[digits-2]) % digits;

        int result = m % 10;

        for(int i = 0; i < j; i++) {
            m/=10;
            result = m%10;
        }

        return result;
    }

    protected void calList() {
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        listA.add(10);
        listB.add(10);
        int i = 2;
        int p = 90;
        long sum = 10;
        while(true) {
            long r = (long)i*(long)p;
            sum += r;
            if(sum > Integer.MAX_VALUE) break;
            else {
                listA.add((int)r);
                listB.add((int)sum);
            }

            i++;
            p*=10;
        }
    }    
}
