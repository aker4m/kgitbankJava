package member.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.CommandIf;
import member.MemberDAO;

public class CheckMemberCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		String msg=null, url=null, nextPage=null;
		try {
			boolean isMember = dao.checkMember(name, ssn1, ssn2);
			if(isMember){
				msg = "이미 회원이십니다. 로그인을 해주세요.";
				url = "member.app";
				req.setAttribute("msg", msg);
				req.setAttribute("url", url);
				return "message.jsp";
			}else{
				req.setAttribute("name", name);
				req.setAttribute("ssn1", ssn1);
				req.setAttribute("ssn2", ssn2);
				return "member/member_input.jsp";
			}
		} catch (SQLException e) {}
		return null;
	}

}
