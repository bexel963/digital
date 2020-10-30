package day10;

public class 참조변수형변환 {

	public static void main(String[] args) {
		
		// 1. 자식 -> 부모 형변환 (아무 문제 없음)
		Child c2 = new Child();
		Parent p2 = c2;				// 자식 클래스를 부모 클래스로 자동 형변환. (형변환 생략 가능 = 형변환 무조건 실행 됨)( <- 자식 클래스의 멤버 수가 무조건 부모 클래스보다 많거나 같아서 )
		//System.out.println(p2.num2);						// 부모클래스 객체 p2는 자식클래스 멤버(num1, num2) 중 부모꺼(num1)만 사용 가능
		System.out.println(p2.num1);
		
		// 2.부모 -> 자식 형변환시 에러 발생하는 경우.
				Parent p1 = new Parent();
				//C c1 = p1;			
				Child c1 = (Child)p1;			// 예외 발생 - 부모를 자식으로 바꿀땐 앞에다 (Child)를 쓴다고만 될게 아니다.
										// 부모 클래스를 자식 클래스로 형 변환 자동으로 안됨. (형변환 조건부로 가능)( <- 부모 클래스의 멤버 수가 자식 클래스의 멤버 수보다 적어서 문법상 맞지만 실행 에러남 )
				System.out.println(c1.num1);
		
		// 3.부모 -> 자식 형변환시 에러 발생하지 않는 경우.. ( 부모의 참조변수(p3)가 자식 객체(new C())랑 연결되어 있는경우 이 부모 객체를 다시 자식 객체로 형 변환 가능하다. )
		Parent p3 = new Child();			// 부모 클래스를 자식 클래스로 형변환하는 경우 형 변환을 생략할 수 없으며, 조건부로 에러가 발생하지 않음.
		Child c3 = (Child)p3;			// 자동 형 변환 안되서 이렇게 써줘야함.
		System.out.println(c3.num2);
		
	  
//		double num2 = 10;			  <- 이 원리랑 같음 (정수형 자료형을 실수형으로 전환) (13번, 19번 줄)
	
	}

}

class Parent {
	int num1 = 10;
}
class Child extends Parent {
	int num2 = 20;
}
