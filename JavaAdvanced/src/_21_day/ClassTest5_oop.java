package _21_day;

import java.util.Scanner;
import java.io.IOException;

class RoomMg{
	int roomSu;
	boolean room[];
	Scanner in;
	public RoomMg(int su){
		roomSu = su;
		room = new boolean[su];
	}
	public void input(){
		System.out.print("입실하실 방의 번호 : ");
		int roomNumber = in.nextInt();
		if(room[roomNumber-1]){
			System.out.print(roomNumber+"호실은 현재 사용중 입니다.");
		}else{
			room[roomNumber-1]=true;
			System.out.println(roomNumber+"호실에 입실하셨습니다.");
		}
	}
	public void output(){
		System.out.print("퇴실하실 방의 번호 : ");
		int roomNumber = in.nextInt();
		if(room[roomNumber-1]){
			room[roomNumber-1]=false;
			System.out.print(roomNumber+"호실에서 퇴실하셨습니다.");
		}else{
			System.out.println(roomNumber+"호실은 빈방입니다.");
		}
	}
	public void view(){
		for(int i=0;i<room.length;++i){
			if(room[i]){
				System.out.println(i+1+"호실은 사용중");
			}else{
				System.out.println(i+1+"호실은 빈방");
			}
		}
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0); //프로그램을 종료시킨다.
	}
}

public class ClassTest5_oop {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		System.out.print("방의 갯수를 입력 : ");
		int roomsu = in.nextInt();
		
		RoomMg room = new RoomMg(roomsu);
		
		while(true){
			System.out.print("1.입실 2.퇴실 3.보기 4.종료 : ");
			int select = System.in.read()-48;
			System.in.skip(5);
			switch(select){
			case 1: room.input(); break;
			case 2: room.output(); break;
			case 3: room.view(); break;
			case 4: room.exit(); break;
			default: System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}
