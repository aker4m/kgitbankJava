package _42_day.git;

import java.io.IOException;

public class MemberMain {
	public static void main(String[] args) throws IOException{
		MemberPro2 pro = new MemberPro2();
		while(true){
			System.out.print("1.����Է�  2.������  3.�������  "
					+ "4.���� :");
			int select = System.in.read() - 48;
			System.in.skip(5);
			switch(select){
			case 1 :	pro.insert(); break;
			case 2 :	pro.view(); break;
			case 3 :	pro.delete(); break;
			case 4 :	pro.exit(); break;
			default :	System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
