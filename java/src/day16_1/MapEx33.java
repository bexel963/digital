package day16_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MapEx33 {

	public static void main(String[] args) {
	
		int menu = 0;
	
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		Scanner scan = new Scanner(System.in);
		
		do {
			
			printMenu();
			
			// 메뉴 선택 : Scanner를 이용하여 입력받은 메뉴를 저장 - Scanner scan
			menu = scan.nextInt();
			
			// 입력받은 메뉴에 따라 기능 처리 : switch문
			switch(menu) {
			case 1: insert(scan, map); break; 
			case 2: print(map); break;
			case 3: print(map, scan); break;
			case 4: modify(map, scan); break;
			case 5: break;
			default:
				System.out.println("잘못된 메뉴!!");
			}
		}while(menu!=5);
		System.out.println("프로그램 종료!");
	}
	
	// 메뉴 출력
	public static void printMenu() {
		System.out.println("----메뉴----");
		System.out.println("1. 학생 성적 추가");
		System.out.println("2. 학생 성적 조회(전체)");
		System.out.println("3. 학생 성적 조회(과목)");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 프로그램 종료");
		System.out.println("----메뉴----");
		System.out.print("메뉴 선택 : ");
	}
	
	/* 1번 기능 : 학생 과목과 성적을 입력 받고, 입력받은 정보를 map에 추가.
	 * 	1. 과목과 성적을 입력 - 과목과 성적을 저장하기 위한 변수, 과목과 성적을 Scanner로 입력
	 *  2. map 추가 - map을 생성, map검색 -> 없으면 map에 추가, 있으면 안내문구
	 *  */
	public static void insert(Scanner scan, HashMap<String, Integer> map) {
		System.out.print("과목, 성적을 입력하세요(예:영어100) : ");
		String subject = scan.next();
		int score = scan.nextInt();
		if(map.get(subject) == null) {
			map.put(subject, score);
		}else {
			System.out.println(subject + "는 이미 추가한 과목");
		}
	}
	
	/* 2번 기능 : map에 있는 정보를 출력
	 * 	- Iterator를 이용하여 출력 - Map의 Key(subject)값을 set으로 만든 후 만들어진 set의 Iterator를 가져옴.
	 * */
	public static void print(HashMap<String, Integer> map) {
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp + " : " + map.get(tmp));				// 해당 key를 기준으로 map을 탐색 후  value 값 가져옴, key값이 없으면 null 리턴
		}
	}
	
	/* 3번 기능 : 과목을 입력받고, 입력 받은 과목의 성적을 출력
	 * 	- 과목 입력
	 * 	- 입력한 과목의 성적 출력
	 * 	- 단, 해당 과목이 없으면 없다고 출력
	 *  - map에서 과목에 대한 성적을 조회
	 * */
	public static void print(HashMap<String, Integer> map, Scanner scan) {			// 오버로딩
		System.out.print("조회할 과목 입력 : ");
		String subject = scan.next();
		Integer tmp = map.get(subject);
		if(tmp == null) {
			System.out.println("없는 과목");
		}else {
			System.out.println(subject + " : " + tmp);				
		}
	}
	
	/* 4번 기능 : 과목과 성적을 입력받고, 입력받은 성적으로 수정
	 * 	- 과목과 성적을 입력
	 * 	- 과목으로 검색을 해서 없으면 수정할 수 없다고 출력, 있으면 수정
	 * */
	public static void modify(HashMap<String, Integer> map, Scanner scan) {		// 1. 매개변수 순서
		System.out.print("과목, 성적을 입력하세요(예:영어100) : ");
		String subject = scan.next();
		int score = scan.nextInt();
		Integer tmp2 = map.get(subject);/////////////////////////// 2. 객체 선언
		if(tmp2 == null) {
			System.out.println(subject + "는 없는 과목이라 수정할 수 없음");
		}else {
			map.put(subject,  score);								// 해당 키 값에 덮어쓰기 됨.
			System.out.println(subject + " 성적이 수정됨.");
		}
	}

}
