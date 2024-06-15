package com.mystore.testcases;

public class StepChecking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {2,2,3,4,4};
		multiplyBy(array,3);
		int average=getAverage(array);
		System.out.println(average);

	}
	
	public static void multiplyBy(int[] array,int multiplier) {
		for(int i=0;i<array.length;i++) {
			array[i]*=multiplier;
		}
	} 

	public static int getAverage(int[] array) {
		
		int total=0;
		for(int num:array) {
			total+=num;
		}
		int average=total/array.length;
		return average;
		
	}
}
