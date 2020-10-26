package day6;

public class 배열9_배열정렬 {

	public static void main(String[] args) {
		/* 배열 정렬하기( 예제5-10, p.201, 버블정렬 )
		 * 
		 * 
		 * */
		
		int[] arr = { 4, 3, 2, 9, 8, 7, 6, 10, 1, 5, };
		
		for(int i=0 ; i<arr.length-1 ; i++ ) {
			for(int j=0 ; j<arr.length-1 ; j++) {
				if( arr[j] > arr[j+1] ) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
			for(int j=0 ; j<arr.length ; j++ ) {
				System.out.print(arr[j] + " ");	
			}
			System.out.println();	
		}
	}
}
