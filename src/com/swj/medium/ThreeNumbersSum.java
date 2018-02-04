package com.swj.medium;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * @author swj
 * @create 2018/2/3
 */
public class ThreeNumbersSum {
    /**
     * sort first
     * 想办法把O(N^3)转换成O(N^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 2; i++){
            int j = i + 1;
            int k = len - 1;
            if (i == 0 || (i> 0 && nums[i] != nums[i - 1])){
                while (j < k){
                    int temp = nums[j] + nums[k] + nums[i];
                    if (temp == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]){
                            j ++;
                        }
                        while (j < k && nums[k] == nums[k - 1]){
                            k --;
                        }
                        j ++;
                        k --;
                    }else if (temp < 0){
                        while (j < k && nums[j] == nums[j + 1]){
                            j ++;
                        }
                        j ++;
                    }else{
                        while (j < k && nums[k] == nums[k - 1]){
                            k --;
                        }
                        k --;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}