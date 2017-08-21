package my.book;
import java.sql.*;
import java.util.*;

import my.student.StudentDTO;

public class BookDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url, user, pass;
	
	public BookDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "big01";
		pass = "big01";
	}
	public int insertBook(String name, String writer, String publisher) throws SQLException{
		String sql = "select * from book where name=?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1,  name);
			rs = ps.executeQuery();
			if(rs.next()){
				return -1;
			}
			sql = "insert into book values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, writer);
			ps.setString(3, publisher);
			java.util.Date date = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
			ps.setString(4, sdf.format(date));
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	public ArrayList listBook() throws SQLException{
		String sql = "select * from book";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList list = makeArrayList(rs);
			return list;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	public ArrayList makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		while(rs.next()){
			BookDTO dto = new BookDTO();
			dto.setName(rs.getString("name"));
			dto.setWriter(rs.getString("writer"));
			dto.setPublisher(rs.getString("publisher"));
			dto.setIndate(rs.getString("indate"));
			list.add(dto);
		}
		return list;
	}
	public int deleteBook(String name) throws SQLException{
		String sql = "delete from book where name=?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	public BookDTO getBook(String name) throws SQLException{
		String sql = "select * from book where name=?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			ArrayList<BookDTO> list = makeArrayList(rs);
			if(list==null || list.size()==0) return null;
			return list.get(0);
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	public int editBook(String name, String writer, String publisher) throws SQLException{
		String sql = "update book set writer=?, publisher=? where name=?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, writer);
			ps.setString(2, publisher);
			ps.setString(3, name);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	public ArrayList findBook(String search, String searchString) throws SQLException{
		String sql = "select * from book where "+search+"=?";
		try{
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, searchString);
			rs = ps.executeQuery();
			ArrayList list = makeArrayList(rs);
			return list;
		}finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
}














