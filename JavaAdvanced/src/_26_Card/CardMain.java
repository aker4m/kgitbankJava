package _26_Card;

import java.io.IOException;

public class CardMain {
	public static void main(String[] args) throws IOException{
		CardPro pro = new CardPro();
		while(true){
			System.out.print
			("1.명함입력  2.명함출력  3.명함삭제  4.명함수정  5.종료 :");
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
