package board.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.*;

public class UpdateFormCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String num = req.getParameter("num");
		String nextPage=null;
		try {
			BoardDTO dto = dao.getBoard(Integer.parseInt(num), "update");
			req.setAttribute("dto", dto);
			nextPage = "board/updateForm.jsp";
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		return nextPage;
	}

}
