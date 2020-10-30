package day10;
// p.342 static import문
import static java.lang.Math.random;
import static java.lang.System.out;

public class Import예제 {

	public static void main(String[] args) {
		System.out.println(Math.random());	// random()은 클래스 메소드
		System.out.println(random());		// 3번 줄 추가하면 이렇게 써도 됨.
		out.println(random());				// 4번 줄 추가하면 이렇게 써도 됨.

	}

}
