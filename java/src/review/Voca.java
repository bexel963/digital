package review;

import day13.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Voca extends Test08_3 {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Word> list = new ArrayList<Word>();
	
	public void registration() {
		System.out.print("입력할 단어의 갯수 : ");
		int size = scan.nextInt();
		while(list.size() < size) {
			System.out.print("단어 : ");
			String word = scan.next();
			System.out.print("뜻 : ");
			String mean = scan.next();
			list.add(new Word(word,mean));
		}
		Collections.sort(list);
	}
	
	public void search() {
		System.out.print("검색할 단어 입력 : ");
		String search = scan.next();	
		for(Word tmp:list) {
			if(tmp.equals(search)) {
				System.out.println("검색된 단어 : ");
				System.out.println(tmp);
			}
		}
	}
	public void amend() {
		System.out.print("수정할 단어 검색 : ");
		String search = scan.next();
		for(int i=0 ; i<list.size(); i++) {
			String tmp = list.get(i).getWord();
//			if(tmp.indexOf(search)) {
//				
//			}
		}
	}
	public void print() {
		for(Word tmp : list) {
			System.out.println(tmp);
		}
	}
	public void printMenu() {
		System.out.println("---------메뉴---------");
		System.out.println("1.단어등록");
		System.out.println("2.단어검색");
		System.out.println("3.단어수정");
		System.out.println("4.단어출력");
		System.out.println("5.종료");
		System.out.println("---------메뉴---------");
		System.out.print("메뉴 선택 : ");
	}	
	public void printAlert() {
		System.out.println("------------------");
		System.out.println("잘못된 메뉴 입니다.");
		System.out.println("------------------");
	}	
	public void printExit() {
		System.out.println("------------------");
		System.out.println("프로그램 종료");
		System.out.println("------------------");
	}
	private void printStudentOne(Student s) {
		System.out.println("------학생정보------");
		System.out.println(s);							// toString메소드 부르는거
		System.out.println("-----------------");
		System.out.println("------수강정보------");
		s.print();
		System.out.println("-----------------");
		scan.close();
	}
}
