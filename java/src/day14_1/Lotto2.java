package day14_1;

import java.util.Arrays;
import java.util.Random;

public class Lotto2 {
	
	protected int[] numbers = new int [6];
	
	//1.1~45사이의 정수를 생성하여 반환 -> random메서드 - 외부에서 사용안함(값(범위)이 정해져있어서)
	protected int random() {
		return new Random().nextInt(45) + 1;
	}
	
	//2.로또 번호 배열에 num가 있는지 체크
	protected boolean contain(int num) throws RuntimeException {
		if(num < 0 || num > 45)
			throw new RuntimeException("숫자는 1~45 이어야 합니다.");
		for(int tmp : numbers) {
			if(tmp == num)
				return true;
		}
		return false;
	}
	
	//3.로또 번호 배열을 초기화 하는 메소드
	protected void init() {
		for(int i=0 ; i<numbers.length ; i++)
			numbers[i] = 0;
		//numbers = new int[6]; -> 이렇게 새로 만들어도 됨.
	}
		
	//1번, 2번, 3번 메서드를 이용해서 1~45사이의 중복되지 않은 번호 6개를 생성하는 메서드
	protected void randomLotto() {
		init();
		int cnt = 0;	// 저장된 중복되지 않은 랜덤 수의 갯수
		while(cnt<6) {
			int r = random();
			if(!contain(r)) {
				numbers[cnt] = r;
				cnt++;
			}
		}
	}
	//로또 당첨 번호 확인을 위한 번호를 문자열로 반환
	@Override
	public String toString() {
		return Arrays.toString(numbers).replace("[", "").replace("]", "");	// 대괄호를 공백으로 바꿈.	
	}
	//수동 번호 입력
	protected void insertNumber(int []arr) {
		if(arr.length < numbers.length)
			throw new RuntimeException("저장하려는 배열의 숫자가 적습니다.");
		
//		for(int i=0 ; i<numbers.length ; i++) {			-> 일일이 복사 해도 됨.
//			numbers[i] = arr[i];
//		}
		System.arraycopy(arr, 0, numbers, 0, numbers.length); // -> 이거 추천
	}

	public int[] getNumbers() {
		return numbers;
	}
		
	
			
	
}
