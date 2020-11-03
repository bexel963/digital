package day12;

public class wrapper클래스 {

	public static void main(String[] args) {
		/* Wrapper 클래스는 기본 자료형을 클래스로 변환한것
		 * 차이점
		 * 	- 래퍼 클래스는 null을 허용, 기본 자료형은 null을 허용하지 않음
		 * 	- 래퍼 클래스는 기능(메서드)을 제공
		 * 
		 * */

		//int num1 = null;		// 기본 자료형은 null을 사용할 수 없음
		Integer num2 = null;	// 래퍼 클래스는 null을 허용
		num2 = Integer.parseInt("1234");	// 문자열을 정수로 바꾸는 함수
		System.out.println(num2);
		num2 = Integer.valueOf("5678");		// 정수를 문자로 바꾸는 함수
		System.out.println(num2);
		num2 = Integer.valueOf("FF", 16);	// 16진수 ff
		System.out.println(num2);
		//num2 = null;
		int num3 = num2;			// 언박싱 - Integer 참조변수 num2를 자료형 변수 num3에 대입 시키면 언박싱 과정 후 주소 값이 아닌 실제 값이 저장된다. (이때 참조변수 값이 null이면 안됨.)
		System.out.println(num3);
		num2 = 23;					// 오토박싱
	}

}
