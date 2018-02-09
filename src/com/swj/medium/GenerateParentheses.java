package com.swj.medium;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * @author swj
 * @date 2018/2/7
 */
public class GenerateParentheses {
    private static final Map<Integer, List<String>> mapping = new HashMap<>();
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i ++){
           for (int j = n - i; j < n; j ++){
               if (mapping.get(Integer.valueOf(j)) == null){
                   mapping.put(Integer.valueOf(j), generateParenthesis(n));
               }

           }
       }
        return list;
    }

    /**
     * 递归求解
     * Time Complexity:O(2^2n * n)
     * Space Complexity:O(2^2n * n)
     * 对每一种情况都需要验证 验证需要n 对于n 有2^2n种情况
     * @param n
     * @return
     */
    public List<String> generateParenthesisWithRecurs(int n){
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    /**
     * 递归主函数
     * @param current
     * @param pos
     * @param result
     */
    private void generateAll(char[] current, int pos, List<String> result){
        if (pos == current.length){
            if (valid(current)){
                result.add(new String(current));
            }
        }else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 验证一个字符数组是否是有效的括号集
     * @param current
     * @return
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '('){
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

    /**
     * 回溯
     * O(4^n/根号n)
     * @param n
     * @return
     */
    public List<String> generateParenthesesWithBacktracking(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2){
            ans.add(cur);
            return;
        }

        if (open < max){
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open){
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

    /**
     * closure number
     * To enumerate something, generally we would like to express it as a sum of disjoint subsets that are easier to count.
     * @param n
     * @return
     */
    public List<String> generateParenthesesWithClosure(int n){
        List<String> ans = new ArrayList<>();
        if (n == 0){
            ans.add("");
        } else {
            for (int c = 0; c < n; c++){
                for (String left: generateParenthesesWithClosure(c)){
                    for (String right: generateParenthesesWithClosure(n - 1 - c)){
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesisWithRecurs(3));
    }
}
