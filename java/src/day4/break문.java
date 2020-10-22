package day4;

import java.util.Scanner;

public class break문 {

	public static void main(String[] args) {
		/* break : 반복문을 빠져 나오게 하는 키워드
		 * 	- 반복문에서 break는 반드시 조건문(if문)을 동반한다.
		 * 	- break를 만나면 반복문을 빠져나감.
		 * */
		
		/*
		int i;
		for( i=1 ; ; i++ ) { 				// 조건문이 없으면 항상 참.
			System.out.println(i);
			if( i==10 ) {
			break;
			}
		}
		
		Scanner scan = new Scanner(System.in);
		
		char ch;
		for( ; ; ) {
			System.out.print("문자를 입력하세요(종료하려면 y나 Y를 입력하세요) : " );
			ch = scan.next().charAt(0);				// 문자열 중 첫번째 문자 입력
			if( ch == 'y' || ch == 'Y' ) {
				break;
			}
		}
	
		scan.close();
		*/
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		/* 두 정수 num1과 num2를 입력받고 두 정수의 최대 공약수를 출력하는 예제
		 * 공약수 : 두 정수의 공통으로 있는 약수
		 * 최대 공약수 : 두 정수의 공약수중 가장 큰수
		 * 8과 12의 공약수 : 4 2 1
		 * 8과 12의 공약수 : 4
		 * - 반복횟수 : i는 num1부터 1까지 
		 * - 규칙성 : i가 num1과 num2의 공약수이면 i를 출력 후 반복문 종료
		 * 		=> num1을 i로 나누었을 때 나머지가 0과 같고
		 * 		=> num2를 i로 나누었을 때 나머지가 0과 같다면
		 * 		   i를 출력 후 반복문 종료
		 * - 반복문 종료 후 : 없음 */
       
		Scanner scan = new Scanner(System.in);	
		
		int num1, num2, gcd=0;
		
		System.out.print("두 정수를 입력 하세요 : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		for( int i = num1 ;  ; i-- ) {
			if( num1 % i == 0 && num2 % i ==0 ) { 
				System.out.print(num1 + "과 " + num2 + "의 최대 공약수는 " + i + "이다. ");
				break;
			}
		}
		
		

	}

}
