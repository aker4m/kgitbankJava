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
		Class.forName("A"); //����Ŭ, ����̹� �ø��� ���
		*/
		
		/*
		Boolean a = //new Boolean("TRUE");
		
					new Boolean(true);
		Boolean b = true;
		boolean c = b;
		//����ο� ����
		if(a) System.out.println("aaa");
		*/
	}
}
