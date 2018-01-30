package com.swj.medium;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LongSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		char[] arr = s.toCharArray();
		LinkedList<Character> list = new LinkedList<>();
		int size = 0;
		int temp = 0;
		for(int i=0;i<arr.length;i++){
			if(list.contains(arr[i])){
				int j = list.indexOf(arr[i]);
				for(;j>=0;j--){
					System.out.println(j);
					list.remove(0);
				}
				temp=list.size();
			}
			list.add(arr[i]);
			temp++;
			if(temp>size){
				size=temp;
			}
		}
		return size;
    }
	
	public static int lengthOfLongestSubstringS(String s){
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0,i = 0,j = 0;
		while(i<n&&j<n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans=Math.max(ans, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
	
	public static int lengthOfLongestSubstringT(String s){
		int n = s.length(),ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int j=0,i=0;j<n;j++){
			if(map.containsKey(s.charAt(j))){
				i=Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringT("abcabcabcc"));
	}
}
