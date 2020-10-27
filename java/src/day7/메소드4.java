package day7;

public class 메소드4 {

	public static void main(String[] args) {
		/* 기능 : 주어진 정수 배열의 값들을 콘솔에 출력하는 메소드
		 * 매개변수 : 정수 배열 => int arr[]
		 * 리턴타입 : void
		 * 매소드명 : printArray
		 * 
		 * */
		
		int[] arr = {3, 1, 5, 7, 9, 2, 4, 6, 8, 10, 11};
		//printArray(arr);
		//sortArray(arr);
		//printArray(arr);
		//arr = sortArray2(arr);
		//printArray(arr);
		/*
		int[] arr1 = new int[11];
		
		printArray(arr);
		System.out.println();
		
		arr1 = arr;
		arr1[0] = 0;
		printArray(arr1);
		printArray(arr);
		*/
		printArray(arr);
		System.out.println();
		arr = createArray(5);
		printArray(arr);
		
		//System.out.println(prinArray(arr)); 	-> 리턴타입이 void면 println()은 사용 못함.


	}
	/* 기능 : 새로운 배열을 만들어서 돌려주는 메소드
	 * 매개변수 : 만들어야할 배열, 배열의 길이 => int[] arr, int size
	 * 리턴타입 : void(x), 새로 만든 배열(o)->int[]
	 * 메소드명 : createArray
	 * 
	 * 
	static void createArray(int[] arr, int size) {
		arr = new int[size];							// 새로만든 배열로 주소가 바뀜. -> 원본 조작 못함.
	}
	*/
	
	static int[] createArray(int size) {
		int[] arr = new int[size];
		return arr;
		//return new int[size];	-> 이렇게 해도됨
	} 
	
	static void printArray(int[] arr) {
		for( int i=0 ; i<arr.length ; i++ ) {
			System.out.print(arr[i] + " ");	
		}
		System.out.println();
		
	}
	
	/* 기능 : 주어진 정수 배열을 정렬하는 메소드
	 * 매개변수 : int arr[]
	 * 리턴타입 : 없음 or 배열 => void or int[]
	 * 메소드명 : sortArray
	 * 
	 * */
	static void sortArray( int[] arr ) {
		
		for(int i=0 ; i<arr.length-1 ; i++ ) {
			for(int j=0 ; j<arr.length-1 ; j++) {
				if( arr[j] > arr[j+1] ) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
					
		}
	}
	
	static int[] sortArray2( int[] arr ) {
		
		for(int i=0 ; i<arr.length-1 ; i++ ) {
			for(int j=0 ; j<arr.length-1 ; j++) {
				if( arr[j] > arr[j+1] ) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
					
		}
		
		return arr;
		
	}
			
	
	
}	

