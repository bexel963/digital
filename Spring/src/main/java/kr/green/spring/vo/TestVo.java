package kr.green.spring.vo;

public class TestVo {
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestVo [name=" + name + ", age=" + age + "]";
	}
	
	
}
