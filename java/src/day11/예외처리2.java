package day11;

public class 예외처리2 {

	public static void main(String[] args) {
		/* 아래 코드들은예외가 발생할 수 있는 코드들 */
		int []arr = new int[5];
		//arr[5] = 10; -> ArrayindexOutOfBoundsException : 배열의 주소가 길이를 넘어가는 경우
		//arr[-1] = 10; -> ArrayindexOutOfBoundsException : 배열의 주소가 길이를 넘어가는 경우
		
		//double res = 1/0; -> ArithmeticException
		
		
		P p = new P();
		//C c = (C)p; -> ClassCastException : 클래스의 형변환 과정에서 예외가 발생하는 경우
	
		//C c2 = null; -> NullPointerException : 참조변수가 객체와 연결되지 않은 상태에서 멤버변수나 메소드에 접근하려는 경우

	}

}

class P {
	void print() {
		
	}
}
class C extends P {
	void prnitChild() {
		
	}
}
