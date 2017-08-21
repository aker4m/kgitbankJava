package student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		String nextPage = null;
		try {
			ArrayList<StudentDTO> list = dao.listStudent();
			req.setAttribute("list", list);
			nextPage="list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextPage;
	}

}
