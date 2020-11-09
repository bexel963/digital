package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MapEx3 {

	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 한 학생의 정석을 관리하는 프로그램을 작성하세요.
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회(전체)
		 * 3. 학생 성적 조회(과목)
		 * 4. 학생 성적 수정
		 * 5. 프로그램 종료
		 * 
		 * */
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		Scanner scan = new Scanner(System.in);
		
		
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1: gradeInsert(scan, map); break;
			case 2:	allSearch(map); break;
			case 3: subSearch(scan, map); break;
			case 4:	gradeAmend(scan, map); break;							// 과목과 성적을 입력받고, 입력받은 성적으로 수정
			case 5: break;
			default:
				System.out.println("잘못된 메뉴!!!");
			}
		}while(menu != 5);
		System.out.println("프로그램 종료");
	
	}
	
	public static void gradeInsert(Scanner scan, HashMap<String, Integer> map) {
		System.out.print("과목, 점수를 입력하세요 : ");
		map.put(scan.next(),  scan.nextInt());
	
	}
	
	public static void allSearch(HashMap<String, Integer> map) {
		
		Iterator<String> it = map.keySet().iterator();			
		while(it.hasNext()) {									
			String key = it.next();
			System.out.println(key + " : " + map.get(key));		
		
		}
	}
	
	public static void subSearch(Scanner scan, HashMap<String, Integer> map) {
		
		System.out.print("과목 선택 : ");
		String sub = scan.next();
		System.out.println(sub + " : " + map.get(sub));
		
	}
	
	public static void gradeAmend(Scanner scan, HashMap<String, Integer> map) {
		System.out.print("변경할 과목 선택 : ");
		String sub = scan.next();
		System.out.print("점수 변경 : ");
		map.put(sub, scan.nextInt());
		
	}
	
	
	public static void printMenu() {
		System.out.println("-------메뉴------");
		System.out.println("1. 학생 성적 추가");
		System.out.println("2. 학생 성적 조회(전체)");
		System.out.println("3. 학생 성적 조회(과목)");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 프로그램 종료");
		System.out.println("-------메뉴------");
		System.out.print("메뉴를 선택 하세요 : ");
	}
}

	



