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
		String a = "10ㅁ";
		try{
			int b = Integer.parseInt(a);
		}catch(NumberFormatException e){
			System.out.println("숫자만 입력해야합니다.");
			e.getStackTrace();
		}finally{
			System.out.println("예외클래스 수업중!!");
		}
		System.out.println("프로그램끝!!");
		
	}
}
