package com.swj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * @author swj
 * @date 2018/3/30
 */
public class PerfectSquares {
    public static ArrayList<Integer> dp = new ArrayList<>();
    static {
        dp.add(0);
    }

    /**
     * dp思想：取这个数减去各个平方数的结果最小值
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (dp.size() > n){
            return dp.get(n);
        }
        for (int i = dp.size(); i <= n; i ++){
            int temp = Integer.MAX_VALUE;
            int j = 1;
            while (i >= j*j){
                temp = Math.min(temp, dp.get(i - j * j) + 1);
                j ++;
            }
            dp.add(temp);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
}
