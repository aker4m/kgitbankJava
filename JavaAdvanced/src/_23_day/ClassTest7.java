package _23_day;

abstract class A07{
	public abstract void disp();
}

public class ClassTest7 {
	public static void main(String[] args){
		A07 ap = new A07(){
			public void disp(){
				System.out.println("aaa");
				disp2();
			}
			public void disp2(){
				System.out.println("bbb");
			}
		};
		ap.disp();
		//ap.disp2();
	}
}
