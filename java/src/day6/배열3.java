package day6;

public class 배열3 {

	public static void main(String[] args) {
		// 배열을 이용하여 1부터 10까지 출력
		
		int [] arr;
		arr = new int[10];
		
		for( int i=0 ; i<10 ; i++ ) {
			arr[i] = i + 1;
		}
		
		for( int i=0 ; i<10 ; i++ ) {
			System.out.println("arr["+ i +"] = " + arr[i] );
		}

	}

}
