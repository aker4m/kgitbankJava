package _28_day;

import java.io.IOException;

class A05{
	public void disp() throws IOException{
		System.out.println("aaa");
	}
}

public class ClassTest5 {
	public static void main(String[] args) throws IOException{
		A05 ap = new A05();
		ap.disp();
		String a = "10��";
		try{
			int b = Integer.parseInt(a);
		}catch(NumberFormatException e){
			System.out.println("���ڸ� �Է��ؾ��մϴ�.");
			e.getStackTrace();
		}finally{
			System.out.println("����Ŭ���� ������!!");
		}
		System.out.println("���α׷���!!");
		
	}
}
