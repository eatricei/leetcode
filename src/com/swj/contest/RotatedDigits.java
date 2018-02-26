package com.swj.contest;

/**
 * 788. Rotated Digits
 * @author swj
 * @date 2018/2/26
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        a:
        for (int i = 1; i <= N; i ++){
            char[] s = Integer.valueOf(i).toString().toCharArray();
            for (int j = 0; j < s.length; j ++) {
                char ch = s[j];
                if (ch == '0' || ch == '1' || ch == '8') {
                    continue;
                } else if (ch == '2') {
                    s[j] = '5';
                } else if (ch == '5') {
                    s[j] = '2';
                } else if (ch == '6') {
                    s[j] = '9';
                } else if (ch == '9') {
                    s[j] = '6';
                } else {
                    continue a;
                }
            }
            if (i != Integer.decode(new String(s))){
                count ++;
            }
        }
        return count;
    }

    public int rotatedDigitsDP(int N){
        int count = 0;
        for (int i = 1;i <= N; i ++){
            if (isValid(i)){
                count ++;
            }
        }
        return count;
    }

    private boolean isValid(int N){
        boolean validFound = false;
        while (N > 0){
            switch (N % 10){
                case 2:
                case 5:
                case 6:
                case 9:validFound = true; break;
                case 3:
                case 4:
                case 7:return false;
            }
            N = N / 10;
        }
        return validFound;
    }
    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(10));
        System.out.println(new RotatedDigits().rotatedDigitsDP(10));
    }
}
