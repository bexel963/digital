package day12;

import java.util.Scanner;

public class String메소드3 {

	public static void main(String[] args) {
		/* 5개의 파일명이 주어졌을 때, 원하는 단어를 입력하면 입력한 단어가 있는 파일들이 출력되도록 코드를 작성하세요.
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		String[] fileName = {"java의 정석.txt", "String메소드.java", "java의 정석 앞표지.png", "java의 정석 뒷표지.png", "java의 정석.hwp"};
		
		System.out.print("단어 입력 : ");
		String search = scan.next();
		
//		for( int i=0 ; i<fileName.length ; i++ ) {
//			if( !(fileName[i].indexOf(search) == -1) ) {
//				System.out.println(fileName[i]);
//			}
//		}
		
		for(String tmp : fileName) {
			if(tmp.contains(search)) {		 
				System.out.println(tmp);
			}
		}
		
		scan.close();
	}

}
