package _27_day;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Member{
	private String name;
	private String tel;
	
	public Member(String name, String tel){
		this.name = name;
		this.tel = tel;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public void disp(){
		System.out.println(name+"님의 전화번호는 "+tel+" 입니다.");
	}
}

class MemberPro{
	ArrayList<Member> list;
	Scanner sc;
	public MemberPro(){
		list = new ArrayList<Member>();
		sc = new Scanner(System.in);
	}
	public void insert(){
		System.out.print("이름을 입력하세요:");
		String name = sc.next();
		System.out.print("전화번호를 입력하세요:");
		String tel = sc.next();
		Member insert = new Member(name, tel);
		list.add(insert);
	}
	public void delete(){
		System.out.print("삭제할 회원의 이름: ");
		String name = sc.next();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Member delete = (Member)obj;
			if(name.equals(delete.getName())){
				list.remove(delete);
				System.out.println(name+"님을 삭제하였습니다.");
				return;
			}
		}
		System.out.println(name+"님은 회원이 아닙니다.");
	}
	public void view(){
		Iterator<Member> it = list.iterator();
		while(it.hasNext()){
			Member view = it.next();
			//Object obj = it.next();
			//Member view = (Member)obj;
			view.disp();
			
			/*for(Member view : list){
				//Member view = (Member)obj;
				view.disp();
			}*/
			
		}
	}
	public void edit(){
		System.out.print("수정할 회원의 이름 : ");
		String name = sc.next();
		Iterator<Member> it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Member edit = (Member)obj;
			if(edit.getName().equals(name)){
				System.out.print("수정할 전화번호를 입력 : ");
				String tel = sc.next();
				edit.setTel(tel);
				System.out.println(name+"님의 전화번호를 수정하였습니다.");
				return;
			}
		}
		System.out.println(name+"님은 회원이 아닙니다.");
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}

public class SecondTest {
	public static void main(String[] args){
		MemberPro pro = new MemberPro();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("1.회원가입  2.회원삭제  3.회원보기  4.회원수정  5.종료:");
			int select = sc.nextInt();
			switch(select){
			case 1: pro.insert(); break;
			case 2: pro.delete(); break;
			case 3: pro.view(); break;
			case 4: pro.edit(); break;
			case 5: pro.exit(); break;
			default: System.out.println("잘못입력하셨습니다.");
			}
		}
	}
}
