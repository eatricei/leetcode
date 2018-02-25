package com.swj.dp;

import java.util.Arrays;

/**
 * Given a 2D matrix matrix,find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * @author swj
 * @date 2018/2/10
 */
public class RangeSumQuery2DImmutable {

    /*private final int[][] horizontal;

    public RangeSumQuery2DImmutable(int[][] matrix){
        horizontal = matrix;
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 1; j < matrix[i].length; j ++){
                horizontal[i][j] += matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i ++){
            if (col1 == 0){
                result += horizontal[i][col2];
            }else {
                result += horizontal[i][col2] - horizontal[i][col1 - 1];
            }
        }
        return result;
    }*/

    private  int[][] dp;
    public RangeSumQuery2DImmutable(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i ++){
            for (int j = 1; j <= n; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1 ] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
    public static void main(String[] args) {
        RangeSumQuery2DImmutable test = new RangeSumQuery2DImmutable(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(test.sumRegion(1, 2, 2, 4));
    }

}
