package _26_day;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Group{
	private String company;
}

class Person{
	private String name;
	private String work;
	private String phone;
	private String email;
	
	public Person(String name, String work, String phone, String email){
		this.name = name;
		this.work = work;
		this.phone = phone;
		this.email = email;
	}
	public void setWork(String work){
		this.work = work;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getName(){
		return name;
	}
	public String getWork(){
		return work;
	}
	public String getPhone(){
		return phone;
	}
	public String getEmail(){
		return email;
	}
	public void disp(){
		System.out.print("�̸�:"+name+", ȸ���:"+work+
				", ��ȭ��ȣ:"+phone+", �̸���:"+email);
	}
}
class BusinessCardPro{
	HashMap map;
	Scanner sc;
	public BusinessCardPro(){
		map = new HashMap();
		sc = new Scanner(System.in);
	}
	public void insert(){
		select();
		String name = inputStr("�̸�");
		String work = inputStr("ȸ���");
		String phone = inputStr("��ȭ��ȣ");
		String email = inputStr("�̸���");
		Person insert = new Person(name, work, phone, email);
		map.put(name, insert);
	}
	public void view(){
		
	}
	public void delete(){
	
	}
	public void edit(){
		
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
	public void select(){
		while(true){
			System.out.print("�׷��� �����ϼ���:");
			int select = sc.nextInt();
			switch(select){
			case 1: 
			case 2:
			case 3:
			case 4:
			default: System.out.print("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
	protected String inputStr(String str){
		Scanner in = new Scanner(System.in);
		System.out.print(str+"��(��) �Է� : ");
		return in.next();
	}
}

public class ThirdTest {
	public static void main(String[] args) throws IOException{
		BusinessCardPro pro = new BusinessCardPro();
		while(true){
			System.out.print
			("1.�����Է�  2.�������  3.���Ի���  4.���Լ���  5.���� :");
			int select = System.in.read() - 48;
			System.in.skip(5);
			switch(select){
			case 1 :	pro.insert(); break;
			case 2 :	pro.view(); break;
			case 3 :	pro.delete(); break;
			case 4 :	pro.edit(); break;
			case 5 :	pro.exit(); break;
			default :	System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
