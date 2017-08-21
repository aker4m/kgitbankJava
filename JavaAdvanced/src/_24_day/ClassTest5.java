package _24_day;

import java.io.IOException;

class A05{
	int a;
	int b;
	A05(){
		a=100;
		b=20;
	}
	A05(int a){
		this.a =a;
	}
	A05(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void disp() throws IOException{
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
class B05 extends A05{
	int c;
	B05(){
		super();
		b=1000;
		c=30;
	}
	public void disp() {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
}

public class ClassTest5 {
	public static void main(String[] args){
		B05 ap = new B05();
		ap.disp();
		
	}
}
