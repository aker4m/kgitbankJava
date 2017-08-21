package board.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import board.CommandIf;

public class UpdateProCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String msg= null, url=null;
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setSubject(req.getParameter("subject"));
		dto.setEmail(req.getParameter("email"));
		dto.setContent(req.getParameter("content"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		BoardDAO dao = new BoardDAO();
		boolean isPass;
		try {
			isPass = dao.isPassword(dto.getNum(), dto.getPasswd());
			if(isPass){
				int res = dao.updateBoard(dto);
				if(res>0){
					msg="게시글 수정 성공! 글 목록 페이지로 이동합니다.";
					url="board.bd";
				}else{
					msg="게시글 수정 실패! 글 목록 페이지로 이동합니다.";
					url="board.bd";
				}
			}else{
				msg="비밀번호가 틀렸습니다. 다시 입력해 주세요!";
				url = "updateForm.bd?num="+dto.getNum();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
