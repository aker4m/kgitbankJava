package _24_day;
class A04{
	int a = 10;
	//�� Ŭ������ ObjectŬ������ ��ӹ޾Ҵ�.
	//�� ������ JVM�� �˾Ƽ� ��ӹ޴´�.
}
class B04 extends A04{
	//�� Ŭ������ ObjectŬ������ ���� ��ӹ��� �ʾ�����, 
	//A04Ŭ������ ObjectŬ������ ��ӹ޾� ��������� �ϰ� �ִ�
	public void disp(){
		System.out.println("a="+a);
	}
}
class C04{
	B04 ap = new B04();//���԰���, ����ް� ���� ��
	//����� ������� ���� ��
	public void disp(){
		System.out.println("a="+ap.a);
	}
}

public class ClassTest4 {
	public static void main(String[] args){
		A04 ap = new A04();
	
		System.out.println("ap.getClass="+ap.getClass());
	}
}
