package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nextPage=null, msg=null, url=null;
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		String email = req.getParameter("email");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPasswd(passwd);
		dto.setSsn1(ssn1);
		dto.setSsn2(ssn2);
		dto.setEmail(email);
		dto.setHp1(hp1);
		dto.setHp2(hp2);
		dto.setHp3(hp3);
		try{
			int res = dao.insertMember(dto);
			if(res>0){
				msg="회원가입 성공";
				url="member.jsp"; 
			}else{
				msg="회원가입 실패";
				url="member.jsp";
			}
			nextPage="message.jsp";
		}catch(SQLException e){}
		
		return nextPage;
	}

}
