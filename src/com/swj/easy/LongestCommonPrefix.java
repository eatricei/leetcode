package com.swj.easy;

import java.util.stream.Stream;

/**
 * write a function to find the longest common prefix string amongst an array of strings
 * @author swj
 * @create 2018/2/2
 */
public class LongestCommonPrefix {
    /**
     *  土鳖法（自己第一反应想到的）
     *  O(S) , where S is the sum of all characters in all strings.
     * @param strings
     * @return
     */
    public static String longestCommonPrefix(String[] strings){
        StringBuilder result = new StringBuilder("");
        if (strings.length == 0){
            return "";
        }
        int min = 0;
        int tmp = 0;
        for (int i = 0; i < strings.length; i++){
            tmp = strings[i].length();
            if (tmp < strings[min].length()){
                min = i;
            }
            if (strings[i].isEmpty()){
                return "";
            }

        }
        int len = strings.length;
        for (int i = 0; i < strings[min].length(); i++){
            char temp = strings[min].charAt(i);
            for (String string: strings){
                if (string.charAt(i) != temp){
                    return result.toString();
                }
            }
            result.append(strings[min].charAt(i));
        }

        return result.toString();
    }

    /**
     * Divide and conquer
     * LCP(S​1​​…S​n​​)=LCP(LCP(S​1​​…S​k​​),LCP(S​k+1​​…S​n​​))
     * O(S), where S is the number of all characters in the array,
     * @param strs
     * @return
     */
    public static String longestCommonPrefixWithDivide(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        return  longestCommonPrefixWithDivide(0, strs.length - 1, strs);
    }
    public static String longestCommonPrefixWithDivide(int start, int end, String[] strs){
        if (start == end){
            return strs[start];
        }
        int mid = (start + end) / 2;
        String lcpLeft = longestCommonPrefixWithDivide(start, mid, strs);
        String lcpRight = longestCommonPrefixWithDivide(mid + 1, end, strs);
        return commonPrefix(lcpLeft, lcpRight);
    }
    public static String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++){
            if (left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }


    /**
     * Binary Search
     * O(S*log(N)) S is the sum of all characters in all strings.
     * @param strings
     * @return
     */
    public static String longestCommonPrefixWithBinarySearch(String[] strings){
        if (strings == null || strings.length == 0){
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (String string:strings){
          min = Math.min(min, string.length());
        }
        // low high 充当的是length 而不是索引
        int low = 1;
        int high = min;
        while (low <= high){
            int mid = (low + high) / 2;
            if (isCommonPrefix(strings, mid)){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return strings[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str = strs[0].substring(0, len);
        for (String string: strs){
            if (!string.startsWith(str)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        //System.out.println(longestCommonPrefix(new String[]{"aaa","aas"}));
       // System.out.println(longestCommonPrefixWithDivide(new String[]{"aaa", "aas"}));
        System.out.println(longestCommonPrefixWithBinarySearch(new String[]{"aaa", "aas"}));
        System.out.println(System.nanoTime()-start);
    }
}
