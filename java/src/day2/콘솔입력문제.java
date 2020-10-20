package day2;

import java.util.Scanner;

public class 콘솔입력문제 {

	public static void main(String[] args) {
		//정수와 문자와 정수를 입력 받으세요.
				//예시
				//정수 문자 정수를 입력하세요(예: 1 + 2)
				//입력받은 값 : 1 + 2
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char op;
		
		System.out.print("정수 문자 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		op = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		System.out.println("입력받은 값 : " + num1 +" "+ op +" "+ num2);
		System.out.printf("입력받은 값 : %d %c %d\n", num1, op, num2);
		
		scan.close();
		////println()은 엔터가 들어있음 -> 괄호안에 아무것도 안써도 에러안남
		////print()는 엔터가 안들어있음 -> 괄호안에 문자열 써넣어줘야함
	}

}
