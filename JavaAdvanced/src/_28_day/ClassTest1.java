package _28_day;

public class ClassTest1 {
	public static void main(String[] args){
		String msg = "Hello, Java!!";
		StringBuilder buffer = new StringBuilder(msg);
		buffer.insert(7, "Hi, ");
		msg = new String(buffer);
		System.out.println(msg);
		
		//StringBuffer(동기화), StringBuilder(동기화X)
		/*
		int a = 10;
		int b = 20;
		System.out.println("두 수의 합 : "+(a+b));
		*/
		/*
		int a = 10;
		String b = String.valueOf(a);
		
		int c = Integer.parseInt(b);
		*/
		/*
		String msg = "          Hello, Java!!            ".trim();
		System.out.println(msg.substring(7, 11));
		// trim : 앞뒤에 있는 공백제거
		*/
		/*
		String subMsg = msg.substring(7, 11);
		if(subMsg.equals("Java")){
			System.out.println("Java");
		}
		*/
		//System.out.println(msg.substring(7, 11));
		/*
		String a = "aaa";
		String b = new String("aaa");
		byte by[] = new byte[]{'H','e','l','l','o',' ','j','a','v','a'};
		String c = new String(by);
		
		System.out.println("c = "+ c);
		byte by2[] = c.getBytes();
		for(int i=0;i<by2.length;i++){
			System.out.println((char)by2[i]);
		}
		*/
	}
}
