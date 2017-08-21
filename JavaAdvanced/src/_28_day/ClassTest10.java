package _28_day;

import java.util.*;

class UpDownGame extends Thread{
	int t;
	boolean isGame;
	int comsu;
	public UpDownGame(){
		t = 0;
		isGame = true;
		comsu = (int)(Math.random()*100) + 1;
		this.start();
		gameStart();
	}
	public void gameStart(){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.print("���� �Է� : " );
			int su = in.nextInt();
			if (su==comsu) break;
			else if (su>comsu) System.out.println("down");
			else System.out.println("Up");
		}
		isGame = false;
		System.out.println("���߽� �ð��� " + t +"���Դϴ�.");
	}
	public void run(){
		while(isGame){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			t++;
		}
	}
}
public class ClassTest10 {
	public static void main(String[] args){
		new UpDownGame();
	}
}
