package day9;

import day8.Card;

public class 클래스5 {
	//final in STUDENT_COUNT = 10;			// 여기다 쓰면 에러남. -> STUDENT_COUNT는 객체 멤버변수 이므로 STUDENT_COUNT에 static 없으면 클래스 멤버 메소드인 main에서 사용할 수 없다.
	
	public static void main(String[] args) {
		/* final은 클래스, 변수, 멤버 메소드에 붙일 수 있다.
		 * final - 수정할 수 없다.
		 * final 멤버 변수 : 상수
		 * final 멤버 메소드 : 메소드 오버라이딩을 할 수 없다.
		 * final 클래스 : 상속할 수 없다. => 부모클래스가 될 수 없다.
		 * 
		 * */
		
		final int STUDENT_COUNT = 10;			// 지역변수라서 final 붙여도 글씨체 안변함.
		System.out.println(STUDENT_COUNT);
		// STUDENT_COUNT = 20;  // 에러
		
		Card c1 = new Card();
		final Card c2 = c1;
		//c2 = null;    		// 에러
		
		System.out.println((Math.PI));	      	// final이면 굵고 기울어진 글씨체, static 붙이면 얇고 기울어진 글씨체

	}

}
