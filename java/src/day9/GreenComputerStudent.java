package day9;

import day8.Card;

/* 그린 컴퓨터 아트 학원 수강생(전 지점)을 관리하기 위한 클래스
 * 멤버변수 : 수강생(이름, 나이, 연락처, 등록일, 등록강좌) 
 * 기능 : 횟수기록(지각,결석), 수강현황 출력 
 * */
public class GreenComputerStudent {							// 학생 한명 정보
	
	private String name;
	private int age, phone, course;
	
	public void coursePrint() {
		System.out.println(course + " 수강중");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}



	
}

class Allgreen {
	
	private GreenComputerStudent[] all = new GreenComputerStudent[1000];
	
	public Allgreen() {
		for(int i=0 ; i<all.length ; i++ ) {
			all[i] = new GreenComputerStudent();
		}	
	}
	
    
}	


