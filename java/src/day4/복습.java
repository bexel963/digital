package day4;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		/* (1). num을 입력받아 입력받은 num가 소수인지 아닌지 판별하는 예제 */
		/* (2). 2부터 100사의의 모든 소수를 출력하는 예제 */
		/* (3). 이중 반복문을 이용하여 아래와 같이 출력되도록 작성하세요.
		 * *		i=1		*=1
		 * **		i=2		*=2
		 * ***		i=3		*=3
		 * ****		i=4		*=4
		 * *****	i=5		*=5
		 * */
		/* (4). 이중 반복문을 이용하여 아래와 같이 출력되도록 작성하세요.
		 *     *		i=1	 공백=4	*=1
		 *    **		i=2	 공백=3	*=2
		 *   ***		i=3	 공백=2	*=3
		 *  ****		i=4	 공백=1	*=4
		 * *****	    i=5	 공백=0	*=5
		 * 					 공백=5-i  *=i
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int num, count = 0;
		int i;
		
		System.out.println("숫자를 입력 하세요 : ");
		num = scan.nextInt();
		
		for( i=1 ; i<=num ; i++ ) {
			if( num % i ==0 ) {
				count++;
			}
		}
		if( count == 2 ) {
			System.out.println(num + "은 소수");
		}else {
			System.out.println(num + "은 소수아님");
		}
		
		scan.close();
	}
}
