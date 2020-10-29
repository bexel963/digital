package day9;

import day8.Card;	// import - 가져오는 역할 - Card 클래스는 Card.java에서 접근제한자가 public으로 되어 있어서 다른 패키지인 클래스3.java에서 사용할 수 있다.

//import day8.CardPack - CardPack 클래스는 클래스2.java에서 접근제한자가 default로 되어 있어서 다른 패키지인 클래스3.java에서는 사용할 수 없다.

public class 클래스3 {

	public static void main(String[] args) {
		Card c = new Card();
		c.print();
		// CardPack cp = new CardPack(); - Car dPack 클래스는 클래스2.java에서 접근제한자가 default로 되어 있어서 다른 패키지인 클래스3.java에서는 사용할 수 없다.
		
		
		Card2 c2 = new Card2();		// Card2 c2 = new Card2(); --> Card2 c3 = c2; --> c2는 새로운 객체를 생성하여 연결하고, c3는 c2와 연결된 객체를 공유한다.
		c2.setNum(10);
		Card2 c3 = new Card2(c2);	//	 복사생성자 사용. --> c3는 c2와 연결된 객체를 공유하는것이 아니라 c2에 연결된 객체를 똑같이 복사해서 c3와 연결 하는것. 
		System.out.println(c2.getNum() + ", " + c3.getNum());
		c2.setNum(11);
		System.out.println(c2.getNum() + ", " + c3.getNum());		// c2만 바뀌었기 때문에 c3는 c2의 객체를 공유한 것이 아니라 복사한것.
		Card2 c4 = new Card2('♠', 3);	//  생성자 오버로딩 사용.
	}

}
/* 클래스
 * 	- 멤버 변수
 * 	- 멤버 메소드
 * 	- 생성자 : 멤버 변수의 초기화
 *
 * 다음과 같은 항목들이 있을 때 멤버 변수와 멤버 메소드를 구분하세요. 
 * 	(자동차 클래스 - 바퀴의 수 ,전원, 시동 켜기, 시동 끄기, 전진, 후진, 기어, 와이퍼, 와이퍼 켜기, 와이퍼 끄기, 속도, 엑셀밟기, 브레이크 밟기)
 * 	- 멤버변수 : 바퀴의 수, 전원, 기어, 와이퍼, 속도
 * 	- 멤버 메소드 : 시동 켜기/끄기, 전진, 후진, 와이퍼 켜기/끄기, 엑셀 밟기, 브레이크 밟기
 * 	
 * */
 class Card2{
	 private int num;
	 private char shape;
	 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		//num = num; 생각 : 왼쪽은 멤버변수, 오른쪽은 매개변수 / 실제 : 둘다 매개변수 -> this를 꼭 사용해야 하는 경우(매개변수와 멤버변수의 이름이 같은 경우)
		this.num = num;		// 멤버변수와 매개변수의 구분이 필요해서 this 써야함.
	}
	public char getShap() {
		return shape;
	}
	public void setShap(char shap) {
		this.shape = shap;
	}
	/* 클래스의 멤버 메소드는 내가 호출하고 싶을 때 호출 할 수 있다. 
	 * 클래스의 생성자는 new 연산자를 통해 객체를 만들때만 자동으로 호출된다. 그 이외에 불러올 수 없다.
	 * */
	
	// 1. 기본 생성자 - 다른 생성자가 하나도 없을 때에만 쓸 수 있다.
	public Card2() {
		shape = '♥';
		num = 1;
	}
	
	// 2. 생성자 오버로딩
	public Card2( char shape, int num ) {	// 조건 1번에 의한 오버로딩
		this.shape = shape;
		this.num = num;
	}
	
	
	/* 3. 복사 생성자(생성자 오버로딩 중 매개변수가 객체일때 - 특이한 경우라 복사라는 이름 하나 더 붙인 것임)
	 * public 클래스명A(클래스명A 객체명) {
	 * 
	 * }
	 * */
	public Card2(Card2 card) {				// Alt+Shift+s -> Generate Constructor using Fields.....
		shape = card.shape;					// this 없어도 됨. 멤버변수와 매개변수가 같지 않아서
		this.num = card.num;
	}
	
	/* 기본생성자 : 클래스에 생성자가 하나라도 없으면 생성된다.*/
	/* 생성자는 셋중에 하나만 실행된다. */
	
	
 }