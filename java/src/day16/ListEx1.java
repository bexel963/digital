package day16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ListEx1 {

	public static void main(String[] args) {
		// ArrayList<클래스명A> 객체명 = new ArrayList<클래스명A>();
		// 저장할 데이터의 클래스 명이 클래스명A ( 클래스명을 잘 선정 해야한다. )
		// ex) 예를 들어 오늘의 할일을 ArrayList에 저장하려고 한다. 이때 클래스명 A에 적당한 클래스는? String
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("오전수업");
		list.add("점심");
		list.add("오후수업");
		list.add("하원");
		list.remove(0);					// 0번지에 있는 데이터 삭제
		list.remove("점심");				// 점심.equals()의 결과가 true인 정보를 삭제
		list.add("저녁");
		
		ArrayList<String> eat = new ArrayList<String>();
		
		eat.add("점심");
		eat.add("저녁");
		list.retainAll(eat);			// list에 있는 데이터 중 eat에 있는 목록만 남음
		list.add("운동");
		list.add("복습");
		list.add("취침");
//		list.sort(new Comparator<String>() {				// Comparator라는 인터페이스를 구현한 클래스. new라는 연산자로 익명 객체를 만듦
//
//			@Override
//			public int compare(String o1, String o2) {		// sort는 Comparator의 기능인 compare가 필요
//				
//				return -o1.compareTo(o2);					// 사전 거꾸로(내림차순)으로 정렬
//			}
//			
//		});
		list.sort(new Test());								// 31 ~ 39번 코드와 같음
		
		System.out.println("-----오늘의 할일-----");
		for(int i=0 ; i<list.size(); i++) {
			System.out.println(list.get(i));		// i번지에 있는 데이터를 가져옴
		}
		System.out.println("------------------");
		
		Iterator<String> it = list.iterator();		//*******많이쓰임(중요!)(암기)
		while(it.hasNext()) {						// 앞을 기준으로 다음장소에 데이터 있으면 true 반환
			String tmp = it.next();					// 다음에 있는 데이터를 가죠옴
			System.out.println(tmp);
		}
		
	}

}
class Test implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		return -o1.compareTo(o2);
	}

}
