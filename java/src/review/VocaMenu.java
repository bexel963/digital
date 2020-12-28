package review;

import java.util.Scanner;

import day13.StudentManager;

public class VocaMenu {

	public static void main(String[] args) {
		/* 단어장 프로그램을 작성하세요.
		 * 1. 단어 등록
		 * 2. 단어 검색
		 * 3. 단어 수정
		 * 4. 단어 출력
		 * 5. 종료
		 * 
		 * */
		Voca v = new Voca();
		char menu = '0';
		
		Scanner scan = new Scanner(System.in);
		
		do {
			v.printMenu();
			menu = scan.next().charAt(0);
			
			switch(menu) {
			case '1': v.registration(); break;	
			case '2': v.search(); break;		
			case '3': v.amend(); break;	
			case '4': v.print(); break;			
			case '5': break;
			default : v.printAlert();
			}
		}while(menu != '5');
		v.printExit();
		
		scan.close();
	}
	
}
