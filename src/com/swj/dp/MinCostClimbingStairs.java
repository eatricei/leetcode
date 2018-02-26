package com.swj.dp;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 * @author swj
 * @date 2018/2/10
 */
public class MinCostClimbingStairs {

    /**
     * 动态规划方程f(i) = cost[i] + min(f[i+1], f[i+2])
     * f2,f1用于记录f[i+1] f[i+2]
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost){
        int f2 = 0, f1 = 0, f0 = 0;
        for (int i = cost.length - 1; i >= 0; i --){
            f0 = cost[i] + Math.min(f2, f1);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f2, f1);
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
