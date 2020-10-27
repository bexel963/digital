package day7;

public class 연습장 {
	public static void main(String[] args) {
		
		int[] lotto = new int[7];
		int min = 1, max = 8;
		
		randomArray(lotto, min, max);
		printArray(lotto);
		
	}
	
	// 랜덤값 생성
	static int random(int min, int max) {
		if( min > max ) {
			int tmp;
			tmp = max;
			max = min;
			min = tmp;
		}
		int value = (int)((max - min +1)*Math.random() + min);
		return value;
	}
	
	// 배열 출력
	static void printArray( int[] arr ) {
		for( int i=0 ; i<arr.length ; i++ ) {
			System.out.print( arr[i] + " ");
		}
		System.out.println();
	}
	
	// 중복 값 검사
	static boolean isContain( int[] arr, int num ) {
		for( int tmp : arr ) {
			if( tmp == num ) {
				return true;
			}
		}
		return false;
	}
	
	// 배열에 랜덤 값 넣기
	static void randomArray( int[] arr, int min, int max ) {
		if( (max-min+1) <= arr.length ) {
			System.out.println("정수의 범위가 배열보다 작습니다. ");
			return;
		}
		int cnt = 0;
		while( cnt < arr.length ) {
			int r = random(min, max);
			if( !isContain(arr, r) ) {
			arr[cnt] = r;
			cnt++;
			}
		}
	}
	
	
}
