package _27_baseball;

import java.util.*;

public class BaseMain {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		BaseBallPro pro = new BaseBallPro();
		while(true){
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 5.���� : ");
			int select = in.nextInt();
			switch(select){
			case 1 :		pro.insert(); break;
			case 2 :		pro.view(); break;
			case 3 :		pro.delete(); break;
			case 4 :		pro.edit(); break;
			case 5 :		pro.exit(); break;
			default :	System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
