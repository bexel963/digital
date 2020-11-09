package day16;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx1 {

	public static void main(String[] args) {					// 잘 안쓰임.
		
		HashSet<String> set = new HashSet<String>();			// List와 조상이 같아서 기능이 비슷하다.
		set.add("홍길동");
		set.add("유관순");
		set.add("임꺽정");
		set.add("이순신");
		//set.get();											// get은 없다.
		set.add("홍길동");										// 중복X
		
		Iterator<String> it = set.iterator();					// 저장순서 보장X
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp);
		}

	}

}
