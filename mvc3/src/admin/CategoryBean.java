package admin;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CategoryBean {
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
	
	public CategoryBean(){}
	
	public int insertCate(CategoryDTO dto) throws SQLException{
		String sql = "insert into category values(cate_seq.nextval, ?, ?)";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			ps.setString(2, dto.getCname());
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps !=null) ps.close();
			if(con !=null) con.close();
		}
	}
	public List<CategoryDTO> listCate() throws SQLException{
		String sql = "select * from category";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<CategoryDTO> list = makeList(rs);
			return list;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	public List<CategoryDTO> makeList(ResultSet rs) throws SQLException{
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		while(rs.next()){
			CategoryDTO dto = new CategoryDTO();
			dto.setCnum(rs.getInt("cnum"));
			dto.setCode(rs.getString("code"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}
	public int deleteCate(CategoryDTO dto) throws SQLException{
		String sql = "delete from category where cnum=?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getCnum());
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
}
