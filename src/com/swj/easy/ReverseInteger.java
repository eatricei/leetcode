package com.swj.easy;

public class ReverseInteger {
	public int reverse(int x){
		int result = 0;
		while(x!=0){
			int tail=x%10;
			int newResult = result*10+tail;
			if((newResult-tail)/10!=result){
				return 0;
			}
			result=newResult;
			x/=10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(-2147483648));
	}
}
