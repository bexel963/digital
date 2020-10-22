package day4;

public class 이중for문 {

	public static void main(String[] args) {
		/* for( 1.초기화 ; 2.조건식 ; 3.증감식 ) {
		 * 		for( 4.초기화 ; 5.조건식 ; 6.증감식 ) {
		 * 			실행문;
		 * 		}
		 * 		기타 실행문;
		 * }
		 * 1, 2, 3에서 사용하는 변수와 4, 5, 6에서 사용하는 변수가 일반적으로 다르다.
		 */ 
		 
		/* <별찍는 예제>
		 *   *****
		 *   *****
		 *   *****
		 * */
		
		int i, j;
		for( i=1 ; i<=5 ; i++ ) {
			for( j=1 ; j<=10 ; j++ ) {
			System.out.print("*");
			}
		System.out.println();
		}
		
		/* 구구단 7단을 출력하는 예제 */
		int num = 7;	// num단 출력
		for( i=1 ; i<=9 ; i++ ) {
			System.out.println( num + " x " + i + " = " + num*i );
		}
		
		/* 구구단 출력하는 예제 */
		for( num=2 ; num<=9 ; num++ ) {
			for( i=1 ; i<=9 ; i++ ) {
				System.out.println( num + " x " + i + " = " + num*i);
			}
		}
		
		/* 2부터 100사의의 모든 소수를 출력하는 예제 */
		int count;
		
		for( num=2 ; num<=100 ; num++ ) {	
			for( i=1, count=0 ; i<=num ; i++ ) {
				if( num % i == 0 ) {
					count++;
				}
			}	
			if( count == 2 ) {
					System.out.print(num + " ");
			}
		}	
	}
}
