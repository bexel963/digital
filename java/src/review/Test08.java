package review;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Test08 {

	public static void main(String[] args) {
		
		/* 정수 n을 입력 받고 입력받은 수만큼 단어와 뜻을 입력받아 저장하고 출력하는 코드를 작성하세요. */
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Dic> list = new ArrayList<Dic>();
		HashMap<String,String> map = new HashMap<String,String>();
		 
		System.out.print("정수 입력 : ");
		int num = scan.nextInt();
		
//		for(int i=0 ; i<num ; i++) {
//			String word, mean;
//			System.out.print("단어 : ");
//			word = scan.next();
//			System.out.print("뜻 : ");
//			mean = scan.next();
//			map.put(word,mean);
//		}
//		
//		Iterator<String> it = map.keySet().iterator();		
//		while(it.hasNext()) {
//			String key = it.next();		
//			String value = map.get(key);	
//			System.out.println("단어 : " + key + ", 뜻 : " + value);
//		}
		
		while(list.size()<num) {
			Dic d = new Dic();
			System.out.print("단어 : ");
			d.setWord(scan.next());
			System.out.print("뜻 : ");
			d.setMean(scan.next());
			list.add(d);
		}
		for(Dic tmp : list) {
			System.out.println(tmp);
		}
		
		scan.close();
		
	}

}

class Dic{
	private String word;
	private String mean;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	@Override
	public String toString() {
		return "Dic [단어=" + word + ", 뜻=" + mean + "]";
	}
	
}
