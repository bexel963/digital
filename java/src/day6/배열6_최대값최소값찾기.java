package day6;

public class 배열6_최대값최소값찾기 {

	public static void main(String[] args) {
		/* 다음과 같은 배열이 있을 때 최소값과 최대값을 찾아 출력하는 예제. */
		
		int[] arr = {3, 5, 10, 1, 20, 4, 8};
		int min = arr[0];						// min은 주어진 숫자가 범위가 있으면 주어진 범위의 최대값으로 초기화하고, 범위가 주어지지 않으면 0번지의 값으로 초기화를 많이 한다.
		int max = arr[0];						// max는 주어진 숫자가 범위가 있으면 주어진 범위의 최소값으로 초기화하고, 범위가 주어지지 않으면 0번지의 값으로 초기화를 많이 한다.
		
		for( int i=1 ; i<arr.length ; i++ ) {
			if( min > arr[i] ) {
				min  = arr[i];
			}
			if( max < arr[i] ) {
				max = arr[i];
			}
		}
		
		System.out.println( "arr[]의 최소값 : " + min );
		System.out.println( "arr[]의 최대값 : " + max );

	}

}
