package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution431 {
    public int countDigitOne(int n) {
        int result = 0;
        int p = 1;
        int m = n;
        while(m > 0) {
            //这种求a的方法不会溢出
            //如果直接使用10的次方求余，中间结果会溢出
            int a = m%10;
            int prefix = m/10;
            int surfix = p;
            
            if(a == 0) result += prefix * surfix;
            else if(a == 1) result += prefix * surfix + (n - m*p + 1);
            else result += (prefix+1) * surfix;

            m=m/10;
            p=p*10;
        }
        return result;
    }
}
