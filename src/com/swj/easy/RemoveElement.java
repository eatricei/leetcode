package com.swj.easy;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author swj
 * @date 2018/2/7
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0;i < nums.length; i++){
            if (nums[i] != val){
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3,2,2,3},3));
    }
}
