package day7;

import java.util.Scanner;

public class 메소드3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//System.out.print("단 입력 : ");
		//int num = scan.nextInt();
		//printMulti(num);
		
		System.out.print("범위 입력 : ");
		int min = scan.nextInt();
		int max = scan.nextInt();
		
		System.out.println(rand(min, max));
		
		scan.close();

	}
	
	/* 기능 : 구구단 한단을 출력하는 메소드 
	 * 매개변수 : num
	 * 리턴타입 : void
	 * 메소드명 : printMulti
	 * */
	static void printMulti(int num) {
		
		for( int i=1 ; i<=9 ; i++ ) {
			System.out.println(num + " x " + i + " = " + num*i);
		}
		
	}
	
	/* 기능 : 원하는 범위의 랜덤 값을 알려주는 메소드
	 * 매개변수 : 원하는 정수 범위 => min부터 max까지 => int min, int max
	 * 리턴타입 : int
	 * 메소드명 : rand
	 * 
	 * */
	static int rand( int min, int max ) {
		
		int random = (int)(( max - min + 1 ) * Math.random() + min);
		
		return random;
	}
	
}




