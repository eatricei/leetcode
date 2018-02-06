package com.swj.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author swj
 * @create 2018/2/6
 */
public class LetterCombinationsOfPhoneNumber {
    /**
     * FIFO Queue
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        int len = digits.length();
        LinkedList<String> result = new LinkedList<>();
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (len == 0){
            return result;
        }
        result.add("");
        for (int i = 0; i < len; i ++){
            int x = digits.charAt(i) - '0';
            while (result.peek().length() == i){
                String tmp = result.remove();
                for (char s : mapping[x].toCharArray()){
                    result.add(tmp + s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
