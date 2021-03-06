package day9;

public class 메소드5 {

	public static void main(String[] args) {
		 int res = sum(1,2);

	}
	/* 메소드 오버로딩 : 동일한 이름을 가지는 메소드가 여러개인 경우
	 * 	사용가능 조건 1. 매개변수의 개수가 다른 경우
	 * 			  2. 매개변수의 형태(자료형)가 다른 경우
	 * 
	 * */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	public static double sum(double num1, double num2) {		// 2번에 의해 오버로딩 적용됨. 
		return num1 + num2;
	}
	public static int sum(int num1, int num2, int num3) {		// 1번에 의해 오버로딩 적용됨.
		return num1 + num2 + num3;
	}
	

}
