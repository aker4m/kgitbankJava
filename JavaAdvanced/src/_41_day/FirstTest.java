package _41_day;

import java.io.*;
import java.util.*;
import java.sql.*;

class MemberPro{
	private Scanner sc;
	private int no;
	private String name;
	private String hp;
	private String email;
	
	private Connection con; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberPro(){
		sc = new Scanner(System.in);
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ��ġ ����!!");
		}catch(ClassNotFoundException e){
			System.out.println("����̹� ��ġ ����!!");
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "big01";
		String pass = "big01";
		try{
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("����Ŭ ���ῡ �����ϼ̽��ϴ�.");
		}catch(SQLException e){
			System.out.println("����Ŭ ���� ����!!");
		}
	}
	
	public void insert(){
		System.out.print("��ȣ�� �Է��ϼ��� : ");
		no = sc.nextInt();
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = sc.next();
		System.out.print("�ڵ��� ��ȣ�� �Է��ϼ��� : ");
		hp = sc.next();
		System.out.print("�̸����� �Է��ϼ��� : ");
		email = sc.next();
		
		String sql = "insert into member values(?, ?, ?, ?)";
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setString(3, hp);
			ps.setString(4, email);
			int res = ps.executeUpdate();
			if(res>0){
				System.out.println("�ڷ��� ����!!");
			}else {
				System.out.println("�ڷ��� ����!!");
			}
		}catch(SQLException e){
			System.out.println("����Ŭ ���� ���� �� ���� �߻�!!");
		}
	}
	public void view(){
		String sql = "select * from member";
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){ //hasNext()+next()
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String email = rs.getString("email");
				System.out.println(no+"\t"+name+"\t"+hp+"\t"+email);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delete(){
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		name = sc.next();
			
		try{
			String sql = "delete from member where name = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int res = ps.executeUpdate();
			if(res>0){
				System.out.println("����� ���� ����!!");
			}else {
				System.out.println("����� ���� ����!!");
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void edit(){
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		name = sc.next();
		
		try{
			
		}catch(Exception e){}
		
		System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
		hp = sc.next();
		System.out.print("�̸����� �Է��ϼ��� : ");
		email = sc.next();
		
		try{
			String sql = "update member set hp = ? and set email = ? where name = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hp);
			ps.setString(2, email);
			ps.setString(3, name);
			int res = ps.executeUpdate();
			if(res>0){
				System.out.println("����� ���� ����!!");
			}else {
				System.out.println("����� ���� ����!!");
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	public void exit(){
		System.exit(0);
	}
}

public class FirstTest {
	public static void main(String[] args) throws IOException{
		MemberPro pro = new MemberPro();
		while(true){
			System.out.print
			("1.����Է�  2.������  3.�������  4.�������  5.���� :");
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
