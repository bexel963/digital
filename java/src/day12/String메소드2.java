package day12;

import java.util.Scanner;

public class String메소드2 {

	public static void main(String[] args) {
		/* 5개짜리 문자열 배열을 생성한 후, 5개의 파일명을 입력받는 코드를 작성하세요.
		 * ex) String메소드.java / 그림1.png
		 * 입력받은 파일 중에 이미지 파일들을 출력하는 코드를 작성하세요.
		 * 
		 * index = str1.indexOf(search2);
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		String[] fileName = {"java의 정석.txt", "String메소드.java", "java의 정석 앞표지.png", "java의 정석 뒷표지.png", "java의 정석.hwp"};
		
//		String[] str = new String[5];
		
//		for( int i=0 ; i<str.length ; i++ ) {
//			System.out.print((i+1) + "번째 파일명을 입력 하세요 : ");
//			str[i] = scan.next();
//		}
		
		System.out.println(fileName[0].lastIndexOf('.'));	// 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치를 알려준다.
		
		String[] img = { "png", "jpg", "bmp", "gif" };
		System.out.println(" - 이미지 파일 리스트 - ");
		
		int a = fileName[0].lastIndexOf('.');
		System.out.println(a);
		
		System.out.println(fileName[0].substring(9));
		
		
		
		for(String tmpFileName : fileName) {
			int index = tmpFileName.lastIndexOf('.');
			String suffix = null;
			if(index == -1) {
				continue;
			}
			suffix = tmpFileName.substring(index + 1);		//  주어진 시작위치부터 끝 위치 범위에 포함된 문자열을 얻는다.
			
//			for(String tmpImg : img) {
//				if(tmpImg.equals(suffix)) {
//					System.out.println(tmpFileName);
//				}
//			}
			
			if(contains(img, suffix)) {
				System.out.println(tmpFileName);
			}
		}
	
		scan.close();

	}
	/* 기능 : 배열과 찾을 문자열이 주어지면 배열에서 찾을 문자열이 있는지 없는지 확인하여 알려주는 메소드
	 * 
	 * */
	public static boolean contains(String[] arr, String search) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		if(search == null) {
			return false;
		}
		for(String tmp : arr) {
			if(search.equals(tmp)) {
				return true;
			}
		}
		return false;
	}

}
