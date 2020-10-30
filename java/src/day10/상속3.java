package day10;

public class 상속3 {

	public static void main(String[] args) {
		/* 모든 클래스의 최고 조상은 Object 클래스 이다. (모든 클래스는 Object 클래스를 상속받고 있기 때문에 Object 클래스에서 제공하는 메소드를 사용 할 수 있고, 오버라이딩 할 수 있다.)
		 * 
		 * */
		A1 a = new A1();
		System.out.println(a.hashCode());
		System.out.println(a);	// 참조변수 객체를 출력하면, 객체의 toString() 메소드가 실행된다. -> A1클래스에 toString() 메소드가 없기 때문에 부모께(Object 클래스) 호출된다.
		
	}

}
class A1 {
	
	int num;

	@Override					// 부모 클래스에 있는 toString() 메소드를 오버라이딩 해서(자식 클래스에서 수정해서) 사용 할 수 있다.
	public String toString() {
		return "A1 [num=" + num + "]";
	}
	
}
