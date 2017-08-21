package _37_member2;

import java.io.*;
import java.util.*;

public class MemberPro2 {
	ArrayList<Member> list;
	Scanner in;
	File file;
	
	public MemberPro2(){
		list = new ArrayList<Member>();
		in = new Scanner(System.in);
		File dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_member2");
		file = new File(dir, "bbb.txt");
	}
	public void insert(){
		System.out.print("�̸��� �Է� : ");
		String name = in.next();
		System.out.print("��ȭ��ȣ�� �Է� : ");
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
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Member delete = (Member)obj;
			if (delete.getName().equals(name)){
				list.remove(delete);
				System.out.println(name+"ȸ������ �����Ͽ����ϴ�.");
				break;
			}
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}
	public void edit(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		for(int i=0; i<list.size(); ++i){
			Object obj = list.get(i);
			Member edit = (Member)obj;
			System.out.print(name+"���� ������ ��ȭ��ȣ : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}
	public void save() throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		for(int i=0;i<list.size(); ++i){
			Member save = list.get(i);
			pw.println(save.getName());
			pw.println(save.getTel());
		}
		pw.close();
	}
	public void load() throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		list.clear();
		while(true){
			try{
				String name = br.readLine();
				if(name == null) break;
				String tel = br.readLine();
								
				Member load = new Member(name, tel);
				list.add(load);
			}catch(EOFException e){
				break;
			}
		}
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
