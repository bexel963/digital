package day12;

public class Object클래스 {

	public static void main(String[] args) {
		/* Object클래스에서 제공하는 메소드
		 * 1. equals()
		 * 		- 기본적으로 주소를 비교하기 때문에 하나의 객체를 공유할 때만 같다라고 인식함.
		 * 		- 일반적으로 클래스가 같은지 비교를 자주한느 경우 equals를 오버라이딩을 한다. (실제 멤버변수의 값을 비교하고싶을때)
		 * 
		 * 2. hashCode()
		 * 		- 해쉬코드 값을 그룹화하여 검색이 쉽도록 함
		 * 
		 * 3. toString
		 * 		- System.out.println에 객체를 넣어주면 자동으로 객체.toString()이 호출되어 문자열이 출력됨
		 * 		- 이때 원하는 정보를 문자열로 보여주기 위해서는 오버라이드된 toString()이 필요하다.
		 * 
		 * 4. clone
		 * 		- 객체를 복사하는 메소드
		 * 		- Cloneable 인터페이스를 구현해야 예외가 발생하지 않는다.
		 * 
		 * 5. getClass()
		 * 		- 클래스의 정보를 간단하게 알려줌.
		 * */
		
		Student std1 = new Student("홍길동", 20);
		Student std2 = new Student("홍길동", 20);
		System.out.println(std1.equals(std2));
		System.out.println(std1);		// day12.Student@33a49db 출력 (뒤에 숫자는 해쉬코드)
		Student std3 = (Student)std1.clone();
		std3.age = 30;
		
		System.out.println(" 원본 : " + std1);
		System.out.println("복사본 : " + std3);
		
		Class cObj = std3.getClass();		// 클래스의 정보를 간단하게 알려줌
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
	}

}
class Student implements Cloneable{
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {		// 분류해서 그룹으로 만들어서 비교하기 쉽게 해주는 역할
		final int prime = 31;	//2의 n 제곱 중에서 가장 가까운수 선택
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)						// 같은 객체를 공유하고 있는 경우 같다라고 판별
			return true;						// equals가 동작했다는 것은 this가 null이 아니라는 의미
		if (obj == null)						// 비교할 대상이 null이면 비교할 필요가 없기 때문에 다르다고 판별
			return false;
		if (getClass() != obj.getClass())		// 두 객체가 서로 다른 클래스의 객체이면 다르다고 판별
			return false;
		Student other = (Student) obj;			// 비교대상 obj는 Student 클래스의 객체이다. (42번줄 때문에)
												// obj를 Student클래스로 형변환 할 수 있다. (부모를 자식으로 변환하는 경우 명시적으로 형변환 해야한다.)
		if (age != other.age)					// 나이가 다르면 다르다고 판별
			return false;
		if (name == null) {						// 내 이름이 null이고 비교 대상 이름이 null이 아니면 다르다고 판별
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))	// 내 이름이 있으면 대상 이름과 equals를 이용하여 비교하여 같으면 같고 다르면 다르다고 판별
			return false;						// 이때 equals는 String클래스의 equals이다.
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		}catch(CloneNotSupportedException e) {}
		return obj;
	}
	
	
	

}