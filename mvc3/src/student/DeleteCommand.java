package student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String msg = null, url = null, nextPage = null;
		StudentDAO dao = new StudentDAO();
		try{
			int res = dao.deleteStudent(id);
			if(res>0){
				msg = "학생삭제성공!! 학생보기 페이지로 이동합니다.";
				url = "student.do?command=list";
			}else{
				msg = "학생삭제실패!! 학생등록 페이지로 이동합니다.";
				url = "student.do";
			}
			nextPage="message.jsp";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
		}catch(SQLException e){}
		return nextPage;
	}
	
}
