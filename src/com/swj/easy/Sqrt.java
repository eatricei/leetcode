package com.swj.easy;

/**
 * Compute and return the square root of x.
 * x is guaranteed to be a non-negative integer.
 * @author swj
 * @date 2018/2/27
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        while (true){
            int mid = left + (right - left) / 2;
            if (mid > x / mid){
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)){
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2147395599));
    }
}
