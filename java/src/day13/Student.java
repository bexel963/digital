package day13;

/* 과목 클래스를 생성하세요. 단, 클래스는 새로 만들기를 이용하여 만드세요.
 * 	- 학생 클래스에 필요한 멤버 변수 / 메소드를 생성하세요.
 *  - 학생 클래스 : 한 학생의 정보를 나타내는 클래스
 *  - 변수 : 학생이름, 주민번호, 학번, 학부, 학과, 수강과목들, 학기(현재 학생이 수료한 학기)
 *  - 멤버 메소드 : 
 *  	- getter/setter
 *  	- 출력 기능(print 메소드로 - 수강과목들 때문에)
 *  	- 수강 과목 추가, 수강 과목 삭제
 * 		- 수강 과목 복사(private) : 수강 과목 추가시 배열이 다 차있으면 배열의 크기를 늘림
 * 		- equals() : 오버라이딩
 * 
 *  - 생성자
 *  
 * */

public class Student {
	private String name;
	private String residentNum;
	private String studentNum;
	private String faculty;
	private String major;
	private Subject[] subjectList; //////////////////////////////////////
	private int term;
	private int subjectCount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResidentNum() {
		return residentNum;
	}
	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Subject[] getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(Subject[] subjectList) {
		this.subjectList = subjectList;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public Student(String name, String residentNum, String studentNum, String faculty, String major, int term) {
		super();
		this.name = name;
		this.residentNum = residentNum;
		this.studentNum = studentNum;
		this.faculty = faculty;
		this.major = major;
		this.term = term;
		subjectList = new Subject[2];	///////////////////////////////
	}
	
	public Student() {}
	
	//수강 과목 추가
	public void insertSubject(Subject subject) {				// 멤버변수의 값을 설정할때에는 리턴 타입이 거의 void 이다.
		if(subjectCount == subjectList.length) {				// 배열이 꽉 찬경우 배열을 늘려주고 복사하는 작업
			Subject [] tmp = new Subject[subjectCount+10];
			System.arraycopy(subjectList, 0, tmp, 0, subjectList.length);
			subjectList = tmp;
		}
		subjectList[subjectCount] = subject;
		subjectCount++;
		
	}
	
	//수강 과목 삭제
	public void deleteSubject(String subjectTitle) {
		
		int index = -1;			// 삭제할 과목이 있는 배열의 위치
		
		if(subjectTitle ==null) {				// 배열이 비어있음.
			return;
		}
		for(int i=0 ; i<subjectCount ; i++) {
			if(subjectTitle.equals(subjectList[i].getSubjectTitle())) {		// 삭제할 과목 있는지 찾기
				index = i;
				break;
			}
		}
		if(index == -1)								// 해당 과목을 못찾음.
			return;
		for(int i=index ; i<subjectCount-1 ; i++) {		
			subjectList[i] = subjectList[i+1];					// 삭제할 과목 다음에 있는 칸을 삭제한 과목 칸에 덮어쓰기
		}
		subjectList[subjectCount-1] = null;						// 한칸씩 위로 올리고 남은 마지막칸 과목 지우기
		subjectCount--;
		
	}
	
	public void print() {
		if(subjectCount == 0 ) {
			System.out.println("---수강한 과목이 없습니다.---");
		}
		for(int i=0 ; i<subjectCount ; i++) {
			System.out.println(subjectList[i]);
		}
	}
	@Override
	public String toString() {
		return "이름 : " + name + "\n 주민번호 : " + residentNum + "\n 학번 : " + studentNum + "\n 학부="
				+ faculty + "\n 전공 : " + major + "\n 학기 : " + term + "\n 수강 과목수 : " + subjectCount;
	}
	
	

	
	
	
	
	
	
	
	
	
	
/*
	public void insertTitle1(String subjectTitle) {
		subjectList[subjectCount] = new Subject();
		subjectList[subjectCount].setSubjectTitle(subjectTitle);
		subjectCount++;
	}

*/
	/*
	public void insertSubject(Subject subject) {				// 멤버변수의 값을 설정할때에는 리턴 타입이 거의 void 이다.
		//현재 수강한 과목의 개수를 모를때(강사.ver)
		for(int i=0 ; i<subjectList.length ; i++) {
			if(subjectList[i] == null) {
				subjectList[i] = subject;
				break;    		// 과목 중복되면 안되서 배열 한칸에 과목 넣고 바로 빠져나간다.
			}
		}
	}
	// 수강 과목 복사
	public void copyList() {
		if(subjectCount > subjectList.length) {
			Subject []tmp = new Subject[subjectCount*2];
			for(int i=0 ; i<subjectList.length ; i++) {
				tmp[i] = subjectList[i];
			}
			subjectList = tmp;
		}
	}
	// 수강 과목 삭제
	public void DeleteList(String Title) {
		for(int i=0 ; i<subjectList.length ; i++) {
			
		}
	}
	
*/
}
