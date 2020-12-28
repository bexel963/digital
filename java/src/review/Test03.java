package review;

public class Test03 {

	public static void main(String[] args) {
			
		Point pt1 = new Point();
		Point pt2 = new Point();
		
		pt1.move(1,1);
		pt1.print();
		
		move(pt1,2,2);
		pt1.print();
		
		pt2.print();
		pt1.move(pt2);
		pt1.print();
	}
	
	public static void move(Point pt, int x, int y) {
		if(pt == null) {
			return;
		}
		pt.move(x, y);
	}
	

}
class Point {
	private int x,y;
	
	public Point() {};
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/* 현재 좌표에서 새로운 좌표 x,y로 이동시키는 메소드 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	/* 오버로딩
	 * - 동일한 이름을 가진 메소드가 2개 이상인 경우
	 * - 다음 중 한가지 조건을 만족해야한다.
	 * 		- 1. 매개변수의 갯수가 다른 경우
	 * 		- 2. 매개변수의 타입이 다른 경우
	 * */
	/* 현재 좌표에서 새로운 좌표 pt(Point클래스의 객체)로 이동시키는 메소드 */
	public void move(Point pt) {
		move(pt.x,pt.y);
	}
	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}
}
