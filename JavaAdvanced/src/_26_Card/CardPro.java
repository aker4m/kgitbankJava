package _26_Card;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CardPro {
	HashMap map, map2;
	Scanner in;
	public CardPro(){
		map = new HashMap(); //전체 자료를 저장할 공간
		//map : key-String, value-map2
		//map2 = new HashMap(); //map안에 value값으로 저장할 공간
		//map2 : key-String, value-Card
		in = new Scanner(System.in);
	}
	protected String getGroup(){
		System.out.print("1.회사  2. 친구  3.거래처  4.기타 : ");
		int select = in.nextInt();
		String result = null;
		switch(select){
		case 1: result = "회사"; break;
		case 2: result = "친구"; break;
		case 3: result = "거래처"; break;
		case 4: result = "기타"; break;
		default: getGroup();
		}
		return result;
	}
	public void insert(){
		String group = getGroup();
		System.out.print("이름을 입력 : ");
		String name = in.next();
		System.out.print("전화번호를 입력 : ");
		String tel = in.next();
		System.out.print("회사명을 입력 : ");
		String company = in.next();
		System.out.print("이메일을 입력 : ");
		String email = in.next();
		if(map.containsKey(group)){
			map2 = (HashMap)map.get(group);
		}else{
			map2 = new HashMap();
		}
		map2.put(name, new Card(name, tel, company, email));
		map.put(group, map2);
	}
	public void view(){
		String group = getGroup();
		HashMap view = (HashMap)map.get(group);
		Set set = view.keySet();
		for(Iterator it = set.iterator();it.hasNext();){
			String key = (String)it.next();
			Card card = (Card)view.get(key);
			System.out.print(card.getName()+"\t");
			System.out.print(card.getTel()+"\t");
			System.out.print(card.getCompany()+"\t");
			System.out.print(card.getEmail()+"\n");
		}
	}
	public void edit(){
		String group = getGroup();
		HashMap edit = (HashMap)map.get(group);
		System.out.print("수정할 명함의 이름 : ");
		String name = in.next();
		if(edit.containsKey(name)){
			Card card = (Card)edit.get(name);
			System.out.print("전화번호를 입력 : ");
			card.setTel(in.next());
			System.out.print("회사명을 입력 : ");
			card.setCompany(in.next());
			System.out.print("이메일을 입력 : ");
			card.setEmail(in.next());
			System.out.println(group+"에"+name+"님의 명함을 수정하였습니다.");
			return;
		}
		System.out.println(group+"에"+name+"님의 명함이 없습니다.");
	}
	public void delete(){
		String group = getGroup();
		HashMap delete = (HashMap)map.get(group);
		System.out.print("삭제할 명함의 이름 : ");
		String name = in.next();
		if(delete.containsKey(name)){
			delete.remove(name);
			System.out.println(group+"에"+name+"님의 명함을 삭제하였습니다.");
			return;
		}
		System.out.println(group+"에"+name+"님의 명함이 없습니다.");
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
