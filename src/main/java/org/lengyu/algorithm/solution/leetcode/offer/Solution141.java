package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution141 {
    public int cuttingRope(int n) {
        //核心思想：把n全部拆成3得到的结果最大
        //余数为0，直接乘就完事
        //余数为1，扣掉一个3变成两个2，因为2*2>3*1
        //余数为2，那就结尾乘2

        //数学思想：为什么拆成3乘积最大？
        //可以拓展到实数域讨论，假定绳子长度完全平均分配
        //再假定m可以是小数，而每段绳子的长度x也可以是小数
        //得到目标方程：f(x) = x^(n/x)，求导可知最大值点x=e
        //那么最佳长度不是3就是2，分别计算f(2)和f(3)，可知f(3)>f(2)
        //所以最佳长度就是3
        if(n == 2) return 1;
        if(n == 3) return 2;
        int rem = n%3;
        if(rem == 0) return (int)Math.pow(3,n/3);
        else if(rem == 2) return (int)Math.pow(3,n/3) * 2;
        else return (int)Math.pow(3,n/3-1) * 2 * 2;
    }
}
