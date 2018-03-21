package com.swj.easy;

/**
 * 263.Ugly Number
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * @author swj
 * @date 2018/3/21
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num <= 0){
            return false;
        }
        while (num != 1){
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0){
                num /= 3;
            } else if (num % 5 == 0){
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(Integer.MIN_VALUE));
    }
}
