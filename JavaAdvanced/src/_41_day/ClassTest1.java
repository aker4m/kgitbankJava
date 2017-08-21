package _41_day;

import java.sql.*;

public class ClassTest1 {
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 설치 성공!!");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 설치 실패!!");
		}
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "big01";
		String pass = "big01";
		try{
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("오라클 연결에 성공하셨습니다.");
		}catch(SQLException e){
			System.out.println("오라클 연결 실패!!");
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
			//insert, delete, update문의결과는 int형이다.
			//select문의 결과는 ResultSet형이다
			//따라서 호출하는 메소드도 틀린데, 
			//insert, delete, update문은 executeUpdate()를 호출
			//select문은 executeQuery()를 호출한다
			if(res>0){
				System.out.println("자료등록 성공!!");
			}else {
				System.out.println("자료등록 실패!!");
			}
		}catch(SQLException e){
			System.out.println("오라클 쿼리 전송 중 오류 발생!!");
		}
		*/
	}
}
