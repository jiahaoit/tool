package com.hao.junit;

public class GeneralMain {

	public static void main(String[] args) {
		int result = sum1(1, 2);
        System.out.println(result);
        int result2 = sum2(1,2,3);
        System.out.println(result2);
    }
 
    public static int sum1(int i, int j) {
        return i+j;
    }
     
    public static int sum2(int i, int j, int k) {
        return i+j+k;
    }
}
