package com.swj.medium;


public class LongestPalindromicSubstring {
	/*public String longestPalindrome(String s){
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
	*/
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
	}
	
	public String longestPalindrome(String s){
		//TODO 将这个字符串反转 求这两个字符串的最长公共子串
		return "";
	} 
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("abc"));
	}
}
