package _24_day;
class A04{
	int a = 10;
	//이 클래스는 Object클래스를 상속받았다.
	//안 적으면 JVM이 알아서 상속받는다.
}
class B04 extends A04{
	//이 클래스는 Object클래스를 직접 상속받지 않았지만, 
	//A04클래스가 Object클래스를 상속받아 간접상속을 하고 있다
	public void disp(){
		System.out.println("a="+a);
	}
}
class C04{
	B04 ap = new B04();//포함관계, 허락받고 쓰는 것
	//상속은 마음대로 쓰는 것
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
