package com.swj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 300.Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * @author swj
 * @date 2018/3/26
 */
public class LongestIncreasingSubsequence {
    /**
     * O(n*log(n))
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums){
        int length = nums.length;
        int[] dp = new int[length];
        int res = 0;
        for (int x : nums){
            System.out.println(x);
            int i = Arrays.binarySearch(dp, 0, res, x);
            if (i<0){
                i = -(i+1);
            }
            dp[i] = x;
            if (i == res){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,4}));
    }
}
