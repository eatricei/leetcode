package com.swj.medium;

import java.util.Arrays;

/**
 * 34. Search for a Range
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * @author swj
 * @date 2018/4/4
 */
public class SearchForRange {
    /**
     * Binary Search
     * @param number
     * @param target
     * @return
     */
    public int[] searchRange(int[] number, int target){
        int len = number.length;
        if (len == 0){
            return new int[]{-1, -1};
        }
        int temp = searchRange(number, target, 0, len - 1);
        if (temp == -1){
            return new int[]{-1, -1};
        }
        int left = temp ,right = temp;
        while (number[left - 1] == target){
            left -- ;
        }
        while (number[right + 1] == target){
            right ++;
        }
        return new int[]{left, right};
    }

    private int searchRange(int[] number, int target, int start, int end){
        if (start == end){
            if (number[start] == target){
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if (number[mid] > target){
            return searchRange(number, target,start, mid - 1);
        } else if (number[mid] < target){
            return searchRange(number, target, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
