package org.lengyu.algorithm.solution.leetcode.offer;
public class Solution60 {
    public double[] dicesProbability(int n) {        
        double[] res = new double[]{1,1,1,1,1,1};
        for(int j = 2; j <= n; j++) {
            double[] tmp = new double[5*j+1];
            double d = 0;
            for(int k = 0, l = 0; k <= (tmp.length-1)/2; k++,l++) {
                if(l-6 >= 0) d -= res[l-6];
                d += res[l];
                tmp[k] = d;
                tmp[tmp.length-1-k] = d;
            }
            res=tmp;
        }
        double total = Math.pow(6,n);
        for(int i = 0; i < res.length; i++) {
            res[i] = res[i] / total;
        }
        return res;
    }
}
