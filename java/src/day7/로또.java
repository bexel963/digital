package day7;

public class 로또 {

	public static void main(String[] args) {
		
		int[] lotto = new int[7];	// 당첨번호, 6번지가 보너스번호
		int min = 1, max = 45;
		randomArray( lotto, min, max );
		printArray(lotto);
		
	}
	
	//랜덤 값 출력
	static int rand( int min, int max ) {
		if( min > max ) {
			int tmp;
			tmp = max;
			max = min;
			min = tmp;
		}
		int random = (int)(( max - min + 1 ) * Math.random() + min);
		
		return random;
	}
	
	/* 기능 : 주어진 배열의 모든 번지에 있는 값을 랜덤으로 설정하는 메소드
	 * 매개변수 : int[], 랜덤 범위=>in[] arr, int min, int max
	 * 리턴타입 : void
	 * 메소드명 : randomArray
	 * 
	 * */
	static void randomArray( int[] arr, int min, int max ) {
		
		//1 2 3 4 5 6 
		//1 1 1 1 1 1 1 1 1 2 3 4 5 5 5 5 6 -> 반복 회수 지정x -> while문 사용
		
		if(max-min+1 <= arr.length) {
			System.out.println("정수의 범위가 배열의 크기보다 작습니다.");
			return;
		}
		int cnt = 0;	// 현재까지 만들어진 중복되지 않은 랜덤수의 개수
		while(cnt < arr.length) {
			int r = rand(min, max);
			if(!isContain(arr,r)) {				// 배열에 r의 값이 없으면 cnt를 1증가, 배열에 r의값을 추가
				arr[cnt] = r;
				cnt++;							
			}
		}
	}
	
	//배열값 출력
	static void printArray(int[] arr) {
		for( int i=0 ; i<arr.length ; i++ ) {
			System.out.print(arr[i] + " ");	
		}
		System.out.println();
	}
	
	/* 기능 : 배열에 특정 값이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열, 특정 값 => int[] arr, int num
	 * 리턴타입 : 있는지 없는지 => 참 또는 거짓 => boolean 
	 * 메소드명 : isContain
	 * 
	 * */
	static boolean isContain(int[] arr, int num) {
		for( int tmp : arr ) {								// 향상된 for문 - 배열에서 자주 쓰임.
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	
}
