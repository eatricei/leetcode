package com.swj.medium;

/**
 * 372. Super Pow
 * Your task is to calculate ab mod 1337 where a is a positive integer
 * and b is an extremely large positive integer given in the form of an array.
 * @author swj
 * @date 2018/2/27
 */
public class SuperPow {
    private static final int mod = 1337;
    public int pow(int a, long b){
        a %= mod;
        int result = 1;
        while (b != 0){
            if ((b & 1) != 0){
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }
    public int superPow(int a, int[] b) {
        if (a % mod == 0){
            return 0;
        }
        int p = 0;
        for (int i : b){
            p = (p * 10 + i) % 1140;
        }
        if (p == 0){
            p += 1140;
        }
        return pow(a, p);
    }

    public static void main(String[] args) {
        System.out.println(new SuperPow().superPow(2147483647, new int[]{2,0,0}));
    }
}
