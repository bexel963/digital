package day1;

public class 연산자 {

	public static void main(String[] args) {
		// 대입 연산자 : = 
		// =을 기준으로 오른쪽에 있는 값을 왼쪽에 저장
		// A = B
		// B를 A에 저장(대입)해라 / 덮어쓰기
		// A는 변수여야한다.
		// A는 변수 1개이어야한다.
		int a = 10;
		int b = 23;
		a = 30;
		a = b + 30;
		//b + 30 = a;   -> 에러
		
		//산술연산자 : +, -, *(곱하기), /(나누기), %(나머지,모드)
		//+, -, *는 그대로 
		System.out.println(4+3);
		System.out.println(4-3);
		System.out.println(4*3);
		
		System.out.println(1.2 + 3.4);
		System.out.println(1.2 - 3.4);
		System.out.println(1.2 *3.4);
		
		/* 나누기
		 * 정수 / 정수 => 정수
		 * 정수 / 실수 => 실수
		 * 실수 / 정수 => 실수
		 * 실수 / 실수 => 실수
		 */
		System.out.println(3/2);
		System.out.println(3/2.0);
		System.out.println(3.0/2);
		System.out.println(3.0/2.0);
		
		//정수 / 정수를 해야하는 경우 한쪽에다 자료형 변환을 해서 실수 / 정수 로 만들어서 계산한다.
		System.out.println((double)3 / 2);
		int num1 = 3;
		int num2 = 2;
		System.out.println((double)num1 / num2);
		
		//나머지 연산자 : %
		//A % B : A를 B로 나누었을 때 나머지
		//배수나 약수를 구할 때 사용
		System.out.println(4 % 3);
		System.out.println(199 % 17);
		
		
		//문제1. 국어 성적이 100점, 영어 성적이 35점, 수학 성적이 97점 일때 국어,영어,수학 세 과 목의 총점과 평균을 구하여 콘솔에 출력하세요.
		int KorScore = 100;
		int EngScore = 35;
		int MathScore = 97;
		int Sum = KorScore + EngScore + MathScore;
		double Avg = Sum / 3.0;
		
		System.out.println("총점 : " + Sum);
		System.out.println("평균 : " + Avg);
		
	}

}
