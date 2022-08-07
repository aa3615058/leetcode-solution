package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution13 {
    private boolean[][] flags;
    private int limit;
    private int count;

    public int movingCount(int m, int n, int k) {
        count = 0;
        limit = k;
        flags = new boolean[m][n];
        dfs(0,0);
        return count;
    }

    private void dfs(int i, int j) {
        flags[i][j]=true;
        if(((i < 10 ? i:i/10 + i%10)+(j < 10 ? j:j/10 + j%10))<=limit) {
            count++;
            if(i-1>=0 && !flags[i-1][j]) dfs(i-1,j);
            if(i+1<flags.length && !flags[i+1][j]) dfs(i+1,j);
            if(j-1>=0 && !flags[i][j-1]) dfs(i,j-1);
            if(j+1<flags[0].length && !flags[i][j+1]) dfs(i,j+1);
        }
    }
}
