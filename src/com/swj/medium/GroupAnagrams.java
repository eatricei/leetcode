package com.swj.medium;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @author swj
 * @date 2018/3/30
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (String str: strs){
            char[]  t = str.toCharArray();
            Arrays.sort(t);
            String tmp = new String(t);
            if (temp.contains(tmp)){
                result.get(temp.indexOf(tmp)).add(str);
            } else {
                temp.add(tmp);
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
            }
        }
        return result;
    }
}
