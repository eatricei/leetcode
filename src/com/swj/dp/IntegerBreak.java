package com.swj.dp;

import java.util.List;

/**
 * 343. Integer Break
 * Given a positive integer n,
 * break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * @author swj
 * @date 2018/4/4
 */
public class IntegerBreak {

    public static final int[] dp = new int[58];

    /**
     * traditional thinking
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 3; i <= n; i ++){
            for (int j = 2; j < i - 1; j ++){
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    /**
     * x^(n/x)的最大值的x为e
     * @param n
     * @return
     */
    public int integerBreakMath(int n){
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int result = 1;
        while (n > 4){
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreakMath(10));
    }
}
