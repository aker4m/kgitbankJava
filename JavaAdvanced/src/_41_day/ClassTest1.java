package _41_day;

import java.sql.*;

public class ClassTest1 {
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ��ġ ����!!");
		}catch(ClassNotFoundException e){
			System.out.println("����̹� ��ġ ����!!");
		}
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "big01";
		String pass = "big01";
		try{
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("����Ŭ ���ῡ �����ϼ̽��ϴ�.");
		}catch(SQLException e){
			System.out.println("����Ŭ ���� ����!!");
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
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
		
		/*
		PreparedStatement ps = null;
		String sql = "insert into member values(?, ?, ?, ?)";
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, 5);
			ps.setString(2, "ttt");
			ps.setString(3, "123-0000");
			ps.setString(4, "abc@1111.com");
			int res = ps.executeUpdate();
			//insert, delete, update���ǰ���� int���̴�.
			//select���� ����� ResultSet���̴�
			//���� ȣ���ϴ� �޼ҵ嵵 Ʋ����, 
			//insert, delete, update���� executeUpdate()�� ȣ��
			//select���� executeQuery()�� ȣ���Ѵ�
			if(res>0){
				System.out.println("�ڷ��� ����!!");
			}else {
				System.out.println("�ڷ��� ����!!");
			}
		}catch(SQLException e){
			System.out.println("����Ŭ ���� ���� �� ���� �߻�!!");
		}
		*/
	}
}
