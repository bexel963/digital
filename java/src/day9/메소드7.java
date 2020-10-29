package day9;

public class 메소드7 {

	public static void main(String[] args) {
		/* 재귀 메소드 : 메소드 A안에 메소드 A를 호출하는 메소드(드물게 사용 -> 반복문으로 대체 가능해서)
		 * 5! = 5 * 4 * 3 * 2 * 1 = 5 * 4!
		 * 4! = 4 * 3 * 2 * 1 = 4 * 3!
		 * 0! = 1
		 * 
		 * */
		
		System.out.println(factorial(5));
	}

		/* 기능 : 양수가 주어지면 주어진 양수의 팩토리얼 값을 알려주는 메소드 
		 * 매개변수 : int num
		 * 리턴타입 : int
		 * 메소드명 : factorial
		 * 
		 * */
	public static int factorial(int num) {
		
		if(num < 0) {
			return 0;			// 0! 이 1이라서 0으로 지정하면 좋음.
		}
		if(num == 0 || num == 1) {
			return 1;
		}
		
		return num * factorial(num-1);
	}
	
	public static int fac(int num) {
		
		if(num < 0) {
			return 0;			// 0! 이 1이라서 0으로 지정하면 좋음.
		}
		if(num == 0 || num == 1) {
			return 1;
		}
		int res = 1;
		for( int i=2 ; i<=num ; i++ ) {
			res = res * 1;
		}
		return res;

	}
	
}
