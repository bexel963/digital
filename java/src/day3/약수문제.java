package day3;

import java.util.Scanner;

public class 약수문제 {

	public static void main(String[] args) {
		/* num를 입력받아 입력받은 num의 약수들을 출력하는 예제.
		 * 약수 : 나누어 떨어지는수
		 * 12의 양수 : 1 2 3 4 6 12 
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 	- 초기화 : i는 1부터
		 * 	- 조건식 : i는 num까지
		 * 	- 증감연산식 : i는 1씩 증가
		 * 규칙성 : i가 num의 약수이면 i를 출력 => num를 i로 나누었을 때 나머지가 0과 같다면 i를 출력
		 * 반복문 종료후 : 없음
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int i, num;
		int count = 0;
		
		System.out.print("수를 입력 하세요 : ");
		num = scan.nextInt();
		
		System.out.print(num + "의 약수 : ");
		
		for( i = 1 ; i <= num ; i++ ) {
			if( num % i == 0) {
				System.out.print(i + " ");
			}
		}	
		System.out.println();
		
		System.out.print("수를 입력 하세요 : ");
		num = scan.nextInt();
		
		for( i = 1 ; i <= num ; i++) {
			if( num % i == 0) {
				count = count +1;
			}
		}
			if( count == 2 ) {
				System.out.println(num + "은 소수");
			}else {
				System.out.println(num + "은 소수 아님");
			}

	}
		
	
}
