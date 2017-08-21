package _26_member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MemberPro {
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
			Object obj = it.next();
			String key = (String)obj;
			Member view = (Member)map.get(key);
			view.disp();
		}
	}
	public void delete(){
		System.out.print("삭제할 회원의 이름 : ");
		String name = in.next();
		if(map.containsKey(name)){
			map.remove(name);
			System.out.println(name+"님을 삭제하였습니다.");
			return;
		}
		System.out.println(name+"님은 저희 회원이 아닙니다.");
	}
	public void edit(){
		System.out.print("수정할 회원의 이름 : ");
		String name = in.next();
		if(map.containsKey(name)){
			Member edit = (Member)map.get(name);
			System.out.print("수정할 전화번호를 입력 : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"님의 전화번호를 수정하였습니다.");
			return;
		}
		System.out.println(name+"님은 저희 회원이 아닙니다.");
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
