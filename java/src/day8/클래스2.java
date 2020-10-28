package day8;

public class 클래스2 {

	public static void main(String[] args) {
	/*	
		Card c = new Card();					// Card c는 빈 공간 만듦. new는 객체 생성함 Card()는 생성자로 초기화 시키는 역할.
		c.print();
		c.setNum(14);
		c.setShape('가');
		c.print();
	*/
		CardPack cp = new CardPack();		// new연산자를 통해 객체를 만들고, 35,36번줄로가서 멤버변수 초기화하고, CardPack 생성자를 실행하기 위해 62번 줄로 이동
		
		//Card tmp = cp.pick();
		//tmp.print();
		//tmp = cp.pick();
		//tmp.print();
		//tmp = cp.pick();
		//tmp.print();
		//tmp = cp.pick();
		//tmp.print();
		
		cp.shuffle();
		Card tmp;
		for(int i=1 ; i<=4 ; i++) {
			for(int j=1 ; j<=13 ; j++) {
				tmp = cp.pick();
				tmp.print();
			}
			System.out.println();
		}
	
	}
}

/* CardPack 클래스
 * 	- 카드팩 : 52장의 카드들 - ♥x12 ♣x12 ◆x12 ♠x12
 *  - 카드 섞기 기능
 *  - 카드 빼내는 기능
 *  - 카드 초기화 기능 : 다시 하나의 팩으로 만드는 기능
 *  
 * */

class CardPack {
	private Card[] pack = new Card[52];
	private int cnt = 0;	//현재 남은 카드 갯수
	
	//카드 섞기
	public void shuffle() {							// 자기꺼 섞기만 하는거라 매개변수 필요없음
		int min = 0, max = pack.length-1;
		
		for( int i=0 ; i<pack.length ; i++ ) {
			int index =(int)( (max-min+1)*Math.random() + min );
			Card tmp = pack[i];
			pack[i] = pack[index];
			pack[index] = tmp;
		}
	}
	
	//리턴타입 : 꺼내간 카드 => Card						// 위에서 하나 꺼내는거라 매개변수 필요없음
	public Card pick() {	
		if(cnt == 0) {
			return null;
		}
		cnt--;
		return pack[cnt];
	}
	
	//작업 끝난 후 초기화
	public void init() {
		cnt = 52;				// 위에서 부터 하나씩 꺼낸 카드를 다시 초기화.
	}
	
	public int getCnt() {
		return cnt;
	}
	
	//생성자를 이용한 초기화
	public CardPack() {
		char shape = '♥';
		for( int i=1 ; i<=4 ; i++ ) {
			switch(i) {
			case 1: shape = '♥'; break;
			case 2: shape = '◆'; break;
			case 3: shape = '♣'; break;
			case 4: shape = '♠'; break;
			}
			for( int j=1 ; j<=13 ;j++ ) {
				Card tmp = new Card();		//	카드 1장 생성			//Card.java파일로 가서 Card 생성자로 초기화.
				tmp.setNum(j);
				tmp.setShape(shape);		
				pack[cnt] = tmp;			// 카드팩에 카드를 추가
				cnt++;						// 카드팩에 들어있는 카드 개수 증가
			}
		}
	}
	
}




 