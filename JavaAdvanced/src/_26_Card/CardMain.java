package _26_Card;

import java.io.IOException;

public class CardMain {
	public static void main(String[] args) throws IOException{
		CardPro pro = new CardPro();
		while(true){
			System.out.print
			("1.�����Է�  2.�������  3.���Ի���  4.���Լ���  5.���� :");
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
