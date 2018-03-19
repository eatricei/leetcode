package com.swj.dp;

import java.util.Arrays;

/**
 * 63. Unique Paths II
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * @author swj
 * @date 2018/3/19
 */
public class UniquePathsII {
    /**
     * new dp[n] = old dp[n] + new dp[n - 1];
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*int m = obstacleGrid.length;
        if (m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        boolean[][] temp = new boolean[m][n];
        for (int i = 0; i < m; i ++){
            if (obstacleGrid[i][0] == 1){
                break;
            }
            obstacleGrid[i][0] = 1;
            temp[i][0] = true;
        }
        for (int i = 1; i < n; i ++){
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            obstacleGrid[0][i] = 1;
            temp[0][i] = true;
        }
        for (int i = 1; i < m;i ++){
            for (int j = 1; j < n; j ++){
                if (obstacleGrid[i][j] == 1 || (!temp[i-1][j]&&!temp[i][j-1])){
                    continue;
                } else if (!temp[i-1][j]){
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (!temp[i][j-1]){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
                temp[i][j] = true;
            }
        }
        for (int[] i: obstacleGrid){
            System.out.println(Arrays.toString(i));
        }
        return obstacleGrid[m - 1][n - 1];*/

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid){
            for (int j = 0; j < width; j ++){
                if (row[j] == 1){
                    dp[j] = 0;
                }else if (j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0},{0}}));
    }
}
