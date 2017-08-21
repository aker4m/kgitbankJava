package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		String nextPage=null;
		MemberDAO dao = new MemberDAO();		
		boolean isMember = dao.checkMember(name, ssn1, ssn2);
		if(isMember){
			nextPage = "member.jsp";
		}else{
			req.setParameter("name");
			req.setParameter("ssn1");
			req.setParameter("ssn2");
			nextPage = "member/member.jsp";
		}
		return nextPage;
	}

}
