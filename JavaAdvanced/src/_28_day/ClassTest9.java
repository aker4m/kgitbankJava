package _28_day;

import java.text.SimpleDateFormat;
import java.util.Date;

class A09 extends Thread{
	Date date;
	SimpleDateFormat sdf;
	public A09(){
		sdf = new SimpleDateFormat("HH:mm:ss");
	}
	public void run(){
		while(true){
			date = new Date();
			System.out.println("현재시간 : "+sdf.format(date));
			try{
				Thread.sleep(1000);//현재스레드 재우기
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

public class ClassTest9 {
	public static void main(String[] args){
		A09 ap = new A09();
		ap.setDaemon(true);//메인에 종속 스레드로 한다
		ap.start();
		try{
			ap.join(5000);
			Thread.sleep(5000);//현재스레드 재우기
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
