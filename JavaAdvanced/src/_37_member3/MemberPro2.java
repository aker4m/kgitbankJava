package _37_member3;

import java.io.*;
import java.util.*;

public class MemberPro2 {
	ArrayList<Member> list;
	Scanner in;
	File dir;
	File file;
	
	public MemberPro2(){
		list = new ArrayList<Member>();
		in = new Scanner(System.in);
		dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_member3");
		file = new File(dir, "data.txt");
	}
	public void insert(){
		System.out.print("이름을 입력 : ");
		String name = in.next();
		System.out.print("전화번호를 입력 : ");
		String tel = in.next();
		Member insert = new Member(name, tel);
		list.add(insert);
	}
	public void view(){
		Member arr[] = new Member[list.size()];
		list.toArray(arr);
		for(Member view : list){
			//Member view = (Member)obj;
			//Member view = (Member)obj;
			view.disp();
		}
	}
	public void delete(){
		System.out.print("삭제할 회원의 이름 : ");
		String name = in.next();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Member delete = (Member)obj;
			if (delete.getName().equals(name)){
				list.remove(delete);
				System.out.println(name+"회원님을 삭제하였습니다.");
				break;
			}
		}
		System.out.println(name+"님은 저희 회원이 아닙니다.");
	}
	public void edit(){
		System.out.print("수정할 회원의 이름 : ");
		String name = in.next();
		for(int i=0; i<list.size(); ++i){
			Object obj = list.get(i);
			Member edit = (Member)obj;
			System.out.print(name+"님의 수정할 전화번호 : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"님의 전화번호를 수정하였습니다.");
			return;
		}
		System.out.println(name+"님은 저희 회원이 아닙니다.");
	}
	public void save() throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		for(Member save : list){
			oos.writeObject(save);
		}
		//oos.writeObject(list);
		oos.close();
	}
	public void load() throws IOException, ClassNotFoundException{
		list.clear();
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		while(true){
			try{
				Object obj = ois.readObject();
				Member load = (Member)obj;
				list.add(load);
				//list = (ArrayList)ois.readObject();
			}catch(EOFException e){
				break;
			}
		}
	}
	
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
