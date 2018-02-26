package com.swj.contest;

import java.util.HashSet;

/**
 * 791. Custom Sort String
 * @author swj
 * @date 2018/2/26
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int temp = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length; i ++){
            for (int j = 0;j < t.length; j ++){
                if (s[i] == t[j]){
                    char tmp = t[j];
                    t[j] = t[temp];
                    t[temp] = tmp;
                    temp ++;
                    set.add(tmp);
                }
            }
        }
        if (set.size() == s.length){
            return new String(t);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("kqep", "pekeq"));
    }
}
