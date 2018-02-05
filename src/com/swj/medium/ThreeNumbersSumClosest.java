package com.swj.medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * @author swj
 * @create 2018/2/5
 */
public class ThreeNumbersSumClosest {
    /**
     * 思路和threeNumbersSum一样 多了些细节
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        int distance = Math.abs(result - target);
        for(int i = 0; i < len - 2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int j = i + 1;
                int k = len - 1;
                while(j < k){
                    int tmp = nums[i] + nums[j] + nums[k];
                    int temp = Math.abs(tmp - target);
                    boolean isCloser = (temp - distance < 0);
                    if (!isCloser){
                        if (tmp > target){
                            while (j < k && nums[k] == nums[k - 1]){
                                k --;
                            }
                            k --;
                        }
                        if (tmp < target){
                            while (j < k && nums[j] == nums[j + 1]){
                                j ++;
                            }
                            j ++;
                        }
                        if (tmp == target){
                            return target;
                        }
                        continue;
                    }else {
                        result = tmp;
                        distance = temp;
                    }
                    if (temp == 0){
                        return tmp;
                    }else if (tmp > target){
                        while (j < k && nums[k] == nums[k - 1]){
                            k --;
                        }
                        k --;
                    }else {
                        while (j < k && nums[j] == nums[j + 1]){
                            j ++;
                        }
                        j ++;
                    }

                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,1,2}, 3));
    }
}
