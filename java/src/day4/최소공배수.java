package day4;

import java.util.Scanner;

public class 최소공배수 {

	public static void main(String[] args) {
		/* 두 정수 num1과 num2를 입력받아 두 정수의 최소 공배수를 출력하는 예제
		 * 공배수는 두 정수에 공통으로 있는 배수
		 * 최소 공배수는 공배수 중 가장 작은 배수
		 * 10의 배수 : 10 20 30 40 50 60 70 80 90 .....
		 * 15의 배수 : 15 30 45 60 75 90 105 120 .....
		 * 10과 15의 공배수 : 30 60 90 .....
		 * 10과 15의 최소 공배수 : 30
		 * 	- 반복횟수 : i는 num1부터 시작해서 계속하고, i는 num1만큼 증가
		 * 	- 규칙성 : i가 num1의 배수이고, i가 num2의 배수이면 i를 출력 후 반복문 종료. 
		 * 		=> i를 num1으로 나누었을 때 나머지가 0과 같고 i를 num2로 나누었을 때 나머지가 0과 같다면 i를 출력 후 반복문 종료.
		 * */
	
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.print("두 정수를 입력 하세요 : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		for( int i=num1 ; ; i+=num1 ) {
			if( i % num1 == 0 && i % num2 == 0 ) {
				System.out.println( num1 + "과 " + num2 + "의 최소 공배수는 " + i + "이다. " );
				break;
			}
		}
		
		
		
	}

}
