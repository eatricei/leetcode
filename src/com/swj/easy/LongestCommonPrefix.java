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

    /**
     * 采用字典的数据结构
     * @param strings
     * @return
     */
    public static String longestCommonPrefixWithTrie(String[] strings) {
        StringBuilder result = new StringBuilder("");
        if (strings.length == 0){
            return "";
        }
        Trie trie = new Trie();
        String str = strings[0];
        for(String string:strings){
            if(string.length()< str.length()){
                str = string;
            }
            trie.insert(string);
        }
        return trie.searchLongestPrefix(str);
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
/*        System.out.println(longestCommonPrefix(new String[]{"aaa","aas"}));
        System.out.println(longestCommonPrefixWithDivide(new String[]{"aaa", "aas"}));
        System.out.println(longestCommonPrefixWithBinarySearch(new String[]{"aaa", "aas"}));*/
        System.out.println(longestCommonPrefixWithTrie(new String[]{"aaa", "aas"}));
        System.out.println(System.nanoTime()-start);
    }
}

/**
 * Given a set of keys S = [S1,S2…Sn]
 * You may assume that all inputs are consist of lowercase letters a-z
 *
 * find the longest common prefix among a string q and S. This LCP query will be called frequently.
 * We could optimize LCP queries by storing the set of keys S in a Trie.
 * For more information about Trie, please see this article Implement a trie (Prefix trie).
 * In a Trie, each node descending from the root represents a common prefix of some keys.
 * But we need to find the longest common prefix of a string q and all key strings.
 * This means that we have to find the deepest path from the root,
 * which satisfies the following conditions:
 * it is prefix of query string q each node along the path must contain only one child element.
 * Otherwise the found path will not be a common prefix among all strings.
 * * the path doesn't comprise of nodes which are marked as end of key.
 * Otherwise the path couldn't be a prefix a of key which is shorter than itself.
 *
 * https://leetcode.com/articles/implement-trie-prefix-tree/
 */
class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    private int size;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch -'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
        size ++;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getLinks(){
        return size;
    }

}

class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    /**
     *  Inserts a word into the trie.
     * @param word
     */
    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /**
     * search a prefix or whole key in trie and
     * returns the node where search ends
     * @param word
     * @return
     */
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     * @param word
     * @return
     */
    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     *  Returns if there is any word in the trie
     *  that starts with the given prefix.
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    /**
     *  search Longest Prefix
     * @param word
     * @return
     */
    public String searchLongestPrefix(String word){
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}