package _26_day;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
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
		System.out.println(name+"님의 전화번호는 " + tel + "입니다.");
	}
}

class MemberPro{
	HashMap map;
	Scanner in;
	public MemberPro(){
		map = new HashMap();
		in = new Scanner(System.in);
	}
	public void insert(){
		System.out.print("이름을 입력 : ");
		String name = in.next();
		System.out.print("전화번호를 입력 : ");
		String tel = in.next();
		Member insert = new Member(name, tel);
		map.put(name, insert);
	}
	public void view(){
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			Member view = (Member)map.get(key);
			view.disp();
		}
	}
	public void delete(){
		System.out.print("삭제할 회원의 이름 : ");
		String name = in.next();
		if(map.remove(name)!=null){
			System.out.println(name+"님을 삭제하였습니다.");
		}else{
			System.out.println(name+"님은 저희 회원이 아닙니다.");
		}
		
	}
	public void edit(){
		System.out.print("수정할 회원의 이름 : ");
		String name = in.next();
		Set set = map.keySet();
		Iterator it = set.iterator();
		if(map.containsKey(name)){
			System.out.print("수정할 전화번호를 입력 : ");
			String tel = in.next();
			map.put(name, new Member(name, tel));
			System.out.println(name+"님의 전화번호를 수정하였습니다.");
			return;
		}else{
			System.out.println(name+"님은 저희 회원이 아닙니다.");
		}
		
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
public class FirstTest {
	public static void main(String[] args) throws IOException{
		MemberPro pro = new MemberPro();
		while(true){
			System.out.print
			("1.멤버입력  2.멤버출력  3.멤버삭제  4.멤버수정  5.종료 :");
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
