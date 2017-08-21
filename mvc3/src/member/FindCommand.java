package member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String search = req.getParameter("search");
		String searchString = req.getParameter("searchString");
		String nextPage=null;
		MemberDAO dao = new MemberDAO();
		try{
			List<MemberDTO> list = dao.findMember(search, searchString);
			req.setAttribute("list", list);
			nextPage="/member/memberAll.jsp";	
		}catch(SQLException e){}
		return nextPage;
	}

}
