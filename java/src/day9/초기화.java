package day9;

public class 초기화 {

	public static void main(String[] args) {
//		int num;
//		num = 10; // 초기화 : 변수에 값을 처음으로 저장하는 것, 지역변수는 자동으로 초기화 되지 않음.
		
		Test t = new Test();
		System.out.println(t.num1);
		System.out.println(t.num2);
		System.out.println(t.num3);
		System.out.println(t.num4);

	}

}

//교제 p.301
class Test{
	int num1 = 10;		// 1. 명시적 초기화 : 멤버변수를 선언과 동시에 초기화 하는 방법
	int num2 = 10;		
	int num3 = 10;
	int num4;
	{
		num3 = 30;		// 3. 초기화 블럭 : 초기화 블럭에서 멤버변수를 초기화
		num2 = 30;
	}
	
	public Test(){
		num2 = 20;		// 2. 생성자 : 생성자를 이용한 멤버변수 초기화
	}
	//p.304 - 멤버변수 초기화 순서 : 기본감 > 명시적 > 초기화 블록 > 생성자
}
