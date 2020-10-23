package day5;

public class 별문제2 {

	public static void main(String[] args) {
		/* for( 초기화 ; 조건식 ; 증감연산식 ) {
		 * 		실행문;
		 * }
		 */
		
		/* - 일반변수 vs 참조변수
		 * - 일반변수는 변수타입(자료형)을 이용한 변수들로 값을 저장
		 * - 참조변수는 주소를 저장하는 변수로, 객체, 배열 등이 있다 
		 * 
		 * - 지역변수 : 특정 지역에서 사용하는 변수 
		 * */
		
		/*
		int i = 5;
		for( int j=1 ; j<=5 ; j++ ) {
			System.out.println(j);		-> 지역변수 j
		}
		System.out.println(j);			-> 에러			
		
		if( i % 2 == 0) {
			int k = 1;
			System.out.println(k);		-> 지역변수 k
		}
		System.out.println(k);			-> 에러
		*/
		
		/* 별 문제1
		 *      *				i=1			공=4		*=1		추가*=0
		 *     ** * 			i=2			공=3		*=2		추가*=1
		 *    *** **			i=3			공=2		*=3		추가*=2
		 *   **** ***			i=4			공=1		*=4		추가*=3
		 *  ***** ****			i=5			공=0		*=5		추가*=4
		 *  								공=5-i	*=i		추가*=i-1
		 *     */
		
		/* 별 문제1
		 *      *				i=1			공=4		*=1		
		 *     *** 				i=2			공=3		*=3		
		 *    *****				i=3			공=2		*=5		
		 *   *******			i=4			공=1		*=7		
		 *  *********			i=5			공=0		*=9		
		 *  								공=5-i	*=2*i-1	
		 *     */
		
		
		
		int i, j;
		int num = 10;
		
		for( i=1 ; i<=num ; i++ ) {
			for( j=1 ; j<=5-i ; j++ ) {
				System.out.print(" ");
			}
			for( j=1 ; j<=i ; j++ ) {
				System.out.print("*");
			}
			for( j=1 ; j<=i-1 ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for( i=1 ; i<=num ; i++ ) {
			for( j=1 ; j<=5-i ; j++) {
				System.out.print(" ");
			}
			for( j=1 ; j<=(2*i-1) ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
	
		/* 별 문제2 
		 *  ***** ****		i=1		공=0		*=5		추가*=4
		 *   **** ***		i=2		공=1		*=4		추가*=3
		 *    *** **		i=3		공=2		*=3		추가*=2
		 *     ** *			i=4		공=3		*=2		추가*=1
		 *      *   		i=5		공=4		*=1		추가*=0
		 *      					공=i-1	*=6-i	추가*=5-i
		 *      
		 *      */
		
		/* 별 문제2 
		 *  *********		i=1		공=0		*=9		
		 *   *******		i=2		공=1		*=7		
		 *    *****			i=3		공=2		*=5		
		 *     ***			i=4		공=3		*=3		
		 *      *   		i=5		공=4		*=1		
		 *      					공=i-1	*=2*(5-i)+1	
		 *      
		 *      */
		 
		for( i=1 ; i<=num ; i++ ) {
			for( j=1 ; j<=i-1 ; j++) {
				System.out.print(" ");
			}
			for( j=1 ; j<=6-i ; j++ ) {
				System.out.print("*");
			}
			for( j=1 ; j<=5-i ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for( i=1 ; i<=num ; i++ ) {
			for( j=1 ; j<=i-1 ; j++ ) {
				System.out.print(" ");
			}
			for( j=1 ; j<=2*(5-i)+1 ; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		
		}
	}
}
