package day7;

public class 메소드1 {

	public static void main(String[] args) {
		
		/* 메소드 : 기능 
		 * 매개변수 : 기능을 실행하기 위해 필요한 정보(필수 정보)
		 * 리턴타입 : 기능을 실행 후 알려주는 정보(자료형으로 표시)(없을수도 있음)
		 * 메소드 선언 및 구현
		 * 
		 * 		리턴타입 메소드명(매개변수) {
		 *	 			구현;
		 *		{
		 * 
		 * */
		
		//int result = sum(1,2);
		//System.out.println(result);
		//sum2(1,2);
		//System.out.println(isPrime(4));
		
		/* isPrime 메소드를 이용하여 100이하의 소수를 출력하는 코드를 작성하세요. */
		int num = 100;
		for( int i=2 ; i<=num ; i++ ) {
			if( isPrime(i) ) {
				System.out.print(i + " ");
			}
		}
	}
	
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드 
	 * 매개변수 : 두 정수 => 자료형 변수명, 자료형 변수명 => int num1, int mum2
	 * 리턴타입 : 두 정수의 합 => 정수 => int
	 * 메소드명 : sum
	 * 
	 * */
	static int sum( int num1, int num2 ) {
			int result = num1 + num2;
			return result;
		}

	/* 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수 : int num1, int num2
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sum2
	 * 
	 * */
	static void sum2( int num1, int num2) {
		int result = num1 + num2;
		System.out.println(result);
	}
	
	/* 정수가 주어지면 정수가 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : num
	 * 리턴타입 : 참 또는 거짓 => boolean
	 * 메소드명 : isPrime					// is -> 물어보는 형태의 메소드명
	 * 
	 * */
	static boolean isPrime( int num ) {
		int count = 0;
		for( int i=1 ; i<=num ; i++ ) {
			if( num % i == 0 ) {
				count++;
			}
		}
		if( count == 2 ) {
			return true;
		}else
			return false;
	}
}
