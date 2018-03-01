package com.swj.dp;

import java.util.HashSet;

/**
 * 764.
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1,
 * except those cells in the given list mines which are 0.
 * What is the largest axis-aligned plus sign of 1s contained in the grid?
 * Return the order of the plus sign. If there is none, return 0.
 * @author swj
 * @date 2018/2/25
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        //存储被设为1的数
        HashSet<Integer> banned = new HashSet<>();
        for (int[] mine: mines){
            //保证每个位置对应唯一的数
            banned.add(mine[0] * N + mine[1]);
        }
        int count;
        int result = 0;
        for (int i = 0; i < N; i ++){
            count = 0;
            for (int j = 0; j < N; j ++){
                count = banned.contains(i * N + j) ? 0 : ++count;
                dp[i][j] = count;
            }
            count = 0;
            for (int j = N - 1; j >= 0; j --){
                count = banned.contains(i * N + j) ? 0 : ++count;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for (int i = 0; i < N; i ++){
            count = 0;
            for (int j = 0; j < N; j ++){
                count = banned.contains(j * N + i) ? 0 : ++count;
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            for (int j = N - 1; j >= 0; j --){
                count = banned.contains(j * N + i) ? 0 : ++count;
                dp[j][i] = Math.min(dp[j][i], count);
                result = Math.max(dp[j][i], result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LargestPlusSign().orderOfLargestPlusSign(10,new int[][]{}));
    }
}
