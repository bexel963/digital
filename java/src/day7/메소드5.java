package day7;

public class 메소드5 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		mixArray(arr, 1, 9);
		printArray(arr);
		
		

	}
	
	static void mixArray( int[] arr, int min, int max ) {
		for( int i=0 ; i<arr.length ; i++ ) {
			int index = (int)((max-min+1)*Math.random()+min);
			int tmp = arr[index];
			arr[index] = arr[i];
			arr[i] = tmp;
		}
	}
	
	static void printArray( int[] arr ) {
		for( int i=0 ; i<arr.length ; i++ ) {
			System.out.print( arr[i] + " ");
		}
		System.out.println();
	}

}
