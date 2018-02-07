package com.swj.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author swj
 * @create 2018/2/7
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>(4);
        mapping.put('{', '}');mapping.put('[', ']');mapping.put('(', ')');
        for (int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }
        while (stack.size() > 0){
            char tmp = stack.pop();
            if (tmp == '}' || tmp == ']' || tmp == ')'){
                temp.push(tmp);
            } else if (tmp == '{' || tmp == '[' || tmp == '('){
                if ( temp.size() == 0 || !mapping.get(tmp).equals(temp.pop())) {
                    return false;
                }
            }
        }
        return temp.size() == 0;
    }

    public  boolean isValidNormal(String s){
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()){
            switch (c){
                case '{':
                case '[':
                case '(':
                    stack[head ++] = c;
                    break;
                case '}':
                    if (head == 0 || stack[-- head] != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if (head == 0 || stack[-- head] != '['){
                        return false;
                    }
                    break;
                case ')':
                    if (head == 0 || stack[-- head] != '(') {
                        return false;
                    }
                    break;
            }
        }
        return head == 0;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValidNormal("({})"));
    }
}
