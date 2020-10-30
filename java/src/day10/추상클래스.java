package day10;

public class 추상클래스 {						// 잘 사용되진 않지만 개념은 확실히 알아야 한다.

	public static void main(String[] args) {
		//Animal2 a = new Animal2();		// 추상 클래스를 이용하여 객체를 생성 할 수 없다. ( 선언은 할 수 있다. ) 
		Animal2 b = new Dog2();
		b.howl();
	}

}

abstract class Animal2 {				// 추상 메소드가 있는 클래스를 추상 클래스라고 한다.
	public String name;
	public String category;
	public void info() {
		System.out.println("-------------");
		System.out.println("이름 : " + name);
		System.out.println("분류 : " + category);
		System.out.println("-------------");
	}
	public abstract void howl();		// 어차피 자식 클래스에서 오버라이딩 할꺼라 구현 할 필요 없다.
}

class Dog2 extends Animal2 {

	@Override
	public void howl() {				// 추상 클래스를 상속받은 클래스가 추상 클래스가 아니면 부모의 추상 메소드를 반드시 구현해야한다. (오버라이딩)
		System.out.println("멍멍");
		
	}			
}

