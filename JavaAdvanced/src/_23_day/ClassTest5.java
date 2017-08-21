package _23_day;

class Outer5{
	private int a;
	private static int b;
	static{
		b=20;
	}
	public Outer5(){
		a=10;
	}
	public void disp(){
		class Inner5{}
		System.out.println("a="+a);
		System.out.println("b="+b);
		Inner5 in = new Inner5();
	}
	static class Inner5{
		private int c;
		public Inner5(){
			c=30;
		}
		public void disp_in(){
			//System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
		}
		class Inner_Inner5{}
	}
}

public class ClassTest5 {
	public static void main(String[] args){
		Outer5 ot = new Outer5();
		//Outer5.Inner5 oi = ot.new Inner5();
		Outer5.Inner5 oi = new Outer5.Inner5();
		
	}
}
