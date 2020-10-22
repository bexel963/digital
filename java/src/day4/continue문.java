package day4;

public class continue문 {

	public static void main(String[] args) {
		/* continue는 스킵이라고 생각하면 됨. (잘 안쓰임)
		 * continue는 for문과 while문에 따라 거넌뛰는 위치가 달라진다.
		 * for문의 실행문에 continue를 만나면 증감연산식으로 이동한다.
		 * break와 마찬가지로 무조건 if문과 같이 나온다.
		 * break와 마찬가지로 뒤에 문장이 오면 에러난다.
		 * */
		
		int i;
		for( i=1 ; i<=10 ; i++ ) {
			if( i == 5 ) {
				continue;
			}
			System.out.print( i + " " );
		}
		
		System.out.println();
		
		/* continue를 이용한 10이하의 짝수 출력 예제 */
		for( i=1 ; i<=10 ; i++) {
			if( i % 2 == 1 ) {
				continue;
			}
			System.out.print( i + " " );
		}
	}

}
