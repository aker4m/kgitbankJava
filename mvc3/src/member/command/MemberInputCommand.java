package member.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.*;

public class MemberInputCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setName(req.getParameter("name"));
		dto.setId(req.getParameter("id"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setSsn1(req.getParameter("ssn1"));
		dto.setSsn2(req.getParameter("ssn2"));
		dto.setEmail(req.getParameter("email"));
		dto.setHp1(req.getParameter("hp1"));
		dto.setHp2(req.getParameter("hp2"));
		dto.setHp3(req.getParameter("hp3"));
		MemberDAO dao = new MemberDAO();
		String msg = null, url = null;
		String nextPage=null;
		try{
			int res = dao.insertMember(dto);
			if(res>0){
				msg = "회원등록 성공 !! 회원 관리 페이지로 이동합니다.";
				url = "member.app";
			}else{
				msg = "회원등록 실패 !! 회원 등록 페이지로 이동합니다.";
				url = "memberSsn.mem";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			nextPage="message.jsp";
		}catch(SQLException e){}
		return nextPage;
	}

}
