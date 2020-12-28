package review3;

import java.util.*;

public class BoardMain {
	private static Scanner scan = new Scanner(System.in);	// 스캐너를 멤버 변수로 만듦.
	public static void main(String[] args) {		// main은 객체 생성 없이 호출
		/* 1. 게시글 등록
		 * 2. 게시글 조회
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 게시글 목륵
		 * 6. 종료
		 * 
		 * 게시글
		 * 	- 번호, 제목, 내용, 작성자, 작성일
		 * 
		 * */
		ArrayList<Board> list = new ArrayList<Board>();
		int menu = 6;
		
		do {
			printMenu();
			menu = scan.nextInt();
			String title, contents, writer;
			Board tmpBoard;
			int num;
			int index = -1;
			int subMenu;
			int count = 0;	// 제목/내용/작성자에 의해 검색된 게시글의 갯수
			switch(menu) {
			case 1:	// 게시글 등록 
				addBoard(list); 
				break;	
			case 2: // 게시글 조회
				System.out.println("-----------------------");
				System.out.println("1. 번호 조회");
				System.out.println("2. 제목 조회");
				System.out.println("3. 내용 조회");
				System.out.println("4. 작성자 조회");
				System.out.println("-----------------------");
				System.out.print("조회 종류 선택 : ");
				subMenu = scan.nextInt();
				switch(subMenu) {
				case 1:	// 번호 조회
					System.out.println("-----------------------");
					System.out.println("죄회할 게시글 번호를 입력하세요");
					System.out.println("-----------------------");
					System.out.print("번호 : ");
					num = scan.nextInt();
					printBoardByNum(list,num);
					break;
				case 2:	// 제목 조회
					printBoard(list,"제목");
					break;
				case 3:	// 내용 조회
					printBoard(list,"내용");
					break;
				case 4:	// 작성자 조회
					printBoard(list,"작성자");
					break;
				default:
					System.out.println("-----------------");
					System.out.println("잘못된 조회 방법 입니다.");
					System.out.println("-----------------");
					break;
				}
				break;	
			case 3:	// 게시글 수정
				System.out.println("-----------------------");
				System.out.println("수정할 게시글 번호를 입력하세요");
				System.out.println("-----------------------");
				System.out.print("번호 : ");
				num = scan.nextInt();
				modifyBoardByNum(list,num);
				break;	
			case 4:	// 게시글  삭제
				System.out.println("-----------------------");
				System.out.println("삭제할 게시글 정보를 입력하세요");
				System.out.println("-----------------------");
				System.out.print("번호 : ");
				num = scan.nextInt();
				deleteBoardByNum(list,num);
				break;	
			case 5:	// 게시글 목록(리스트전체조회)
				for(Board tmp : list) {
					System.out.println(tmp);
				}
				if(list.size() == 0) {
					System.out.println("-----------------------");
					System.out.println("등록된 게시물이 없습니다.");
					System.out.println("-----------------------");
				}
				break;	
			case 6: break;
			default:
				System.out.println("-----------------");
				System.out.println("잘못된 메뉴 입니다.");
				System.out.println("-----------------");
			}
		}while(menu != 6);
		scan.close();
	}
	
