package com.swj.dp;

import java.util.Arrays;

/**
 * 338.counting bits
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * @author swj
 * @date 2018/3/9
 */
public class CountingBits {
    public int[] countBits(int num){
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++){
            if ((i & 1) == 1){
                dp[i] = dp[i >> 1] + 1;
            } else {
                dp[i] = dp[i >> 1];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
    }
}
