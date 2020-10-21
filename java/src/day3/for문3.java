package day3;

public class for문3 {

	public static void main(String[] args) {
		
		/* 1부터 100까지 2의 배수들을 출력 */
		int i;
		for( i=2 ; i<=100 ; i=i+2 ) {
			System.out.print(i + " ");
			if( i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		for( i=1 ; i<=100 ; i++) {
			if( i%2 == 0 ) {
				System.out.print(i + " ");
			}
			if( i % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

}