	/* 기능 : 메뉴를 출력하는 메소드 
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 -> void
	 * 매소드 명 : printMenu
	 * */
	public static void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 게시글 목록");
		System.out.println("6. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택(1~6) : ");
	}
	
	/* 기능 : 기존에 있는 리스트에 새 게시글을 추가하는 메소드
	 * 게시글 등록 - 제목, 내용, 작성자를 각각 입력받아 String 객체에 저장하고, Board클래스의 객체를 생성하고 list에 추가
	 * 매개변수 : 기존에 있는 리스트
	 * 리턴타입 : 없음 -> void
	 * 메소드 명 : addBoard
	 * */
	public static void addBoard(ArrayList<Board> list){
		if(list == null) {
			throw new NullPointerException("게시글 리스트가 생성되지 않았습니다.");
		}
		System.out.println("-----------------------");
		System.out.println("새로운 게시글 정보를 입력하세요");
		System.out.println("-----------------------");
		System.out.print("제목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();	// 공백 들어가야해서 nextLine() 사용
		System.out.print("작성자 : ");
		String writer = scan.next();
		Board tmpBoard = new Board(title,contents,writer);
		list.add(tmpBoard);
	}
	
	/* 기능 : 주어진 번호와 일치하는 게시글을 출력하는 기능
	 * 확인 하고자하는 게시글의 번호를 입력 하고 입력한 번호에 맞는 게시글이 있는지 리스트에서 확인 후 있으면 출력
	 * 매개변수 : 게시글 리스트, 확인할 게시글 번호 -> ArrayList<Board> list, int num
	 * 리턴타입 : 
	 * 메소드명 : printBoardByNum*/
	public static void printBoardByNum(ArrayList<Board> list, int num){	// 보통 대입 연산자 왼쪽에 있는 변수는 지역변수로 한다.
		// indextOf는 list에 num에 해당하는 값이 있으면 해당주소를 반환하는 메소드, indexOf() 메소드는 objects.equals()를 이용하여 리스트에 있는 값과 메개변수의 값을 비교한 후,
		// 클래스가 같으면 Board.equals()를 호출
		int index = list.indexOf(new Board(num));	
		if(index != -1) {
			Board tmpBoard = list.get(index);
			tmpBoard.print();
			
		}else {
			System.out.println("해당 번호와 일치하는 게시글이 없습니다.");
		}
	}
	
	/* 기능 : 주어진 번호와 일치하는 게시글을 삭제하는 기능
	 * 매개변수 : ArrayList<Board> list, int num
	 * 리턴타입 : void
	 * 메소드 명 : deleteBoardByNum*/
	public static void deleteBoardByNum(ArrayList<Board> list, int num) {
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			list.remove(index);
			System.out.println("-----------------------------");
			System.out.println("게시글이 삭제 되었습니다.");
			System.out.println("-----------------------------");
		}else {
			System.out.println("-----------------------------");
			System.out.println("해당 번호와 일치하는 게시글이 없습니다.");
			System.out.println("-----------------------------");
		}
	}
	
	/* 기능 : 주어진 번호와 일치하는 게시글을 수정하는 기능
	 * 매개변수 : ArrayList<Board> list, int num
	 * 리턴타입 : void
	 * 메소드 명 :  modifyBoardByNum
	 * */
	public static void modifyBoardByNum(ArrayList<Board> list, int num) {
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			System.out.println("-----------------------");
			System.out.println("수정할 게시글 정보를 입력하세요");
			System.out.println("-----------------------");
			System.out.print("제목 : ");
			scan.nextLine();	// 엔터 처리
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String contents = scan.nextLine();
			Board tmpBoard = list.get(index);
			tmpBoard.setTitle(title);
			tmpBoard.setContents(contents);
		}else {
			System.out.println("-----------------------------");
			System.out.println("해당 번호와 일치하는 게시글이 없습니다.");
			System.out.println("-----------------------------");
		}
	}
	
	/* 기능 : 옵션(번호 제외)에 따라 게시글을 출력하는 기능
	 * 매개변수 : 
	 * 리턴타입 :
	 * 메소드명 :
	 * */
	public static void printBoard(ArrayList<Board>list, String option) {
		System.out.println("-----------------------");
		System.out.println("죄회할 게시글 "+option+"을 입력하세요");
		System.out.println("-----------------------");
		System.out.print(option + " : ");
		scan.nextLine();	// 서브메뉴 입력 후 엔터 처리
		String str = scan.nextLine();
		int count = 0;
		// 반복문을 이용하여 일치하는 게시글이 없을때까지 반복
		for(Board tmp : list) {
			// 일치하는 글이 있으면 글을 출력하고 count 증가
			if(tmp.equalsByOption(str, option)) {
				System.out.println(tmp);
				count++;
			}
		}
		// 일치하는 글이 없으면 없다고 출력
		if(count == 0) {
			System.out.println("-----------------------");
			System.out.println("일치하는 게시글이 없습니다.");
			System.out.println("-----------------------");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
