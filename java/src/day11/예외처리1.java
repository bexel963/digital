package day11;

public class 예외처리1 {

	public static void main(String[] args) {
		try {
			System.out.println(calc(1, '/', 0));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calc(2, '?', 3));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calc(2, '%', 0));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	/* 기능 : 두 정수와 산술 연산자가 주어지면 주어진 산술연산결과를 알려주는 메소드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메소드명 : calc
	 * calc 메소드에 static을 붙이는 이유 : 안 붙이면 객체 멤버 메소드가 되는데, 객체 멤버 메소드는 클래스 멤버 메소드인 main에서 호출할 수 없기 때문에 static을 붙여서 클래스 멤버 메소드로 만들어야한다.
	 * */
	/* 메소드에서 throw를 하면 메소드 선언부에 throws를 이용하여 발생할 수 있는 예외를 적어 주어야한다. 단, RuntimeException을 상속받은 클래스는 제외
	 * */
	public static double calc( int num1, char op, int num2 ) throws Exception {
		if((op == '/' || op == '%') && num2 == 0) {
			throw new Exception("0으로 나눌 수 없습니다.");
		}
		switch(op) {
		case '+' : return num1 + num2;
		case '-' : return num1 - num2;
		case '*' : return num1 * num2;
		case '/' : return (double)num1 / num2;
		case '%' : return num1 % num2;
		//default : throw new RuntimeException(op + "는 산술 연산자가 아닙니다."); // 예외
		default : throw new Exception("예외발생 : " + op + "는 산술 연산자가 아닙니다.");
		
		}
	}
}




