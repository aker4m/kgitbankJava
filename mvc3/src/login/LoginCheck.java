package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class LoginCheck {
	public static final int OK = 0;
	public static final int NOT_ID= 1;
	public static final int NOT_PWD= 2;
	public static final int ERROR = -1;
	
	private String id;
	private String passwd;
	
	private static DataSource ds;
	static{
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e){
			System.out.println("lookup 실패 : "+e.getMessage());
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int memberCheck(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select passwd from jsp_member where id= ?";
		try{
			con = ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				String dbPass = rs.getString(1);
				if(passwd.equals(dbPass)){
					return OK;
				}else{
					return NOT_PWD;
				}
			}else{
				return NOT_ID;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return ERROR;
		}finally{
			try{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			}catch(SQLException e){}
		}
	}
}
