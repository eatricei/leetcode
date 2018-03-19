package com.swj.dp;

/**
 *  64. Minimum Path Sum
 *  Given a m x n grid filled with non-negative numbers,
 *  find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * @author swj
 * @date 2018/3/19
 */
public class MinimumPathSum {
    /**
     * dp方程dp[m][n] += min(dp[m-1][n],dp[m][n-1])
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i ++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i ++){
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 3, 1},{1, 5, 1},{4, 2, 1}}));
    }
}
