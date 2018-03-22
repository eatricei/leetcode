package com.swj.dp;

import java.util.ArrayList;

/**
 * 264. Ugly Number II
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 * @author swj
 * @date 2018/3/21
 */
public class UglyNumberII {

    /**
     * dp方程:下一个数是取的最小的
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 1){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int temp2 = 0,temp3 = 0, temp5 = 0;
        for (int i = 1; i < n; i ++){
            dp[i] = Math.min(dp[temp2] * 2, Math.min(dp[temp3] * 3, dp[temp5] * 5));
            if (dp[i] == dp[temp2] * 2){
                temp2 ++;
            }
            if (dp[i] == dp[temp3] * 3){
                temp3 ++;
            }
            if (dp[i] == dp[temp5] * 5){
                temp5 ++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }

}
