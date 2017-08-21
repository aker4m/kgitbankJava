package _28_day;

class A{
	int a;
}

public class ClassTest2 {
	public static void main(String[] args){
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try{
			p=r.exec("iexplore");
		}catch(Exception e){
			System.out.println("Error executing notepad.");
		}
	/*
	public static void main(String[] args) throws Exception{
		Number num;
		num = new Integer(10);
		num = new Byte((byte)10);
	*/	
		/*
		Class.forName("A"); //오라클, 드라이버 올릴때 사용
		*/
		
		/*
		Boolean a = //new Boolean("TRUE");
		
					new Boolean(true);
		Boolean b = true;
		boolean c = b;
		//상수부에 저장
		if(a) System.out.println("aaa");
		*/
	}
}
