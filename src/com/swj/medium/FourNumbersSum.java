package com.swj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * @author swj
 * @create 2018/2/6
 */
public class FourNumbersSum {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (len < 4){
            return result;
        }
        for (int i = 0; i < len - 3; i ++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j ++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if(nums[i]+nums[j]+nums[len-2]+nums[len-1]<target){
                    continue;
                }
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int k = j + 1;int l = len - 1;
                while (k < l){
                    int temp = nums[i] + nums[j] + nums[k] + nums[l];
                    if (temp == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k+1]){
                            k ++;
                        }
                        while (k < l && nums[l] == nums[l - 1 ]){
                            l --;
                        }
                        k ++;
                        l --;
                    }else if (temp < target){
                        while (k < l && nums[k] == nums[k+1]){
                            k ++;
                        }
                        k ++;
                    }else {
                        while (k < l && nums[l] == nums[l - 1 ]){
                            l --;
                        }
                        l --;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FourNumbersSum().fourSum(new int[]{5,5,5,5,5,5,5,5,5,5,5,5,6,5,5,5,5,5,5,5,5,5,5,5,5,7,5,5,5,5,5,5,5,5,5,5}, 23));
    }
}
