package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx1 {						// ex) id, password 관리

	public static void main(String[] args) {
	
		/*
		HashMap<A, B> map = new HashMap<A, B>();					/ A,B는 클래스명 ( A는 A끼리 B는 B끼리 클래스명이 동일해야한다. )
		
		Set set = map.entrySet();					
		
		Iterator<Map.Entry<A, B>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<A, B> tmp = it.next();
			
		}
		*/
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("abc123", "abcdefg1234567");		// 데이터 저장(key, value)
		map.put("abc123",  "abc1234");				// key 중복
		map.put("qwe123",  "qwe123");
		map.put("asd123", "qwe123");				// value 중복
		
		Set set = map.entrySet();					// map을 Set으로 변환. (key, value를 클래스로 묶어서 넣어준다.)( Iterator를 쓰기위해 )
													// map은 번지가 아니라 key로 접근하기 때문에 반복문을 못쓴다.
		Iterator<Map.Entry<String, String>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> tmp = it.next();
			System.out.println("ID : " + tmp.getKey() + ", PW : " + tmp.getValue());
		}
		
		

	}

}
