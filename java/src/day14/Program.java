package day14;

/* 
 - 당첨번호 등록 ( 마지막에 있는게 가장 최신꺼 ) 등록-register / 당첨-lucky
 - 로또 번호 확인 ( 최신꺼 확인 ) -> 등수 확인
 - 역대 당첨번호 확인 ( 등록한 당첨번호들 출력 )
 - 로또 자동 번호 발행	auto / issue
 - 로또 수동 번호 발행   hand
*/
public interface Program {
	void luckyNumRegis();
	void lottoNumPrint();
	void luckyNumConfirm();
	void autoNumIssue();
	void handNumIssue();
	boolean isContain(int[] arr, int num);
}
