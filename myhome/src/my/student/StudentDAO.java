package my.student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url, user, pass;
	
	public StudentDAO(){ //디폴드 생성자 필요, 디폴드 생성자에는 public
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "big01";
		pass = "big01";
	}
	public int insertStudent(String id, String name, String cname) throws SQLException{
		String sql = "insert into student values(?,?,?)";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, cname);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	public ArrayList listStudent() throws SQLException {
		String sql = "select * from student";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList list = makeArrayList(rs);
			return list;
		}finally{
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	public ArrayList makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		while(rs.next()){
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}
	public int deleteStudent(String id) throws SQLException{
		String sql = "delete from student where id=?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
	public ArrayList findStudent(String name) throws SQLException{
		String sql = "select * from student where name = ?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			ArrayList list = makeArrayList(rs);
			return list;
		}finally{
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)con.close();
		}
	}
}
