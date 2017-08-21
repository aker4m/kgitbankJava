package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static DataSource ds;
	static{
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e){
			System.out.println("lookup 실패 : " + e.getMessage());
		}
	}
	public int insertStudent(String id, String name, String cname) throws SQLException{
		String sql = "insert into student values(?,?,?)";
		try{
			con = ds.getConnection();
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
	public ArrayList<StudentDTO> listStudent() throws SQLException {
		String sql = "select * from student";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<StudentDTO> list = makeArrayList(rs);
			return list;
		}finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	public ArrayList<StudentDTO> makeArrayList(ResultSet rs) throws SQLException{
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
			con = ds.getConnection();
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
			con = ds.getConnection();
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













