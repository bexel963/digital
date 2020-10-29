package day9;

public class 메소드6 {

	public static void main(String[] args) {
		System.out.println(calc(4.76, '/', 3.25));
		System.out.println(calc(4, '/', 3));

	}
	
	/* 기능 - 두 정수와 산술연산자(+, -, *, /, %)가 주어졌을 때 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : num1, num2, op
	 * 리턴타입 : double
	 * 메소드명 : calc
	 * 
	 * */
	public static double calc(int num1, char op, int num2) {
		
		switch(op) {
		
		case '+' : return num1 + num2; 
		case '-' : return num1 - num2; 
		case '*' : return num1 * num2; 
		case '/' : return (double)num1 / num2; 
		case '%' : return num1 % num2; 
		
		}
		return 0;
	}
	
	/* 기능 - 두 실수와 산술연산자(+, -, *, /, %)가 주어졌을 때 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : num1, num2, op
	 * 리턴타입 : double
	 * 메소드명 : calc2
	 * 
	 * */
	public static double calc(double num1, char op, double num2) {			// 메소드 오버로딩
		
		switch(op) {
		
		case '+' : return num1 + num2; 
		case '-' : return num1 - num2; 
		case '*' : return num1 * num2; 
		case '/' : return num1 / num2; 
		case '%' : return num1 % num2; 
		
		}
		return 0;
	}
	
	
	
}
