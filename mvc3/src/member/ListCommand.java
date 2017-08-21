package member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		String nextPage = null;
		try{
			List<MemberDTO> list = dao.listMember();
			req.setAttribute("list", list);
			nextPage="/member/memberAll.jsp";
		}catch(SQLException e){}
		return nextPage;
	}

}
