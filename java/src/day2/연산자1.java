package day2;

public class 연산자1 {

	public static void main(String[] args) {
		
		//비교 연산자 : >, <, >=, <=, ==, !=
		//비교 연산자는 결과가 참 또는 거짓으로 나옴
		//==와 =을 구별 할 수 있어야 한다.
		
		int num1 = 10, num2 = 20;
		System.out.println("ㅡㅡㅡㅡ비교 연산자 예제ㅡㅡㅡㅡ");
		System.out.println(num1 > num2);
		System.out.println(num1 < num2);
		System.out.println(num1 >= num2);
		System.out.println(num1 == num2);
		System.out.println(num1 != num2);
		
		//논리 연산자 : &&(and), ||(or), !(not)
		//A && B : A가 참이고, B가 참이면 참		-> 하나라도 거짓이면 거짓
		//학생 성적이 90점이면 A
		//학생 성적이 90점 이상이고, 100점 이하이면 A
		//학생 성적이 90점 이상이고, 90점 미만이면 B
		//A || B : A가 참이거나, B가 참이면 참	-> 둘다 거짓이면 거짓 
		//출석체크를 카드로 하거나 비콘으로 하면 출석 인정
		//!A : A가 참이면 거짓, 거짓이면 참
		
		int score = 90;
		//성적이 90점 이상 : score >= 90
		//성적이 100점 이하 : score <= 100
		//성적이 90점 이상이고 100점 이하
		System.out.println("ㅡㅡㅡㅡ논리 연산자 예제ㅡㅡㅡㅡ");
		System.out.println(score >= 90 && score <= 100);
		//성적이 0점 미만이거나 100점 초과이면 잘못된 성적
		//성적이 0점 미만 -> 성적이 0보다 작다 : score < 0
		//성적이 100점 초과 -> 성적이 100보다 크다 : score > 100
		//score < 0 || score > 100 
		System.out.println(score < 0 || score > 100);
		
		int num3 = 11;
		//num3이 2의 배수인지 확인하는 코드를 작성하세요.(산술, 비교)
		//num3이 2의 배수 : num3을 2로 나누었을 때 나머지가 0과 같다
		System.out.println(num3 % 2 == 0);
		System.out.println(num3 + "는 2의 배수인가? " + (num3 % 2 == 0));
	}

}
