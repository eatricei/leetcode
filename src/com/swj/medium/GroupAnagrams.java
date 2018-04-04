package com.swj.medium;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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
    /**
     * 
     * @param strs
     * @return
     */
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

    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsHire(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = String.valueOf(temp);
            if (map.get(tempStr) == null){
                map.put(tempStr, new ArrayList<>());
                map.get(tempStr).add(str);
            } else {
                map.get(tempStr).add(str);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

}
