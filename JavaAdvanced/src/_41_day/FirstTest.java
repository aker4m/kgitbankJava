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
			System.out.println("드라이버 설치 성공!!");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 설치 실패!!");
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "big01";
		String pass = "big01";
		try{
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("오라클 연결에 성공하셨습니다.");
		}catch(SQLException e){
			System.out.println("오라클 연결 실패!!");
		}
	}
	
	public void insert(){
		System.out.print("번호를 입력하세요 : ");
		no = sc.nextInt();
		System.out.print("이름을 입력하세요 : ");
		name = sc.next();
		System.out.print("핸드폰 번호를 입력하세요 : ");
		hp = sc.next();
		System.out.print("이메일을 입력하세요 : ");
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
				System.out.println("자료등록 성공!!");
			}else {
				System.out.println("자료등록 실패!!");
			}
		}catch(SQLException e){
			System.out.println("오라클 쿼리 전송 중 오류 발생!!");
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
		System.out.print("삭제할 이름을 입력하세요 : ");
		name = sc.next();
			
		try{
			String sql = "delete from member where name = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int res = ps.executeUpdate();
			if(res>0){
				System.out.println("사용자 삭제 성공!!");
			}else {
				System.out.println("사용자 삭제 실패!!");
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void edit(){
		System.out.print("수정할 이름을 입력하세요 : ");
		name = sc.next();
		
		try{
			
		}catch(Exception e){}
		
		System.out.print("전화번호를 입력하세요 : ");
		hp = sc.next();
		System.out.print("이메일을 입력하세요 : ");
		email = sc.next();
		
		try{
			String sql = "update member set hp = ? and set email = ? where name = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hp);
			ps.setString(2, email);
			ps.setString(3, name);
			int res = ps.executeUpdate();
			if(res>0){
				System.out.println("사용자 수정 성공!!");
			}else {
				System.out.println("사용자 수정 실패!!");
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
