package day7;

public class 메소드2 {

	public static void main(String[] args) {
		
		System.out.println(isGcd(8,12));
		System.out.println(lcm(10,15));
		System.out.println(lcm2(10,15));

	}
	
	/* 기능 : 최대 공약수 구하는 메소드 
	 * 매개변수 : num1, num2
	 * 리턴타입 : int
	 * 메소드명 : isGcd
	 * 
	 * */
	static int isGcd(int num1, int num2) {
		int result = 0;
		for( int i=1 ;i<=num1 ; i++ ) {
			if( num1 % i == 0 && num2 % i == 0 ) {
				result = i;
			}
		}
		return result;
	}
	
	/* 기능 : 최소 공배수 구하는 메소드
	 * 매개변수 : num1, num2
	 * 리턴타입 : int
	 * 메소드명 : lcm
	 * 
	 * */
	static int lcm(int num1, int num2) {
		
		for( int i=num1 ; ; i+=num1 ) {
			if( i % num2 == 0 ) {				// i는 num1의 배수이기 때문에 i%num1==0 은 생략 해도된다.
				return i;
			}
		}
	}
	
	/* 기능 : 최소 공배수 구하는 메소드2 */
	static int lcm2(int num1, int num2) {
		
		return num1*num2 / isGcd(num1, num2);			// 최소공배수 구하는 공식 = 두 수 곱한거 나누기 최대공약수
	}




}
