package day3;

import java.util.Scanner;

public class 복습문제 {

	public static void main(String[] args) {
		/* 정보처리기사 과목에는 sw1(소프트웨에 설계), sw2(소프트웨어 계발), db(데이터베이스 구축), program(프로그래밍 언어 활용)
		 * info(정보시스템 구축관리)로 구성되어 있다. 
		 * 1. 각 과목의 성적을 입력받고 입력받은 성적을 출력하는 코드를 작성하세요.
		 * 2. 과목 중 한 과목이라도 40점 미만이 있으면 과락이라고 출력.
		 * 3. 과목의 평균을 구하여서 평균이 60점 미만이면 탈락 이라고 출력.
	     */
		
		Scanner scan = new Scanner(System.in);
		
		int sw1, sw2, db, program, info;
		double avg;
		
		System.out.print("성적을 입력 하세요(sw1, sw2, db, program, info) : ");
		sw1 = scan.nextInt();
		sw2 = scan.nextInt();
		db = scan.nextInt();
		program = scan.nextInt();    
		info = scan.nextInt();
		
		avg = (sw1 + sw2 + db + program + info) / 5.0;
		
		System.out.println(sw1 + ", " +sw2 + ", " + db + ", " + program + ", " + info);
		System.out.println("평균 : " + avg);
		
		//조건문에서 실행문이 1줄일때에는 {}생략 가능
		//주의 : 처음 생각에는 실행문이 1줄이어서 {}를 안 썻는데 뒤늦게 실행문이 여러줄이 되었을 때 {}를 추가 하지 안아서 에러나는 실수
		if(sw1 < 40 || sw2 < 40 || db < 40 || program < 40 || info < 40) System.out.println("과락");
		
		else if(avg < 60) System.out.println("탈락");
		
		else System.out.println("합격");
		
		scan.close();
	}

}
