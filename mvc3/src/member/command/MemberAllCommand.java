package member.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.*;

public class MemberAllCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String nextPage = null;
		List<MemberDTO> list = null;
		try{
			String mode = req.getParameter("mode");
			if(mode==null){
				list = dao.listMember();
			}else{
				String search = req.getParameter("search");
				String searchString = req.getParameter("searchString");
				list = dao.findMember(search, searchString);
			}
			req.setAttribute("list", list);
			nextPage="/member/memberAll.jsp";
		}catch(SQLException e){}
		return nextPage;
	}

}
