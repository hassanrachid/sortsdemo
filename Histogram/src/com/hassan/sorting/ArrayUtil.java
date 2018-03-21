package com.hassan.sorting;

public class ArrayUtil {

	public static int [] randomIntArray(int length){
		int [] a = new int[length];
		for (int i = 0; i < a.length; ++i){
			a[i] = (int)(Math.random() * 1000);
		}
		return a;
	}

}
