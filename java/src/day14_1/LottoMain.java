package day14_1;

import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
		/*
		Lotto2 lotto = new Lotto2();
		lotto.randomLotto();
		System.out.println(lotto);
		
		int []arr = new int[] {1,2,3,4,5,6};			//로또번호 수동입력
		lotto.insertNumber(arr);
		System.out.println(lotto);
		
		System.out.println("-----------------");
		
		LottoE lotto2 = new LottoE();
		lotto2.randomLotto();
		System.out.println(lotto2);
		
		int []arr2 = new int[] {1,2,3,4,5,6,7};
		lotto2.insertNumber(arr2);
		System.out.println(lotto2);
		*/ //-------------------------------------------------> LottoManager만들기 전 테스트
		
		Scanner scan = new Scanner(System.in);
		LottoManager lm = new LottoManager();
		int menu = 0;
		do {
			lm.printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1: lm.createLotto(scan);	break;
			case 2:	lm.createLottoAuto();	break;
			case 3: lm.insertLotto(scan);	break;
			case 4:	lm.checkLotto();	break;
			case 5: lm.printLotto();	break;
			case 6: break;
			default:
				System.out.println("잘못된 메뉴!!!");
			}
		}while(menu != 6);
		lm.printString("프로그램 종료!!!");
	}
}
