package com.swj.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author swj
 * @date 2018/2/10
 */
public class ClimbingStairs {

    /**
     * 动态规划方程
     * f(n) = f(n - 1) + f(n - 2) 就是斐波那契数列
     * @param n
     * @return
     */
    public int climbStairs(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int one = 1;
        int two = 2;
        int result = 0;
        int i = 2;
        while (i < n){
            result = one + two;
            one = two;
            two = result;
            i ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(21));
    }
}
