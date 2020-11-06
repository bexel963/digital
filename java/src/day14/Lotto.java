package day14;

import java.util.Scanner;

public class Lotto {
	private int[] numbers = new int[6];
	final private int min = 1;
	final private int max = 45;
	
	public void luckyNumRegis() {
	
		int random = (int)(( max - min + 1 ) * Math.random() + min);
		
		if(max-min+1 <= numbers.length) {
			System.out.println("정수의 범위가 배열의 크기보다 작습니다.");
			return;
		}
		int cnt = 0;	// 현재까지 만들어진 중복되지 않은 랜덤수의 개수
		while(cnt < numbers.length) {
			int r = random;
			if(!isContain(numbers,r)) {				// 배열에 r의 값이 없으면 cnt를 1증가, 배열에 r의값을 추가
				numbers[cnt] = r;
				cnt++;							
			}
		}
		
	}

	//배열에 같은 수 있는지 확인
	public boolean isContain(int[] arr, int num) {
		for( int tmp : arr ) {								
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}
	
	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	//로또 자동 번호 발행
	public void autoNumIssue() {
		
		int random = (int)(( max - min + 1 ) * Math.random() + min);
		
		if(max-min+1 <= numbers.length) {
			System.out.println("정수의 범위가 배열의 크기보다 작습니다.");
			return;
		}
		int cnt = 0;	// 현재까지 만들어진 중복되지 않은 랜덤수의 개수
		while(cnt < numbers.length) {
			int r = random;
			if(!isContain(numbers,r)) {				// 배열에 r의 값이 없으면 cnt를 1증가, 배열에 r의값을 추가
				numbers[cnt] = r;
				cnt++;							
			}
		}

	}
	
	//로또 수동 번호 발행
	public void handNumIssue() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("번호 입력 : ");
		
		for(int i=0 ; i<numbers.length ; i++) {
			int num = scan.nextInt();
			if( numbers.equals(num) ) {
				System.out.println("중복된 수");
			}
			numbers[i] = num;
		
		scan.close();

		}

	}
	
	//로또 번호 확인
	public void lottoNumPrint() {
		

	}
	
}
