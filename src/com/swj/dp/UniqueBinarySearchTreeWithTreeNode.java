package com.swj.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 95
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * @author swj
 * @date 2018/3/6
 */
public class UniqueBinarySearchTreeWithTreeNode {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1){
            return new LinkedList<>();
        }
        List<TreeNode>[][] dp = new List[n + 2][n + 2];
        return generateTree(1, n, dp);
    }

    /**
     * Divide and Conquer With DP
     * @param start 开始
     * @param end 结束
     * @return
     */
    private List<TreeNode> generateTree(int start, int end, List<TreeNode>[][] dp){
        if (dp[start][end] != null){
            return dp[start][end];
        }
        List<TreeNode> result = new LinkedList<>();
        if (start > end){
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i ++){
            List<TreeNode> left = generateTree(start, i - 1, dp);
            List<TreeNode> right = generateTree(i + 1, end, dp);
            for (TreeNode leftNode: left){
                for (TreeNode rightNode: right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        dp[start][end] = result;
        return result;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}