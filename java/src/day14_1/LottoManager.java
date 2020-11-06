package day14_1;

import java.util.Scanner;

public class LottoManager {

	LottoE []lotto = new LottoE[5];	//당첨 번호
	int lCount = 0;					//현재 입력된 당첨 번호 개수
	Lotto2 user = new Lotto2();		//사용자 번호
	
	
	public void printMenu() {
		System.out.println("-------메뉴------");
		System.out.println("1. 로또 번호 생성(수동)");
		System.out.println("2. 로또 번호 생성(자동)");
		System.out.println("3. 로또 당첨 번호 입력");
		System.out.println("4. 로또 당첨 확인");
		System.out.println("5. 로또 당첨 번호 확인(전체)");
		System.out.println("6. 종료");
		System.out.println("-------메뉴------");
		System.out.print("메뉴를 선택 하세요 : ");
		
	}
//--------------------------------------------------------------------------------------------------------------------------------------------
	//case 1. 수동 로또 번호 입력 후 출력
	public void createLotto(Scanner scan) {				
		System.out.print("로또 번호를 입력하세요.(중복되지 않게 6개 입력) : ");
		int []tmp = new int[6];
		for(int i=0 ; i<tmp.length ; i++) {
			tmp[i] = scan.nextInt();
		}
		//중복 체크, 범위 체크
		if(isDuplicated(tmp)) {
			printString("중복된 숫자가 있어서 생성이 취소 됩니다.");
		}else {
			user.insertNumber(tmp);
			printString("로또 번호 : " + user);
		}
		
	}
	
	//중복 체크 메서드
	private boolean isDuplicated(int[] arr) {
		//1 2 3 4 5 6  -> 1,2/1,3/1,4/1,5/1,6 -> 2,3/2,4/2,5/2,6 -> 3,4/3,5/3,6 -> 4,5/4,6 -> 5,6....  이렇게 비교
		for(int i=0 ; i<arr.length-1 ; i++) {
			for(int j=i+1 ; j<arr.length ; j++) {
				if(arr[i] == arr[j])
					return true;
			}
		}
		return false;
	}
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	//case2. 자동 로또 번호 생성 후 출력
	public void createLottoAuto() {
		user.randomLotto();
		printString("로또 번호 : " + user);
	}
	
	//case3. 로또 당첨 번호 입력
	public void insertLotto(Scanner scan) {
		System.out.print("로또 번호를 입력하세요.(중복되지 않게 7개 입력, 보너스 번호를 마지막에) : ");
		int []tmp = new int[7];
		for(int i=0 ; i<tmp.length ; i++) {
			tmp[i] = scan.nextInt();
		}
		//중복 체크, 범위 체크
		if(isDuplicated(tmp)) {
			printString("중복된 숫자가 있어서 생성이 취소 됩니다.");
		}else {
			LottoE tmpLotto = new LottoE();				// 7번줄 당첨번호 LottoE 배열 선언 후 LottoE 객체를 생성해 줘야 쓸수있다.
			tmpLotto.insertNumber(tmp);
			lotto[lCount] = tmpLotto;
			lCount++;
			printString("로또 당첨 번호 : " + tmpLotto);
		}
		
	}
	
	//case4. 로또 당첨 확인
	public void checkLotto() {
		//사용자 로또 번호를 입력하지 않았을 때
		if(user.contain(0)) {
			printString("로또 번호를 입력하세요");
			return;
		}
		//당첨 로또 번호를 입력하지 않았을 때
		if(lCount == 0) {
			printString("당첨 번호를 입력하세요");
			return;
		}
		int cnt = 0; // 맞은 번호의 개수
		LottoE tmp = lotto[lCount-1];
		for(int i=0 ; i<user.getNumbers().length ; i++) {
			//lotto[lCount-1] : 마지막에 입력된 당첨 번호 : 최신 당첨 번호
			//lotto[lCount-1].getNumbers()[i] : 최신 당첨번호 중 i+1번째 번호
			int num = tmp.getNumbers()[i];
			if(user.contain(num)) {
				cnt++;
			}
		}
		int rank = -1;	// 당첨 등수
		//당첨 등수 계산
		switch(cnt) {
		case 6: rank = 1; break;
		case 5:
			if(user.contain(tmp.getBonus())){
				rank = 2;
			}else {
				rank = 3;
			}
			//rank = user.contain(tmp.getBonus()) ? 2 : 3;	-> case5 를 이렇게 줄여 쓸수도 있음
			break;
		case 4: rank = 4; break;
		case 3: rank = 5; break;
		}
		if(rank != -1) {
			printString(rank + "등 당첨!!!");
		}else
			printString("꽝!!");
		
		
	}
	
	//case5. 역대 당첨번호 확인
	public void printLotto() {
//		for(int i=0 ; i<lCount ; i++) {
//			System.out.println(i + 1 + "회차 : " + lotto[i]);
//		}
		String str = " ";
		for(int i=0 ; i<lCount ; i++) {
			str += (i + 1) + "회차 : " + lotto[i] + "\n";
		}
		//마지막 로또 번호에 들어가는 엔터('\n')를 제거하기 위해서
		str = str.substring(0, str.length()-1);
		printString(str);
	}
	
	//출력문 꾸며주는 메소드
	public void printString(String str) {
		System.out.println("***************************************");
		System.out.println(str);
		System.out.println("***************************************");
	}
	
}
