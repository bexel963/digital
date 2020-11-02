package day10;

public class 상속2 {
	
	/* 오버라이딩 : 부모 클래스에게 물려받은 메소드를 자식 클래스에서 재정의 하는것.
	 * 	- 조건 : 	부모 클래스의 메소드와 일치 해야한다. (리턴타입, 메소드명, 메개변수)
	 *  		접근제한자는 같거나 넓은 접근 제한자를 써야한다. => 범위를 축소할 수 없다는 의미
	 * 
	 * */

	public static void main(String[] args) {
		
		Tiger t1 = new Tiger();
		t1.info();
		t1.howl();
		Dog d1 = new Dog();
		d1.info();
		d1.howl();

	}

}

class Animal {									// 여기에 final을 붙이면 상속 할 수 없기 때문에 밑에 자식 클래스로 만든 것에 에러가남.
	private String name;
	private String category;					// String 클래스는 final로 되어있어서 상속,오버라이딩을 할 수 없다. Ctrl+마우스 가따 대기 => open inplementaion 에서 코드 확인 가능.
	
	public void info() {
		System.out.println("--------------");
		System.out.println("이름 : " + name);
		System.out.println("분류 : " + category);
		System.out.println("--------------");
	}
	
	public void howl() {						// 여기에 final을 붙이면 오버라이딩 할 수 없기 때문에 Dog와 Tiger 클래스에 howl()메소드에서 에러가 난다.
		System.out.println("울음소리");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}
	public Animal() {}
	
	
}

class Tiger extends Animal {
	// super();					-> 부모의 기본 생성자가 자동으로 추가되는데 부모 클래스에 또 다른 생성자 만들어주면 부모 클래스에 기본 생성자 만들어 넣어줘야함. (55번줄)
	public Tiger() {
		super("호랑이", "고양이과");	// -> super는 부모를 가르키는 참조변수, super()는 부모 클래스의 생성자
//		category = "고양이과";		-> 부모의 멤버변수가 private라 이렇게 하면 안됨.
//		name = "호랑이";
//		setCategory("고양이과");	// -> 부모의 멤버메소드가 public이라 이렇게 하면 됨.
//		setName("호랑이");
	}
	@Override									// 오버라이딩인지 확인 시켜주는 것.
	public void howl() {						// 오버라이딩 ( 부모클래스에 있는 메소드 형태랑 같아야함 - 리턴타입, 메소드명, 메개변수 )
		super.howl();							// super는 부모를 가르키는 참조변수 - 부모클래스의 howl()을 먼저 호출해봄.
		System.out.println("울음소리 : 어흥");
	}

}
class Dog extends Animal {
	public Dog() {
		super("개", "개과");
	}
	@Override
	public void howl() {
		System.out.println("울음소리 : 멍멍");
	}
}
