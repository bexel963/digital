package day6;

public class 배열4 {

	public static void main(String[] args) {
		// 배열 이용하여 짝수 출력
		
		int size = 10;
		int [] arr = new int[size];
		
		for( int i=0 ; i<arr.length ; i++ ) {
			arr[i] = i * 2 + 2;
		}
		
		for( int i=0 ; i<arr.length; i++ ) {
			System.out.println("arr["+ i +"] = " + arr[i]);
		}

	}

}
