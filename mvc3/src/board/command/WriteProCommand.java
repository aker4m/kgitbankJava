package board.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import board.*;

public class WriteProCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String nextPage=null, msg=null, url=null;
		String upPath = req.getServletContext().getRealPath("/board/files");
		int len = 1024*1024*1024;
		
		MultipartRequest mr = new MultipartRequest(req, upPath, len, "UTF-8");
		String ip = req.getRemoteAddr();
		try {
			int res = dao.writeBoard(mr, ip);
			if(res>0){
				msg = "게시글 등록 성공 !! 게시판으로 이동합니다.";
				url = "board.bd";
			}else{
				msg = "게시글 등록 실패!! 게시판으로 이동합니다.";
				url = "board.bd";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			nextPage="message.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextPage;
	}

}
