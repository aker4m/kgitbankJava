package _26_sungjuk;

import java.io.IOException;

public class SungMain {
	public static void main(String[] args) throws IOException{
		SungPro pro = new SungPro();
		while(true){
			System.out.print
			("1.�л��Է�  2.�л����  3.�л�����  4.�л�����  5.���� :");
			int select = System.in.read() - 48;
			System.in.skip(5);
			switch(select){
			case 1 :	pro.insert(); break;
			case 2 :	pro.view(); break;
			case 3 :	pro.delete(); break;
			case 4 :	pro.edit(); break;
			case 5 :	pro.exit(); break;
			default :	System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
