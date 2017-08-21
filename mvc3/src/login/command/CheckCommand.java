package login.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.CommandIf;
import member.MemberDAO;

public class CheckCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		String id = req.getParameter("id");
		String msg = null, url="login.login";
		String dbMsg=null;
		MemberDAO dao = new MemberDAO();
		if(id ==null){
			try {
				dbMsg = dao.searchId(name, ssn1, ssn2);
				msg = "당신의 아이디는 "+dbMsg+" 입니다."; 
			} catch (SQLException e) {}
			if(dbMsg==null) dbMsg = "아이디가 존재하지 않습니다.";
		}else{
			try {
				dbMsg = dao.searchPw(name, id, ssn1, ssn2);
				msg="당신의 비밀번호는"+dbMsg+"입니다.";
			} catch (SQLException e) {}
			if(dbMsg ==null) dbMsg="해당정보가 일치하지 않습니다.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
