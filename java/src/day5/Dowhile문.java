package day5;

import java.util.Scanner;

public class Dowhile문 {

	public static void main(String[] args) {
		
		/* - for문과 while문은 조건식에 따라 한번도 실행되지 않을 수 있다.
		 * 
		 * do{
		 * 		실행문;
		 * }while(조건식);	-> 세미콜론 필수
		 * 
		 * - do while문은 조건식이 거짓이어도 무조건 1번은 실행된다. (잘 안쓰임)
		 * */
		
		int i = 1;
		for( ; i==0 ; ) {
			System.out.println(1);
		}
		
		do {
			System.out.println(2);
		}while(1==0);

		System.out.println();
		System.out.println();
		
		///////////////////////////////////////////////////////////////////
		
		int menu = 4;
		
		Scanner scan = new Scanner(System.in);
		
		 do{
			System.out.println("ㅡㅡㅡㅡ메뉴ㅡㅡㅡㅡ");
			System.out.println("1.불러오기");
			System.out.println("2.저장하기");
			System.out.println("3.실행하기");
			System.out.println("4.종료하기");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
		}while(menu != 4);
		System.out.println("프로그램 종료!!");
		scan.close();
	}

}
