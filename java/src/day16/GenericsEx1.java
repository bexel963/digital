package day16;

public class GenericsEx1 {    //지네릭스 - 메서드나 클래스를 만들 때 멤버 변수 또는 매개변수의 클래스가 고정된 클래스가 아닐 때 사용되는 것 ex) List 등

	public static void main(String[] args) {
		
		Array<Integer> arr = new Array<Integer>(new Integer[10]);
		arr.set(0,  10);
		System.out.println(arr.get(0));
		
		Array<Character> arr2 = new Array<Character>(new Character[10]);
		arr2.set(0, 'a');
		System.out.println(arr2.get(0));

	}

}

class Array<T>{						//Type의 약자 T
	T []arr;						//*** T자리에 다양한 클래스가 올 수 있다.
	public Array(T[] arr) {
		this.arr = arr;
	}
	public Array() {}
	public T get(int i) {			// i번지에 있는 값을 가져옴
		if(arr.length > i)
			return arr[i];
		else
			return null;
	}
	public void set(int index, T value) {			// index 번지에 value T를 넣음
		if(arr.length > index)
			arr[index] = value;
	}
}
