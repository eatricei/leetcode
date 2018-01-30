package com.swj.hard;


public class MedianOfTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1=nums1.length;
		int length2=nums2.length;
		int m=0,n=0;
		int sum=0;
		int index1 = (length1+length2)%2==0?(length1+length2)/2-1:(length1+length2)/2;
		int index2 = (length1+length2)%2==0?index1+1:index1;
		while(m<length1||n<length2){
			int val=0;
			if(m==length1){
				val=nums2[n];		
				n++;
			}else if(n==length2){
				val=nums1[m];		
				m++;
			}else if(nums1[m]>nums2[n]){
				val=nums2[n];				
				n++;
			}else{
				val=nums1[m];				
				m++;
			}
			if(m+n-1==index1){
				sum+=val;
			}
			if(m+n-1==index2){
				sum+=val;
				break;
			}
		}
		
		return sum/2.0;
       
    }
	
	public static void main(String[] args) {
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{4,5,6,8,9}, new int[0]));
	}
}
