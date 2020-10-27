package day6;

public class 이차배열 {

	public static void main(String[] args) {
		/* 2차원 배열 선언
		 * 자료형 배열명[][] = new 자료형[길이1][길이2];
		 * 
		 * */
		
		int arr[][] = new int[5][3];
		int cnt = 1;
		for(int i=0 ; i<arr.length ; i++) {					// 주로 행, arr의 행의 갯수 -> 5
			for(int j=0 ; j<arr[0].length ; j++) {			// 주로 열, arr[0]번째 행의 열의 갯수 -> 3
				arr[i][j] = cnt;
				System.out.print(arr[i][j] + " ");
				cnt++;
			}
			System.out.println();
		}

	}

}
