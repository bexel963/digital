package day11;

public class 예외처리4 {

	public static void main(String[] args) {
		char op = '?';
		try {
			switch(op) {
			case '+': case '-': case '*' : case '/' : case '%' :
				System.out.println(op + "는 산술 연산자 입니다.");
				break;
			default:
				//op가 산술 연산자가 아닌 경우 산술 연산자가 아니라는 예외를 발생
				//throw를 이용해서 예외 발생시킬 경우에는 객체가 필요
				RuntimeException e  = new RuntimeException(op + "는 잘못된 산술 연산자 입니다."); 
				throw e;
				//=throw new RuntimeException();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
