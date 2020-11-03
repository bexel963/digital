package day12;

public class Math클래스2 {

	public static void main(String[] args) {
		int num = Integer.MAX_VALUE;			// int형 정수 중 가장 큰 수
		System.out.println("처음 num : " + num);
		num++;
		System.out.println("1증가 후 num : " + num);
		
		num = Integer.MAX_VALUE-1;
		// ~~Exact 메소드는 연산 결과에서 오버플로우가 발생되면 예외를 발생 시키는 메소드
		// 오버플로우가 발생되면 연산을 하지 않음.
		try {										
			System.out.println("-------------------------");
			System.out.println("처음 num : " + num);
			num = Math.incrementExact(num);		// num++
			System.out.println("1증가 후 num : " + num);
			num = Math.incrementExact(num);
		}catch(Exception e) {
			System.out.println("오버플로우 발생");
			System.out.println("2증가 후 num : " + num);
		}
		
		//pow(a,b) : a의 b제곱 함수
		int a = 2, b = 3;
		System.out.println(a + "의 " + b + "제곱 : " + Math.pow(2, 3));
		
		//sqrt(c) : c의 제곱근 함수
		int c = 4;
		System.out.println(c + "의 제곱근 : " + Math.sqrt(c));
	}

}
