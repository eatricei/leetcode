package com.swj.medium;

/**
 * 50.Implement pow(x, n).
 * @author swj
 * @date 2018/2/27
 */
public class Pow {
    public double myPow(double x, int n) {
        long temp = n;
        if (temp < 0){
            temp = -temp;
            x = 1/x;
        }
        double result = 1;
        double current = x;
        for (long i = temp; i > 0; i /= 2){
            if (i % 2 == 1){
                result *= current;
            }
            current *= current;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0,Integer.MIN_VALUE));
    }
}
