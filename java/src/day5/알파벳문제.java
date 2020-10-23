package day5;

public class 알파벳문제 {

	public static void main(String[] args) {
		/* a부터 z까지 반복문을 이용하며 출력하는 예제 
		 * 
		 * */
		
		for( char ch = 'A' ; ch <= 'Z' ; ch++ ) {
			System.out.print(ch + " ");
		}
		
		System.out.println();
		System.out.println();
		
		/* 다음과 같이 출력하도록 코드를 작성하세요.
		 * A
		 * AB
		 * ABC
		 * ABCDE
		 * ......
		 * ABCDE.....XYZ
		 * 
		 * */
		
		/*
		int i;
		char ch;
		for( i=66 ; i<=91 ; i++ ) {
			for( ch=65 ; ch<=i-1 ; ch++ ) {
				System.out.print(ch);
			}
			System.out.println();
		*/
		
		for( char ch1 = 'A' ; ch1 <= 'Z' ; ch1++ ) {
			for( char ch2 = 'A' ; ch2<=ch1 ; ch2++ ) {
				System.out.print(ch2);
			}
			System.out.println();
		}
	}	

}
