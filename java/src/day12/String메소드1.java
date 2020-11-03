package day12;

public class String메소드1 {

	public static void main(String[] args) {
		String str = "Green Computer";					// scanner할때 많이 씀.
		System.out.println("----charAt----");			// charAt(index) : index 번지에 있는 문자를 반환
		System.out.println(str.charAt(0));				
		System.out.println();
		
		System.out.println("----compareTo----");		// compateTo(str) : str문자열과 비교하여 같으면 0, 사전순으로 앞이면 -1, 뒤면 1
		System.out.println("b".compareTo("b"));			
		System.out.println("b".compareTo("a"));
		System.out.println("b".compareTo("c"));
		System.out.println();
		
		System.out.println("----concat----");			// concat : 이어 붙이기, +연산자와 같은 기능
		System.out.println("Hello ".concat("wolrd"));	
		System.out.println("Hello " + "wolrd");
		System.out.println();
		
		System.out.println("----equals----");			// 두 문자열이 같은지 다른지를 확인
		System.out.println("Hello".equals("Hello"));
		System.out.println("Hello".equals("hello"));
		System.out.println();
		
		System.out.println("----indexOf----");			// 문자 찾기 (매우중요)
		String str1 = "Hello world";
		char search1 = 'w';
		int index = str1.indexOf(search1);
		if(index >= 0) {
			System.out.println(str1 + " 문자열에는 " + search1 + "이(가) " + index + "위치에 있습니다.");
		}
		
		String search2 = "world";						// 문자열 찾기도 가능
		index = str1.indexOf(search2);
		if(index >= 0) {
			System.out.println(str1 + " 문자열에는 " + search2 + "이(가) " + index + "위치에 있습니다.");
		}
		
		index = str1.indexOf(search1, 7);				// n번째 번지부터 문자 찾기
		if(index >= 0) {
			System.out.println(str1 + " 문자열에는 " + search1 + "이(가) " + index + "위치에 있습니다.");
		}
		else {
			System.out.println(str1 + " 문자열에는 " + search1 + "이(가) " + "7번째 이후로는 찾을 수 없습니다.");
		}
		System.out.println();
		
		System.out.println("----replace----");			// 문자(열) 바꾸기
		System.out.println("Hello World World".replace('W', 'w'));
		System.out.println("Hello world world".replace("world", "java"));
		System.out.println();
		
		System.out.println("----split----");			// 문자열을 배열로 만들어줌
		String[] arr = "dog,cat,tiger".split(",");		// ,n n개만큼 짜름
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		System.out.println();
		
		System.out.println("----join----");				// 배열을 문자열로 만들어줌
		System.out.println(String.join(",", arr));
		System.out.println();
		
		System.out.println("----substring----");		// 주어진 시작위치부터 끝 위치 범위에 포함된 문자열을 얻는다.
		String fileName = "String메소드.java";
		int index2 = fileName.lastIndexOf('.');
		String suffix = fileName.substring(index2 + 1);
		System.out.println(fileName + " 의 확장자 : " + suffix);
		System.out.println();
		
		System.out.println("----trim----");				// 문자열 앞,뒤로 공백 제거
		System.out.println("    Hello    ".trim());
		System.out.println();
		
		System.out.println("----valueOf----");			// 문자열이 아닌 애를 문자열로 만들어줌.
		System.out.println(String.valueOf(1.23));
		String str3 = "" + 123;							// 이렇게 하면 문자열로 저장
		System.out.println();
		
		System.out.println("----Integer.parseInt----");	// 문자열을 문자열이 아닌 애로 바꿈
		int num1 = Integer.parseInt(str3);
		System.out.println(num1);
		int num2 = Integer.valueOf(str3);
		System.out.println(num2);
	}

}
