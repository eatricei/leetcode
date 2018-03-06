package com.swj.dp;

/**
 * 96. Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * @author swj
 * @date 2018/3/6
 */
public class UniqueBinarySearchTree {
    /**
     * 先确定顶点 【1,2,3...n】 选一个做根节点 所有情况下左边的数组能组成的unique BST数量乘上右边的情况的总和就是
     * 所有唯一的unique BST
     * dp方程 G(n) = G(0)*G(n-1)+G(1)*G(n-2)+....G(n-1)*G(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++){
            for (int j = 0; j < i; j ++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTree().numTrees(0));
    }
}
