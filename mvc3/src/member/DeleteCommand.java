package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String no = req.getParameter("no"); 
		MemberDAO dao = new MemberDAO();
		String nextPage = null, msg=null, url=null;
		try {
			int res = dao.deleteMember(Integer.parseInt(no));
			if(res>0){
				msg = "회원삭제성공!! 회원보기 페이지로 이동합니다.";
				url = "member.do?command=list";
			}else{
				msg = "회원삭제실패!! 회원 페이지로 이동합니다.";
				url = "member.do";
			}
			nextPage="message.jsp";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
		} catch (Exception e) {}
		return nextPage;
	}

}
