package _25_day;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


class Member2{
	private String name;
	private String phone;
	
	public Member2(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	public void disp(){
		System.out.println(name+"님의 전화번호는 "+phone+" 입니다.");
	}
}

public class SecondTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		HashSet<Member2> hs = new HashSet<Member2>();
		
		while(true){
			System.out.print("1.멤버입력  2.멤버출력  3.멤버삭제  4.멤버수정  5.종료 :");
			int num = sc.nextInt();
			
			switch(num){
			case 1:
				System.out.print("멤버의 이름을 입력하세요");
				String name = sc.next();
				System.out.print("멤버의 전화번호를 입력하세요");
				String phone = sc.next();
				hs.add(new Member2(name, phone));
				break;
			case 2:
				Iterator<Member2> it = hs.iterator();
				while(it.hasNext()){
					Object obj = it.next();
					Member2 member = (Member2)obj;
					member.disp();
				}
				break;
			case 3:
				System.out.print("삭제할 멤버 이름을 입력하세요.");
				name = sc.next();
				
				break;
			case 4:
				break;
			case 5:
				System.out.print("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
	}
}
