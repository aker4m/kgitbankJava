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
		/*Point2d p2 = new Point3d(); //�ڵ�����ȯ
		Point3d p3 = (Point3d)p2;*/
		/*
		 * 1.�θ��� ��ü�� �ݵ�� ��ĳ���� ���¿��� �Ѵ�.
		 * 2.�ڽ��� �̸����� ����ȯ�� ����� �Ѵ�.
		 */
		/*
		Point3d p3 = new Point3d();
		Point2d p2 = p3; //��ĳ����, �ڽ��� �����ڷ� �θ��� ��ü�� ����� ��
		//����� �θ� ������ ����� ��� ����
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
//Ŭ������ ������ ���Կ��길 �����ϰ�,
//���Կ����� ���� Ŭ�����̰ų�, ��Ӱ����϶��� �����ϴ�.

