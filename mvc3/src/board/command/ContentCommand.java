package board.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.*;

public class ContentCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		BoardDAO dao = new BoardDAO();
		String nextPage=null;
		try {
			BoardDTO dto = dao.getBoard(Integer.parseInt(num), "content");
			req.setAttribute("dto", dto);
			nextPage = "board/content.jsp";
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		return nextPage;
	}

}
