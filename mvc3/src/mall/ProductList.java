package mall;

import java.util.*;
import java.sql.*;
import my.shop.ProductDTO;
import my.db.ConnectionPoolBean;

public class ProductList {
	ArrayList<ProductDTO> p_list, p_list2;
	Hashtable<String, ArrayList<ProductDTO>> ht;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private ConnectionPoolBean pool;
	
	public ProductList(){
		p_list = new ArrayList<ProductDTO>();
		p_list2 = new ArrayList<ProductDTO>();
		ht = new Hashtable<String, ArrayList<ProductDTO>>();
	}

	public ConnectionPoolBean getPool() {
		return pool;
	}

	public void setPool(ConnectionPoolBean pool) {
		this.pool = pool;
	}
	public ArrayList<ProductDTO> selectBySpec(String pspec) throws SQLException{
		String sql = "select * from product where pspec=?";
		try{
			con = pool.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pspec);
			rs = ps.executeQuery();
			p_list = this.makeArrayList(rs);
			ht.put(pspec, p_list);
			return p_list;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) pool.returnConnection(con);
		}
	}
	public ArrayList<ProductDTO> makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<ProductDTO> v = new ArrayList<ProductDTO>();
		while(rs.next()){
			ProductDTO pdto = new ProductDTO();
			pdto.setPnum(rs.getInt(1));
			pdto.setPname(rs.getString(2));
			pdto.setPcategory_fk(rs.getString(3));
			pdto.setPcompany(rs.getString(4));
			pdto.setPimage(rs.getString(5));
			pdto.setPqty(rs.getInt(6));
			pdto.setPrice(rs.getInt(7));
			pdto.setPspec(rs.getString(8));
			pdto.setPcontents(rs.getString(9));
			pdto.setPoint(rs.getInt(10));
			pdto.setPinputdate(rs.getString(11));
			v.add(pdto);
		}
		return v;
	}
	public ProductDTO viewBySpec(String pspec, int pnum){
		p_list2 = ht.get(pspec);
		for(ProductDTO dto : p_list2){
			if(dto.getPnum()==pnum){
				return dto;
			}
		}
		return null;
			
	}
	public ArrayList<ProductDTO> selectByCode(String code) throws SQLException{
		String sql = "select * from product where pcategory_fk like ?";
		try{
			con = pool.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, code+"%");
			rs = ps.executeQuery();
			p_list = this.makeArrayList(rs);
			ht.put(code, p_list);
			return p_list;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) pool.returnConnection(con);
		}
	}
}
