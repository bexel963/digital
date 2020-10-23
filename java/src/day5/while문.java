package day5;

import java.util.Scanner;

public class while문 {

	public static void main(String[] args) {
		/* while(조건식) {
		 * 		실행문;
		 * }
		 * 
		 * 초기화;
		 * while(조건식) {		-> while문은 for문과 다르게 조건식 생략 불가능.
		 * 		실행문;			-> for문에서 continue 만나면 증감식으로 스킵하지만, while문에서는 조건식으로 스킵한다.
		 * 		증감식;
		 * }
		 * 
		 * - for문은 차례대로 증가하는 경우 => 증감연산식이 꼭 필요한 경우 사용
		 * - while문은 입력받은 값을 이용하여 반복문을 유지하는 경우
		 * */
		
		for( int i=1 ; i<=5 ; i++ ) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		int j = 1;
		while( j<=5 ) {
			System.out.print(j + " ");
			j++;
		}
		
		System.out.println();
		
		j = 1;
		while(j<=5) {
			if(j%2 == 1) {
				j++;
				continue;
			}
			System.out.print(j + " ");
			j++;
		}
		
		System.out.println();
		
		int menu = -1;
		
		Scanner scan = new Scanner(System.in);
		
		while(menu != 4) {
			System.out.println("ㅡㅡㅡㅡ메뉴ㅡㅡㅡㅡ");
			System.out.println("1.불러오기");
			System.out.println("2.저장하기");
			System.out.println("3.실행하기");
			System.out.println("4.종료하기");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
		}
		System.out.println("프로그램 종료!!");
		scan.close();
		
	}

}
