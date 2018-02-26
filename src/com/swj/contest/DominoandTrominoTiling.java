package com.swj.contest;

/**
 * 790. Domino and Tromino Tiling
 * 动态规划 列出状态转移方程为dp[n] = dp[n-1]*2 + dp[n-3]
 * @author swj
 * @date 2018/2/26
 */
public class DominoAndTrominoTiling {
    private static final int mod = 1000000007;
    public int numTilings(int N) {
        int[] dp = new int[N + 2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++){
            dp[i] = (dp[i - 1] * 2 % mod + dp[i - 3] % mod) % mod;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new DominoAndTrominoTiling().numTilings(30));
    }
}
