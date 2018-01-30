package com.swj.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {
	/**
	 * time limit exceeded  n^3
	public String longestPalindrome(String s){
		String result="";
		if(s.length()<2){
			return s;
		}
		StringBuilder tmp = new StringBuilder();
		int j=0;
		while(j<s.length()-result.length()){
			for(int i=j;i<s.length();i++){
				tmp.append(s.charAt(i));
				if(tmp.length()>result.length()){
					if(isPalindrome(tmp)){
						result=tmp.toString();
					}
				}
			}
			tmp=new StringBuilder("");
			j++;
		}
		return result;
	}

	public boolean isPalindrome(StringBuilder s){
		int a = s.length();
		int tmp = 0;
		while(tmp<a/2){
			if(s.charAt(tmp)!=s.charAt(a-tmp-1)){
				return false;
			}
			tmp++;
		}
		return true;
	}*/

	private int lo, maxLen;
	/**
	 * Dynamic Programming
	 * define P(i,j) as following:
	 * if the substring S[i]...S[j] is a palindromic P(i,j)== true else false;
	 * P(i,j) = (P(i+1, j-1) and S[i] == S[j])
	 * @param s
	 * @return
     */
	public String longestPalindrome(String s){
		int length = s.length();
		if (length < 2)
			return s;
		for (int i = 0;i < length - 1; i++) {
			extendPalindrome(s, i, i); //回文数的length是奇数
			extendPalindrome(s, i ,i+1); //回文数length是偶数
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k){
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
}
