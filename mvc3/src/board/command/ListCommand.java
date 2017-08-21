package board.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.*;

public class ListCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String nextPage=null;
		int pageSize = 5;
		String pageNum = req.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize +1;
		int endRow = startRow + pageSize -1;
		int countRow = 0;
		int number = 0;
		try {
			countRow = dao.getCount();
			if(endRow>countRow) endRow = countRow;
			number = countRow - (currentPage-1)*pageSize;
			List<BoardDTO> list = dao.listBoard(startRow, endRow);
			req.setAttribute("pageSize", pageSize);
			req.setAttribute("currentPage", currentPage);
			//req.setAttribute("startRow", startRow);
			//req.setAttribute("endRow", endRow);
			req.setAttribute("countRow", countRow);
			req.setAttribute("number", number);
			req.setAttribute("list", list);
			nextPage = "board/list.jsp";
		} catch (SQLException e) {}
		return nextPage;
	}

}
