package day8;

public class 클래스1 {
	
	public static void main(String[] args) {
		/* 접근제한자
		 * 	- public 	: 모두 사용 가능 (멤버 메소드와 멤버 변수에 붙일 때는 크게 문제없이 사용 가능)
		 * 							 (클래스에 붙일때는 클래스명과 클래스가 있는 파일명이 같은 경우에 붙일 수 있다.)
		 *  - protected : 나 + 같은 패키지 + 자식 클래스
		 *  - default 	: 나 + 같은 패키지
		 *  - private 	: 나(선언된 클래스) (private로 된 멤버 메소드와 멤버 변수는 다른 클래스에서 사용할 수 없다.)
		 *  
		 *  => 일반적으로 멤버 변수는 private로 하고(멤버 변수는 감옥에 가둬두고 직접 만날 수는 없고 면회로 만날 수 있다.), 멤버 메소드는 public으로 한다.
		 *  	-> 일반적으로 private로 되어있는 멤버 변수들은 getter와 setter를 만들어서 해당 멤버 변수의 값을 변경 가능하도록 한다.
		 *  	-> 이클립스에는 자동으로 getter, setter를 만들어 주는 기능이있다. (해당 클래스 안에서 우클릭 -> source -> generate getter, setter~~~) (단축기 : alt + shift + s)
		 *  => private으로 된 멤버 변수는 public으로 된 멤버 메소드를 통해 접근한다. ( 기능(메소드) 추가 )
		 * */
		
		/* 
		 * 설계도 - 클래스(자료형)
		 * 제품	- 객체(참조변수)	/ 클래스로 만든 변수가 객체다.
		 * 기능	- 메소드
		 * 
		 * 클래스				  (멤버변수는 클래스 안에서 모든 메소드에서 사용할 수 있다.)
		 * 	- 속성(정보) - 멤버변수(멤버변수의 위치는 메소드 밖, 클래스 안)(메소드 안에 있는 변수는 지역변수, 멤버변수는 참조변수) 
		 *  - 기능 - 메소드
		 *
		 * 프린터(클래스)
		 *	- 크기, 제조사, 흑백/칼라 (멤머변수 - 어떠한 클래스에 속해있는 변수)
		 *	- 인쇄, 복사, 스캔 (기능)
		 * */
		
		/* 객체 선언 			- 클래스명 객체명;
		 * 객체 초기화 			- new 클래스명();
		 * 멤버 메소드 사용법 	- 객체.메소드명();
		 * */
		
		/* 같은 클래스 안에있는 메소드를 호출할 때(실행할 때)는 그냥 사용 가능하고,
		 * 다른 클래스 안에있는 메소드를 호출할 때(실행할 때)는 객체를 이용하여 사용 가능하다.*/
		Point point = new Point();	// print라는 메소드는 Point 클래스의 메소드이고, 현재 이 코드가 실행되는 클래스는 클래스1이라는 다른 클래스이어서 객체를 이용하여 호출 해야한다.
			// point는 지역변수 이면서 참조변수.
		point.print();
		point.move(4, 5);
		point.print();
		point.x = 10;
		point.y = 20;
		//point.x1 = 10;  -> 에러) private로 된 멤버 메소드와 멤버 변수는 다른 클래스에서 사용할 수 없다.
		//point.y1 = 20;
		point.setX1(10);
		point.setY1(20);
		point.print();

	}

}

/* 일반적으로 클래스는 가장 밖에 만든다.  *클래스명 첫 글자는 대문자로 한다.
 * 접근제한자 class 클래스명 {
 * 	접근제한자 자료형 변수명;
 * }
 * 대표적인 클래스 예) Point 클래스 : 2차원 좌표평면의 점을 나타내기 위한 클래스
 * 					- 속성(멤버변수) : x축 좌표, y축 좌표
 * 					- 기능		 : x,y좌표 출력 기능 / x,y좌표 이동기 능
 * */
class Point{
	/* 속성(멤버변수 이면서 참조변수) */
	public int x;
	public int y;
	private int x1;
	private int y1;
	
	/* 기능1 : x,y좌표 출력 메소드
	 * 매개변수 : 없음 - x,y좌표는 Point 클래스가 스스로 알고 있기 때문에 다른 곳에서 알려줄 필요가 없다.
	 * 리턴타입 : 없음
	 * 메소드명 : print
	 * 
	 * */
	void print() {
		System.out.println("(" + x + ", " + y + ")");
		System.out.println("(" + x1 + ", " + y1 + ")");
	}
	
	/* 기능2 : x1, y1좌표로 이동하는 메소드
	 * 매개변수 : 이동할 좌표 => int x1, int y1
	 * 리턴타입 : 없음
	 * 메소드명 : move
	 * 
	 * */
	void move(int x2, int y2) {
		x = x2;
		y= y2;
		x1 = x2;
		y1 = y2;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}
	
//	public int getx1() {
//		return x1;
//	}
//	public int gety1() {
//		return y1;
//	}
//	public void setx1(int x) {
//		x1 = x;
//	}
//	public void sety1(int y) {
//		y1 = y;
//	}
	
}


























 