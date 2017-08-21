package student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		StudentDAO dao = new StudentDAO();
		String nextPage=null;
		try{
			ArrayList<StudentDTO> find = dao.findStudent(name);
			req.setAttribute("find", find);
			nextPage="find.jsp";
		}catch(SQLException e){}
		return nextPage;
	}

}
