package com.swj.dp;

import java.util.HashMap;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * @author swj
 * @date 2018/2/10
 */
public class RangeSumQueryImmutable {
    private final int[] temp;

    public RangeSumQueryImmutable(int[] nums){
        temp = nums;
        for (int i = 1; i < nums.length; i ++){
            temp[i] += nums[i - 1];
        }
    }
    public int sumRange(int i, int j){
        if (i == 0){
            return temp[j];
        }
        return temp[j] - temp[i - 1];
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable s = new RangeSumQueryImmutable(new int[]{1,2,3,4,5,6,7});
        System.out.println(s.sumRange(0,6));
    }
}
