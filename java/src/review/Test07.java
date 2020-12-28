package review;

import java.util.HashMap;
import java.util.Iterator;

public class Test07 {

	public static void main(String[] args) {
		// list의 get()은 번지를 가져오고 map의 get()은 key값을 가져와서 map은 반복문을 사용하기 힘들다.
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("2020160001", "홍길동");	// put은 map에 데이터 넣는 함수
		map.put("2020160002", "임꺽정");
		
		Iterator<String> it = map.keySet().iterator();		// keySet() - 학번들을 하나의 set으로 모은다.( 학번은 중복이 안되서 ), 그 set을 iterator()를 통해서 하나씩 가져온다.
		while(it.hasNext()) {
			String key = it.next();		// 
			String value = map.get(key);	
			System.out.println("학번 : " + key + ", 이름 : " + value);
		}

	}

}
