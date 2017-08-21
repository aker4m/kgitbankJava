package board.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.CommandIf;

public class DeleteProCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		String passwd = req.getParameter("passwd");
		BoardDAO dao = new BoardDAO();
		String msg = null, url=null;
		boolean isPass;
		try {
			isPass = dao.isPassword(Integer.parseInt(num), passwd);
			if(isPass){
				int res = dao.deleteBoard(Integer.parseInt(num));
				if(res>0){
					msg="게시글 삭제 성공! 글 목록 페이지로 이동합니다.";
					url="board.bd";
				}else{
					msg="게시글 삭제 실패! 글 목록 페이지로 이동합니다.";
					url="board.bd";
				}
			}else{
				msg="비밀번호가 틀렸습니다. 다시 입력해 주세요!";
				url = "deleteForm.bd?num="+num;
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
