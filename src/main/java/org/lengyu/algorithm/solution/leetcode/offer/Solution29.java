package org.lengyu.algorithm.solution.leetcode.offer;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        if(matrix[0].length == 0) return new int[0];
        int m = matrix[0].length;
        int n = matrix.length;
        int[] result = new int[m*n];
        
        int left = 0;
        int right = m-1;
        int up = 0;
        int down = n-1;
        int i = 0;

        while(i < result.length) {
            if(up <= down) {
                for(int j = left; j <= right; j++) {
                    result[i++]=matrix[up][j];
                }
                up++;
            }
            if(left <= right) {
                for(int j = up; j <= down; j++) {
                    result[i++]=matrix[j][right];
                }
                right--;
            }
            if(up <= down) {
                for(int j = right; j >= left; j--) {
                    result[i++]=matrix[down][j];
                }
                down--;
            }
            if(left <= right) {
                for(int j = down; j >= up; j--) {
                    result[i++]=matrix[j][left];
                }
                left++;
            }
        }
        
        return result;
    }
}