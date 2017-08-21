package _21_day;

class A07{
	private final int a;
	private static int b;
	static{
		System.out.println("Static구문 호출");
	}
	{
		System.out.println("일반구문 호출");//자바에서만 있음
	}
	public A07(){
		a=10;
		System.out.println("A07()생성자 호출");
	}
	public A07(int a, int b){
		this.a=a;
		System.out.println("A07(int a, int b)생성자 호출");
	}
}

public class ClassTest7 {
	public static void main(String[] args){
		A07 ap = new A07();
		A07 bp = new A07(10, 20);
	}
}
