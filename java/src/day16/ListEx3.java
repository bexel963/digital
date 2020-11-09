package day16;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx3 {

	public static void main(String[] args) {
		ArrayList<Point3D> list = new ArrayList<Point3D>();
		Point3D p = new Point3D(0,0,0);
		list.add(p);				// 객체는 주소를 넣는다.( 공유한다. )
		//p.x = 1;					// x
		p = new Point3D(1,0,0);		// 새로 객체 만들어서 넣어줘야함
		list.add(p);
		
		Iterator<Point3D> it = list.iterator();
		while(it.hasNext()){
			Point3D tmp = it.next();
			System.out.println(tmp);
		}

	}

}

class Point3D{
	int x,y,z;

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	public Point3D(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
}