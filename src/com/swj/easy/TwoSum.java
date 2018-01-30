package com.swj.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/**
	 * 蛮力 O(n^2)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		int[] answer = new int[2];
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(nums[i]+nums[j]==target){
					answer[0]=i;
					answer[1]=j;
					return answer;
				}
			}
		}
		        return answer;
		}
	 public static int[] twoSumT(int[] nums,int target){
		 Map<Integer,Integer> map = new HashMap<>();
		 for(int i=0;i<nums.length;i++){
			 map.put(nums[i], i);
		 }
		 for(int i=0;i<nums.length;i++){
			 int complement = target-nums[i];
			 if(map.containsKey(complement)&&map.get(complement)!=i){
				 return new int[]{i,map.get(complement)};
			 }
		 }
		 return new int[2];
	 }
	 public static int[] twoSumS(int[] nums, int target){
		 Map<Integer,Integer> map = new HashMap<>();
		 for(int i=0;i<nums.length;i++){
			 int complement = target-nums[i];
			 if(map.containsKey(complement)){
				 return new int[]{map.get(complement),i};
			 }
			 map.put(nums[i], i);
		 }
		 return new int[2];
	 }
	public static void main(String[] args) {
//		int[] answer = new TwoSum().twoSum(new int[]{11,15,2,7}, 9);
//		System.out.println(Arrays.toString(answer));
		int[] answer = twoSumT(new int[]{11,15,5,5}, 10);
		System.out.println(Arrays.toString(answer));
//		int[] answer = twoSumS(new int[]{11,15,5,5}, 10);
	//	System.out.println(Arrays.toString(answer));
		
	}

}
