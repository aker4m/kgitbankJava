package _24_day;

class Point2d{
	int x;
	int y;
	public Point2d(){
		x=100;
		y=174;
	}
	public void disp(){
		System.out.println("x="+x);
		System.out.println("y="+y);
	}
}

class Point3d extends Point2d{
	int z;
	public Point3d(){
		z=345;
	}
	public void disp(){
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("z="+z);
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		Point2d p2 = new Point3d();
		p2.disp();
		/*Point2d p2 = new Point3d(); //자동형변환
		Point3d p3 = (Point3d)p2;*/
		/*
		 * 1.부모의 객체는 반드시 업캐스팅 상태여야 한다.
		 * 2.자식의 이름으로 형변환을 해줘야 한다.
		 */
		/*
		Point3d p3 = new Point3d();
		Point2d p2 = p3; //업캐스팅, 자식의 생성자로 부모의 객체를 만드는 것
		//멤버는 부모에 설정된 멤버만 사용 가능
		System.out.println("p2.x="+p2.x);
		System.out.println("p2.y="+p2.y);
		//System.out.println("p2.z="+p2.z);
		System.out.println("p3.x="+p3.x);
		System.out.println("p3.y="+p3.y);
		System.out.println("p3.z="+p3.z);*/
		
		/*Point2d p = new Point2d();
		Point2d p1 = p;
		p1.x=1000;
		System.out.println("p.x="+p.x);*/
	}
}
//클래스의 연산은 대입연산만 가능하고,
//대입연산은 같은 클래스이거나, 상속관계일때만 가능하다.

