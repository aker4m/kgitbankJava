package _37_member;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MemberPro {
	private HashMap map;
	private Scanner in;
	
	private File dir;
	private File f;
	
	public MemberPro(){
		map = new HashMap();
		in = new Scanner(System.in);
		dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_37_member");
		f = new File(dir, "member.txt");
	}
	public void insert(){
		System.out.print("�̸��� �Է� : ");
		String name = in.next();
		System.out.print("��ȭ��ȣ�� �Է� : ");
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
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if(map.containsKey(name)){
			map.remove(name);
			System.out.println(name+"���� �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}
	public void edit(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if(map.containsKey(name)){
			Member edit = (Member)map.get(name);
			System.out.print("������ ��ȭ��ȣ�� �Է� : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}
	public void filesave() throws IOException{
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		int num=0;
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			String key = (String)obj;
			Member view = (Member)map.get(key);
			dos.writeUTF(view.getName());
			dos.writeUTF(view.getTel());
			dos.flush();
			num++;
		}
		System.out.println(num+"���� �ڷḦ ���Ͽ� �����Ͽ����ϴ�.");
	}
	public void fileopen() throws IOException{
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		int num=0;
		map.clear();
		while(true){
			int check = dis.available();
			if(check==0) break;
			String name = dis.readUTF();
			String tel = dis.readUTF();
			Member read = new Member(name, tel);
			map.put(name, read);
			num++;
		}
		System.out.println(num+"�� �ڷ��� ������ �������ϴ�.");
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
