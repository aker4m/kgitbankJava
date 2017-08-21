package student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String cname = req.getParameter("cname");
		StudentDAO dao = new StudentDAO();
		String msg=null, url=null, nextPage=null;
		try {
			int res = dao.insertStudent(id, name, cname);
			if(res>0){
				msg = "학생등록성공!! 학생보기 페이지로 이동합니다.";
				url = "student.do?command=list";
			}else{
				msg = "학생등록실패!! 학생등록 페이지로 이동합니다.";
				url = "student.do";
			}
			nextPage="message.jsp";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
		} catch (SQLException e) {}
		return nextPage;
	}

}
