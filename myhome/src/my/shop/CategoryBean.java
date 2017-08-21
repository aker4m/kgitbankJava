package my.shop;

import java.sql.*;
import my.db.ConnectionPoolBean;
import java.util.*;

public class CategoryBean {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private ConnectionPoolBean pool;
	
	public CategoryBean(){
		
	}
	
	public void setPool(ConnectionPoolBean pool){
		this.pool = pool;
	}
	
	public int insertCate(CategoryDTO dto) throws SQLException{
		String sql = "insert into category values(cate_seq.nextval, ?, ?)";
		try{
			con = pool.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			ps.setString(2, dto.getCname());
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps !=null) ps.close();
			if(con !=null) pool.returnConnection(con);
		}
	}
	public List<CategoryDTO> listCate() throws SQLException{
		String sql = "select * from category";
		try{
			con = pool.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<CategoryDTO> list = makeList(rs);
			return list;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) pool.returnConnection(con);
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
			con = pool.getConnection();
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
