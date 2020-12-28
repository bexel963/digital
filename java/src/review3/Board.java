package review3;

import java.text.SimpleDateFormat;
import java.util.Date;

// 게시글 1개를 관리하기 위해 Board 클래스를 만듦
public class Board {
	private int num;
	private static int count;		// 게시글 번호(num)를 할달하기 위해 만듦.
	private String title;
	private String contents;
	private String writer;
	private Date registerDate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWirter(String wirter) {
		this.writer = wirter;
	}
	public String getRegisterDate() {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");	// day15 - TimeMain2.java
		return simpleFormat.format(registerDate);
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Board() {
		++count;
		num = count;
		registerDate = new Date();
	}
	public Board(int num) {
		this.num = num;
	}
	public Board(String title, String contents, String writer) {
		this();		// 해당하는 클래스의 생성자 호출( 기본생성자 호출 - public Board() )
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	public Board(Board board) {		// 복사 생성자
		this.num = board.num;
		this.registerDate = board.registerDate;
		this.title = board.title;
		this.contents = board.contents;
		this.writer = board.writer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {		// 매개변수가 Board면 형변환 코드가 필요 없다. ( 다형성 )
		if (this == obj)	// 하나의 객체를 다른 두 참조변수가 공유
			return true;
		if (obj == null)	// 참조변수 obj가 객체와 연결이 안된 상태 ( 비교 대상이 없는 경우 )
			return false;
		// generate hashCode() and equals()를 이용하면 기본적으로 클래스가 다르면 다르다고 판별 하지만, Board클래스에서는 게시글 번호를 이용하여 같다 다르다를 판단 하기 때문에, 클래스가 Integer인 경우에 비교가 가능하도록 수정.
		if (getClass() != obj.getClass()) {		
			if(obj instanceof Integer) {	// 형변환 가능한지 물어봄 - 여기서는 obj 클래스가 Integer로 형변환 가능한지 확인
				if(num == (Integer)obj) {
					return true;
				}
			}else {
				return false;
			}
		}
		Board other = (Board) obj;	// 형변환
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "게시글 [번호=" + num + ", 제목=" + title + ", 작성자=" + writer
				+ ", 작성일=" + getRegisterDate() + "]";
	}
	public void print() {
		System.out.println("-------------------------------");
		System.out.println("번호 : " + getNum());
		System.out.println("제목 : " + getTitle());
		System.out.println("작성자 : " + getWriter());
		System.out.println("작성일 : " + getRegisterDate());
		System.out.println("<내용>");
		System.out.println(getContents());
		System.out.println("-------------------------------");
	}
	public boolean equalsByOption(String str, String option) {
		// 수정 제목 
		if(option.equals("제목")) {
			/*if(title.indexOf(str) != -1) {
				return true;
			}else {
				return false;
			}*/
			return title.indexOf(str) != -1 ? true : false;
		}else if(option.equals("내용")) {
			return contents.indexOf(str) != -1 ? true : false;
		}else if(option.equals("작성자")) {
			return writer.indexOf(str) != -1 ? true : false;
		}else {
			return false;			
		}
	}
	
}
