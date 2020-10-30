package day10;

public class 인터페이스 {		// 많이 사용됨. - 프로젝트 시작전에 기능만 나열함.

	public static void main(String[] args) {
		Tv t = new Tv();
		t.turnOn();
		System.out.println(t.power);	// 됨.
		
		Power p = new Tv();				// interface를 이용하여 객체를 생성 할 수 없다. ( 기능 구현이 안되어있어서 ) == 추상클래스
		p.turnOn();
		//System.out.println(p.power);	- 에러. power 클래스에 Tv 클래스에만 있는 power 라는 변수가 없어서. 
	}

}

/* 인터페이스 : 추상메소드와 클래스 상수로만 이루어진 것
 * 추상클래스 : 추상메소드 + 일반메소드 + 변수 + 상수로 이루어진 것
 * 인터페이스는 다중 상속 가능. ( 실행부가 구현이 안되어있어서. 클래스의 경우에는 무엇을 실행해야 할지에 대한 문제 때문에 다중상속 안됨 ), 다중 구현 가능
 * 
 * */

interface Power {
	public abstract void turnOn();
	public abstract void turnOff();
}
interface Remotecon {
	public void channelUp();
	public void channelDown();
}

class Tv implements Power, Remotecon {				// 다중상속 가능				// 표현 : interface를 구현한다. Tv를 구현 클래스라고 한다.
	
	boolean power;
	
	@Override
	public void turnOn() {
		power = true;
		System.out.println("전원이 켜졌습니다.");
	}

	@Override
	public void turnOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}

	@Override
	public void channelUp() {
		System.out.println("채널 업");
	}

	@Override
	public void channelDown() {
		System.out.println("채널 다운");
		
	}
	
}
