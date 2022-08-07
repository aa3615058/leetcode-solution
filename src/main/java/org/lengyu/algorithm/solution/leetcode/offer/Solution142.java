package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution142 {

    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int rem = n % 3;
        int p = 0;
        int t = 0;//p是3的次方数，t是2的次方数
        int base = 1000000007;
        if(rem == 0) p = n/3;
        else if(rem == 2) {
            p = n/3;
            t = 1;
        }
        else {
            p = n/3-1;
            t = 2;
        }

        //乘积结果可能巨大，比如n=900，3的300次方远超long的范围
        //利用余数的三个基本定理做：加法，乘法，乘方（形式相同）
        //这里用到的是乘方
        
        //3的19次方才开始比base大，每19次方计算一次可以减少计算量
        //一个base19就是一个3的19次方取余的结果
        int p19 = p/19;
        int r19 = p-19*p19;
        int base19 = (int)Math.pow(3,19)-base;

        //两个base19相乘的结果就已经远超base了，所以要用long，乘完就取余
        long result = 1;
        for(int i = 0; i < p19; i++) {
            result *= base19;
            result %= base;
        }
        result *= (int)Math.pow(3, r19);
        result %= base;
        //把后面的几个2乘上
        if(t > 0) result *= (long)Math.pow(2,t);
        result %= base;

        return (int)result;

/*      long result = 1;
        int temp = 1;

        for(int i = 0; i < p; i++) {
            temp *= 3;
            if(temp > base) {
                result *= temp%base;
                if(result > base) result = result%base;
                temp = 1;
            }
        }
        
        if(temp > 1) result *= temp%base;
        if(t > 0)result *= 2*t;
        result = result%base;

        return (int)result;
*/
    }    
}
