package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution12 {
    /*public boolean exist(char[][] board, String word) {
        if(word == null || word.length()==0) return false;
        int m = board.length;
        int n = board[0].length;
        char c0 = word.charAt(0);
        LinkedList<SimpleEntry<Integer,Integer>> list = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n;j++) {
                if(board[i][j] == c0) list.add(new SimpleEntry<Integer,Integer>(i, j));
            }
        }

        while(!list.isEmpty()) {
            SimpleEntry<Integer,Integer> pair = list.poll();
            int p = pair.getKey();
            int q = pair.getValue();
            boolean[][] matrix = new boolean[m][n];
            
            int is = 1;
            while(is < word.length()) {
                char c1 = word.charAt(is);
                if(p-1>=0) 

                is++;
            }
        }

        return false;
    }*/

    private char[][] data;
    private boolean[][] flags;
    private char[] chars;
    private boolean res;

    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return false;
        data = board;
        flags = new boolean[board.length][board[0].length];
        chars = word.toCharArray();
        res = false;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!res) {
                    dfs(i,j,0);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, int k) {
        if(!res) {
            if(chars[k]==data[i][j]) {
                if(k == chars.length-1)  res = true;
                else {
                    flags[i][j]=true;
                    if(i-1>=0 && !flags[i-1][j]) dfs(i-1,j,k+1);
                    if(i+1<data.length && !flags[i+1][j]) dfs(i+1,j,k+1);
                    if(j-1>=0 && !flags[i][j-1]) dfs(i,j-1,k+1);
                    if(j+1<data[0].length && !flags[i][j+1]) dfs(i,j+1,k+1);
                    flags[i][j]=false;
                }
            }            
        }
    }
}
