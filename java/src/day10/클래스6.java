package day10;

public class 클래스6 {

	public static void main(String[] args) {
		
		GreenComputerStudent []std = new GreenComputerStudent[10];
		std[0] = new GreenComputerStudent("홍길동", "2002-05-01", 19, "010-1234-678", "청주");
		std[0].printInfo();
		std[0].printCompany();
		std[0].printCourse();
		std[0].insertCourse("디지털컨버전스 JAVA 양성과정", "2020.10.19 ~ 2021.04.01");
		std[0].printCourse();
		std[1] = new GreenComputerStudent("임꺽정", "의정부");
		std[2] = new GreenComputerStudent("유관순", "청주");
		std[3] = new GreenComputerStudent("이순신", "의정부");
		
		//학생들 중 이순신 학생이 있는지 검색
		String searchName = "이순신";
		for(GreenComputerStudent tmp : std) {
			if( tmp != null && tmp.getName().equals(searchName)) {		// 문자열은 참조변수 이기 때문에 '=='로 비교할 수 없다. 
				System.out.println("------------");						// 	-> 참조변수를 '=='로 비교하면 주소가 일치하면 참, 일치하지 않으면 거짓으로 판명한다.
				tmp.printInfo();										//	   실제로 안에 있는 값이 서로 같더라고 주소가 다르면 다른것으로 판별한다.
				System.out.println("------------");						//	-> 참조변수는 두 참조변수가 같다는 걸 확인하기 위한 equals메소드를 만들어야 한다.(오버라이딩)
			}
		}
		String searchBranch ="청주";
		for(GreenComputerStudent tmp : std) {
			if( tmp != null && tmp.getBranch().equals(searchBranch)) {		
				System.out.println("------------");						
				tmp.printInfo();										
				System.out.println("------------");						
			}
		}		

	}

}

/* - 학생 기본 정보 : 학생이름, 생년월일, 나이, 전화번호
 * - 학원 정보 : 학원이름, 지점
 * - 학생 수강 정보 : 수강과목, 기간
 * - 기능 : 학생 기본 정보 출력, 학생의 학원 정보 출력 기능, 학생 수강 정보 출력 기능, 학생 수강 정보 주가 기능
 * - 생성자 
 *  
 * */
class GreenComputerStudent {
	
	private String name;
	private String birthday;
	private int age;
	private String phoneNumber;
	final static private String company = "그린 컴퓨터 아트 학원";			//	학원 이름은 안 변함.
	private String branch;
	private String []course;			// 수강 과목은 여러개 일수있음
	private String []period;
	private int courseCount;
	
	
	public GreenComputerStudent(String name, String birthday, int age, String phoneNumber, String branch) {
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.branch = branch;
		this.course = new String[10];
		this.period = new String[10];
	}
	
	public GreenComputerStudent(String name, String branch) {		// 전화 왔는데 정보가 이름과 지점 밖에 없을때
		//name = "홍길동";   -> 에러				// this()는 생성자 안에서 가장 처음으로 사용된다. -> this()위에 뭐 있으면 안됨
		this(name, null, 0, null, branch);		// this에 () 들어가면 생성자임. 생성자 함수 호출해서 값 저장함. 
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + phoneNumber);
		System.out.println("나이 : " + age);
		System.out.println("생일 : " + birthday);
	}
	
	public void printCompany() {
		System.out.println("학원명 : " + company);
		System.out.println("지점명 : " + branch);
	}
	
	public void printCourse() {
		if(course == null || course.length == 0 || courseCount == 0) {
			System.out.println("수강 이력이 없습니다.");
			return;
		}
		
		for(int i=0 ; i<courseCount ; i++) {
			System.out.println("과정 : " + course[i]);
			System.out.println("기간 : " + period[i]);
		}
	}
	
	public void insertCourse(String course, String period) {
		this.course[courseCount] = course;
		this.period[courseCount] = period;
		courseCount++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public String[] getPeriod() {
		return period;
	}
	public void setPeriod(String[] period) {
		this.period = period;
	}
	
	
}
