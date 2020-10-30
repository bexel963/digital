package day10;

//형 변환 가능한지 아닌지 알려주는 연산자

public class Instanceof연산자 {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Child c1;
		
		
		if( p1 instanceof Child ) {				// 객체 p1이 클래스 C로 형변환 가능하면
			c1 = (Child)p1;
			System.out.println(c1.num2);
		}else {
			System.out.println("형변환 할 수 없습니다.");
		}
		
		Parent p2 = new Child();		//  부모의 참조변수(p2)가 자식 객체(new C())랑 연결되어 있는경우 이 부모 객체를 다시 자식 객체로 형 변환 가능하다.
		
		if( p2 instanceof Child ) {				// 객체 p2가 클래스 C로 형변환 가능하면
			c1 = (Child)p2;
			System.out.println(c1.num2);
		}else {
			System.out.println("형변환 할 수 없습니다.");
		}
	}
	
	

}
