package com.swj.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space
 * @author swj
 * @create 2018/1/30
 */
public class PalindromeNumber {
    /**
     * 第几次循环 rev = 原x的后几位 x则是每次删去最后一位 对x有奇数位还是偶数位有不同的处理
     * @param x
     * @return
     */
    public boolean isPalindrome(int x){
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev/10);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(123454321));
    }
}
