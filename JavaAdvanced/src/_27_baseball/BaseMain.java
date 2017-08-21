package _27_baseball;

import java.util.*;

public class BaseMain {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		BaseBallPro pro = new BaseBallPro();
		while(true){
			System.out.print("1.입력 2.출력 3.삭제 4.수정 5.종료 : ");
			int select = in.nextInt();
			switch(select){
			case 1 :		pro.insert(); break;
			case 2 :		pro.view(); break;
			case 3 :		pro.delete(); break;
			case 4 :		pro.edit(); break;
			case 5 :		pro.exit(); break;
			default :	System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}
