package com.swj.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * @author swj
 * @date 2018/2/8
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i ++){
            if (target == nums[i]){
                return i;
            }
            if ((i == len - 1 && target > nums[i]) ||(target > nums[i] && target < nums[i + 1])){
                return i + 1;
            }
        }
        return 0;
    }
}
