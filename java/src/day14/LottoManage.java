package day14;

public class LottoManage implements Program {

	@Override
	//당첨번호 등록 ( 마지막에 있는게 가장 최신꺼 )
	public void luckyNumRegis() {
		
		
		int []arr = new int[6];
		int min = 1;
		int max = 45;
		
		if( min > max ) {
			int tmp;
			tmp = max;
			max = min;
			min = tmp;
		}
		
		int random = (int)(( max - min + 1 ) * Math.random() + min);
		
		if(max-min+1 <= arr.length) {
			System.out.println("정수의 범위가 배열의 크기보다 작습니다.");
			return;
		}
		int cnt = 0;	// 현재까지 만들어진 중복되지 않은 랜덤수의 개수
		while(cnt < arr.length) {
			int r = random;
			if(!isContain(arr,r)) {				// 배열에 r의 값이 없으면 cnt를 1증가, 배열에 r의값을 추가
				arr[cnt] = r;
				cnt++;							
			}
		}
		
	}
	
	// 배열에 같은 수 있는지 확인
	public boolean isContain(int[] arr, int num) {
		for( int tmp : arr ) {								
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}

	@Override
	//로또 번호 확인 ( 최신꺼 확인 ) -> 등수 확인
	public void lottoNumPrint() {
		

	}

	@Override
	//역대 당첨번호 확인 ( 등록한 당첨번호들 출력 )
	public void luckyNumConfirm() {
		

	}

	@Override
	//로또 자동 번호 발행
	public void autoNumIssue() {
		

	}

	@Override
	//로또 수동 번호 발행 
	public void handNumIssue() {
		

	}
	
	public void printMenu() {
		System.out.println("---------메뉴---------");
		System.out.println("1.당첨번호 등록");
		System.out.println("2.로또 번호 확인");
		System.out.println("3.역대 당첨번호 확인");
		System.out.println("4.로또 자동번호 발행");
		System.out.println("5.로또 수동번호 발행");
		System.out.println("6.종료");
		System.out.println("---------메뉴---------");
		System.out.print("메뉴 선택 : ");
	}	
	
	public void printAlert() {
		System.out.println("------------------");
		System.out.println("잘못된 메뉴 입니다.");
		System.out.println("------------------");
	}	
	public void printExit() {
		System.out.println("------------------");
		System.out.println("프로그램 종료");
		System.out.println("------------------");
	}

}
