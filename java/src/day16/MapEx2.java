package day16;

import java.util.HashMap;
import java.util.Iterator;

public class MapEx2 {					// MapEx1은 첫번째 방법, MapEx2는 두번째 방법( 두번째 방법 선호 )

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("국어",  100);
		map.put("영어", 60);
		map.put("수학",  40);
		
		System.out.println("수학 : " + map.get("수학"));
		System.out.println();
		
		Iterator<String> it = map.keySet().iterator();			// Key만 따로 빼서 Set으로 묶어줌 ( Key는 중복이 안되서 Set으로 빼더라도 원본에 이상이 없다. )
		while(it.hasNext()) {									// map.keySet()는 Set으로 나옴 -> Set으로 반환해서 it에 저장
			String key = it.next();
			System.out.println(key + " : " + map.get(key));		
		}
		
	

	}

}
