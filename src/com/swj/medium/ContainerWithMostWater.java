package com.swj.medium;

import java.util.Arrays;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * @author swj
 * @create 2018/2/2
 */
public class ContainerWithMostWater {
    /**
     *  O(N^2)
     * @param height a1,a2....an
     * @return  max area
     */
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length;
        int maxArea = 0;
        for (int i = left; i<right-1;i++){
            for (int j= left+1;j<right;j++){
                int tmp = Math.min(height[i], height[j])*(j-i);
                if (tmp>maxArea){
                    maxArea = tmp;
                }
            }
        }
        return maxArea;
    }

    /**
     * O(N) two pointer approach
     * @param height
     * @return
     */
    public static int maxAreaN(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int tmp = 0;
        int h = 0;
        while (left != right){
            h = Math.min(height[left], height[right]);
            tmp = h * (right - left);
            if (tmp > maxArea){
                maxArea = tmp;
            }
            while (left != right && height[right] <= h){
                right --;
            }
            while (left != right && height[left] <= h){
                left ++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] i = new int[15000];
        for (int j = 0;j<15000;j++){
            i[j] = j+1;
        }
        System.out.println(Arrays.toString(i));
        System.out.println(maxAreaN(i));
    }
}
