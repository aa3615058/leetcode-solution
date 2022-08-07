package org.lengyu.algorithm.solution.leetcode.offer;

import org.lengyu.algorithm.Answer;

public class Solution65 {

    //更简洁的方法
    @Answer
    public int add(int a, int b) {
        while(b != 0) {
            //无进位加法
            int c = a ^ b;
            //产生的所有进位组合在一起的数
            b = (a & b) << 1;
            a = c;
            //注意，此时 a 和 b 的值尽管都已改变，但它们的和仍然不变
            //继续迭代，因为一直左移，b最后会变成0，退出循环
        }
        return a;
    }

    //补码：负数的补码按位取反后+1
    //之所以这样设计补码就是为了无障碍进入加法器，符号位也无需特殊处理
    //模拟 CPU 全加器
    public int addB(int a, int b) {
        int A0,B0;
        int C0 = 0;
        int D0 = 0;
        int base = 1;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            A0 = a & 1;
            B0 = b & 1;
            D0 = A0 ^ B0;
            if((D0 ^ C0) == 1) res |= base;
            C0 = (A0 & B0) | (D0 & C0);
            a >>= 1;
            b >>= 1;
            base <<= 1;
        }
        return res;
    }
}
