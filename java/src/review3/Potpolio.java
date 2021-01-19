package review3;

import java.util.Scanner;

public class Potpolio {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double result = 0;
		int num1, num2;
		char op;
		
		System.out.println("두 정수와 산술 연산자를 입력하세요.");
		num1 = scan.nextInt();
		op = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		result = oper(num1, op, num2);
		
		System.out.println(num1 +" "+ op +" "+ num2 + " = " + result);
		
		scan.close();
	}
	
	public static double oper(int num1, char op, int num2) {
		double result = 0;
		switch(op) {
			case '+' : 
				result = num1 + num2;
				break;
			case '-' : 
				result = num1 - num2;				
				break;
			case '*' : 
				result = num1 * num2;				
				break;
			case '/' :
				if(num2==0) {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				result = (double)num1 / (double)num2;
				break;
			case '%' :
				if(num2==0) {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				result = (double)num1 % (double)num2;
				break;
			default :
				System.out.println("산술 연산자가 아닙니다.");		
			}
		return result;
	}
	
}
