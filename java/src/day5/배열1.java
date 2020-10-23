package day5;

public class 배열1 {

	public static void main(String[] args) {
		/* - 배열 : 같은 타입, 같은 의미의 변수들의 집합. (참조변수)	->	배열은 반복문을 이용할 수 있기 때문에 편리하다.
		 * - 배열 선언 방법 
		 * 		1. 타입 [] 배열이름;
		 * 		2. 타입 배열이름[];
		 * - 배열 선언 및 초기화
		 * 		타입 [] 배열이름 = new 타입[길이];		// 가장 많이 사용!
		 * 		타입 [] 배열이름 = new 타입[]{초기값1, 초기값2, ...., 초기값n};
		 * 		타입 [] 배열이름 = {초기값1, 초기값2, ..., 초기값n};
		 * - 배열의 길이는 0이상 이어야한다.
		 * 
		 * - 참조변수 : 주소를 가지고있는 변수 -
		 * */
		
		/*
			int [] arr1, arr2;		//arr1 : 배열, arr2 : 배열
			int arr3[], arr4[];		//arr3 : 배열, arr4 : 변수
			int num1, num2;			//num1, num2 둘다 선언
		*/
		
		int [] arr1, arr2;
		
		arr1 = new int[5];				// 가장 많이 사용되는 선언문.
		arr2 = new int[] {1,2,3,4,5};
		int arr3[] = {1,2,3,4,5};		// new를 사용하지 않는 초기화는 반드시 선언과 동시에 할 때이다.
		
		/* 배열의 값을 사용하기 위해서는 다음과 같이 사용한다.
		 * 배열이름[번지]
		 * 번지는 0부터 시작해서 길이-1 번지 까지
		 * 		- 배열의 길이는 배열이름.lenth로 알 수 있다.
		 * 
		 * */
		System.out.println("배열 arr1의 1번째 값 : " + arr1[0]);
		System.out.println("배열 arr1의 2번째 값 : " + arr1[1]);
		System.out.println("배열 arr1의 3번째 값 : " + arr1[2]);
		System.out.println("배열 arr1의 4번째 값 : " + arr1[3]);
		System.out.println("배열 arr1의 5번째 값 : " + arr1[4]);
		
		System.out.println();
		
		System.out.println("배열 arr2의 1번째 값 : " + arr2[0]);
		System.out.println("배열 arr2의 2번째 값 : " + arr2[1]);
		System.out.println("배열 arr2의 3번째 값 : " + arr2[2]);
		System.out.println("배열 arr2의 4번째 값 : " + arr2[3]);
		System.out.println("배열 arr2의 5번째 값 : " + arr2[4]);
		//java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5 => 배열의 번지가 범위를 넘어가는 경우
		//System.out.println("배열 arr2의 5번째 값 : " + arr2[5]);
		
		System.out.println();
		
		for( int i=0 ; i<arr1.length ; i++ ) {
			System.out.println("배열 arr1의 " + (i+1) + "번째 값 : " + arr1[i]);
		}
		
		System.out.println();
		
		arr2[0] = 10;
		for( int i=0 ; i<arr2.length ; i++ ) {
			System.out.println("배열 arr2의 " + (i+1) + "번째 값 : " + arr2[i]);
		}
		
		System.out.println();
		
		for( int i=0 ; i<arr3.length ; i++ ) {
			System.out.println("배열 arr3의 " + (i+1) + "번째 값 : " + arr3[i]);
		}
		
		// int [] arr5 = null;
		// System.out.println(arr5.length);
		// Cannot read the array length because "arr5" is null
		
		/* 10개짜리 정수 배열 arr6를 생성하여 arr6에 1부터 10까지 저장하고 출력하는 코드를 작성하세요.
		 * */
		
		System.out.println();
		
		int [] arr6;
		arr6 = new int[10];
		
		for( int i=0 ; i<arr6.length ; i++ ) {
			arr6[i] = i+1;
			System.out.println("배열 arr6의 " + (i+1) + "번째 값 : " + arr6[i]);
		}
	}

}
