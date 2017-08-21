package my.board;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import my.db.ConnectionPoolBean;
import com.oreilly.servlet.MultipartRequest;

public class BoardDataBean {
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
	/*
	private ConnectionPoolBean pool;

	public ConnectionPoolBean getPool() {
		return pool;
	}

	public void setPool(ConnectionPoolBean pool) {
		this.pool = pool;
	}
	*/
	public BoardDataBean(){}
	
	public int writeBoard(BoardDBBean bean) throws SQLException{
		String sql = null;
		if(bean.getNum()==0){
			sql="update board set re_step = re_step + 1"; 
		}else{
			sql="update board set re_step = re_step + 1 where re_step >"+bean.getRe_step();
			bean.setRe_step(bean.getRe_step()+1);
			bean.setRe_level(bean.getRe_level()+1);
		}
		
		
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			sql = "insert into board values(board_seq.nextval,?,?,?,?,sysdate,default,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getWriter());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getSubject());
			ps.setString(4, bean.getPasswd());
			ps.setString(5, bean.getContent());
			ps.setString(6, bean.getIp());
			ps.setInt(7, bean.getRe_step());
			ps.setInt(8, bean.getRe_level());
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	public int writeBoard(MultipartRequest mr, String ip) throws SQLException{
		String sql = null;
		int re_step=0, re_level=0;
		if(Integer.parseInt(mr.getParameter("num")) == 0){
			sql="update board set re_step = re_step + 1"; 
		}else{
			sql="update board set re_step = re_step + 1 where re_step >"+Integer.parseInt(mr.getParameter("re_step"));
			re_step = Integer.parseInt(mr.getParameter("re_step"))+1;
			re_level = Integer.parseInt(mr.getParameter("re_level"))+1;
		}
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			sql = "insert into board values(board_seq.nextval,?,?,?,?,sysdate,default,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("writer"));
			ps.setString(2, mr.getParameter("email"));
			ps.setString(3, mr.getParameter("subject"));
			ps.setString(4, mr.getParameter("passwd"));
			ps.setString(5, mr.getParameter("content"));
			ps.setString(6, ip);
			ps.setInt(7, re_step);
			ps.setInt(8, re_level);
			ps.setString(9, mr.getFilesystemName("filename"));
			int filesize=0;
			if(mr.getFilesystemName("filename")!=null){
				filesize=(int)mr.getFile("filename").length();
			}
			ps.setLong(10, filesize);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	public int getCount() throws SQLException{
		String sql = "select count(*) from board";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	
	public List<BoardDBBean> listBoard(int start, int end) throws SQLException{
		String sql = "select * from (select rownum rn, A.* from (select * from board order by re_step asc)A) where rn between ? and ?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			List<BoardDBBean> list = makeList(rs);
			return list;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
	}
	protected List<BoardDBBean> makeList(ResultSet rs) throws SQLException{
		List<BoardDBBean> list = new ArrayList<BoardDBBean>();
		while(rs.next()){
			BoardDBBean bean = new BoardDBBean();
			bean.setNum(rs.getInt("num"));
			bean.setWriter(rs.getString("writer"));
			bean.setEmail(rs.getString("email"));
			bean.setSubject(rs.getString("subject"));
			bean.setPasswd(rs.getString("passwd"));
			bean.setReg_date(rs.getString("reg_date"));
			bean.setReadcount(rs.getInt("readcount"));
			bean.setContent(rs.getString("content"));
			bean.setIp(rs.getString("ip"));
			bean.setRe_step(rs.getInt("re_step"));
			bean.setRe_level(rs.getInt("re_level"));
			bean.setFilename(rs.getString("filename"));
			bean.setFilesize(rs.getInt("filesize"));
			list.add(bean);
		}
		return list;
	}
	public BoardDBBean getBoard(int num, String mode) throws SQLException{
		if(mode.equals("content")){
			String sql = "update board set readcount = readcount+1 where num=?";
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		}
		String sql = "select * from board where num=?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDBBean> list = this.makeList(rs);
			return list.get(0);
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();;
		}
	}
	public boolean isPassword(int num, String passwd) throws SQLException{
		String sql = "select passwd from board where num=?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()){
				String dbPass = rs.getString(1);
				if(dbPass.equals(passwd)){
					return true;
				}
			}
			return false;
		}finally{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();;
		}
	}
	public int deleteBoard(int num) throws SQLException{
		String sql = "delete from board where num=?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();;
		}
	}
	public int updateBoard(BoardDBBean bean) throws SQLException{
		String sql = "update board set writer=?, subject=?, email=?, content=? where num=?";
		try{
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getWriter());
			ps.setString(2, bean.getSubject());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getContent());
			ps.setInt(5, bean.getNum());
			int res = ps.executeUpdate();
			return res;
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();;
		}
	}
}








