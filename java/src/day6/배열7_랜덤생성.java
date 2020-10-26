package day6;

public class 배열7_랜덤생성 {

	public static void main(String[] args) {
		/* 5개짜리 배열에 랜덤으로 값을 생성하여 저장한 후 출력하는 예제 
		 * 단, 10~20사이의 랜덤한 수
		 * */
		
		int min = 10, max = 20;
		int size = 5;
		int[] arr = new int[size];
		
		for( int i=0 ; i<arr.length ; i++ ) {
			arr[i] = (int)( (max-min+1) * Math.random() + min );
		}
		
		for( int i=0 ; i<arr.length ; i++ ) {
			System.out.print(arr[i] + " ");
		}

	}

}
