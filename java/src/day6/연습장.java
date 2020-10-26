package day6;

import java.util.*;

public class 연습장 {

	public static void main(String[] args) {
		
		char[] abc = { 'A', 'B', 'C', 'D' };
		int[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		System.out.println(abc);
		System.out.println(num);
		System.out.println(Arrays.toString(num));
		
		System.out.println();
		
		/*
		char[] result = new char[ abc.length + num.length ];
		System.arraycopy( abc, 0, result, 0, abc.length );
		System.arraycopy( num, 0, result, abc.length, num.length );
		System.out.println(result);
*/
	}

}
