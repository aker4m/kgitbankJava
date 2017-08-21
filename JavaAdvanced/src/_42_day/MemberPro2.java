package _42_day;

import java.io.File;
import java.util.*;

public class MemberPro2 {
	Scanner in;
	MemberDAO dao;
	public MemberPro2(){
		in = new Scanner(System.in);
		dao = new MemberDAO();
	}
	public void insert(){
		MemberDTO insert = new MemberDTO();
		System.out.print("�̸��� �Է� : ");
		insert.setName(in.next());
		System.out.print("��ȭ��ȣ�� �Է� : ");
		insert.setHp(in.next());
		System.out.print("�̸����� �Է� : ");
		insert.setEmail(in.next());
		dao.insertMember(insert);
	}
	public void view(){
		ArrayList<MemberDTO> list = dao.listMember();
		for(MemberDTO dto : list){
			System.out.print(dto.getNo() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getHp() + "\t");
			System.out.println(dto.getEmail());
		}
	}
	public void delete(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		int res = dao.deleteMember(name);
		if (res>0){
			System.out.println(name+"���� �����Ͽ����ϴ�.");
		} else {
			System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
		}
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
