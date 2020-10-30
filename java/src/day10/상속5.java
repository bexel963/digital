package day10;

public class 상속5 {

	public static void main(String[] args) {
		//Child c = new Child();		-> 만약 Child 클래스가 Parent1, Parent2 모두 상속이 가능 하다면 pinrt()라는 메소드를 실행 했을 때 Parent1과 Parent2 중 누구의 메소드를 
		//c.print();					   실행해야할지 모르기 때문에 부모가 2개이상이 될 수 없다.

	}

}

class Parent1 {
	void print() {
		System.out.println("부모1 입니다.");
	}
}
class Parent2 {
	void print() {
		System.out.println("부모2 입니다.");
	}
}
//class Child extends Parent1, Parent2 {	
//	
//}