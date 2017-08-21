package _26_sungjuk;

import java.io.IOException;

public class SungMain {
	public static void main(String[] args) throws IOException{
		SungPro pro = new SungPro();
		while(true){
			System.out.print
			("1.학생입력  2.학생출력  3.학생삭제  4.학생수정  5.종료 :");
			int select = System.in.read() - 48;
			System.in.skip(5);
			switch(select){
			case 1 :	pro.insert(); break;
			case 2 :	pro.view(); break;
			case 3 :	pro.delete(); break;
			case 4 :	pro.edit(); break;
			case 5 :	pro.exit(); break;
			default :	System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}
