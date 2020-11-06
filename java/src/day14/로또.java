package day14;

import java.util.Scanner;

public class 로또 {

	public static void main(String[] args) {
		LottoManage lm = new LottoManage();
		char menu = '0';
		
		Scanner scan = new Scanner(System.in);
		
		do {
			lm.printMenu();
			menu = scan.next().charAt(0);
			
			switch(menu) {
			case '1': lm.luckyNumRegis(); break;	
			case '2': lm.lottoNumPrint(); break;		
			case '3': lm.luckyNumConfirm(); break;	
			case '4': lm.autoNumIssue(); break;
			case '5': lm.handNumIssue(); break;				
			case '6': break;
			default : lm.printAlert();
			}
		}while(menu != '6');
		lm.printExit();
		
		scan.close();

	}

}
