import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String reqUri = req.getRequestURI();
		String upPath = req.getContextPath();
		String cmd = reqUri.substring(upPath.length());
		/*
		PrintWriter pw = resp.getWriter();
		pw.println("reqUri = "+reqUri+"<br>");
		pw.println("upPath = "+upPath+"<br>");
		*/
		String nextPage = null;
		if(cmd.equals("/student.app")){
			nextPage = "student.do";
		}else if(cmd.equals("/member.app")){
			nextPage="member/member.jsp";
		}else if(cmd.equals("/board.app")){
			nextPage="board.bd";
		}else if(cmd.equals("/login.app")){
			nextPage="login/login.jsp";
		}else if(cmd.equals("/shopAdmin.app")){
			nextPage="main.admin";
		}else if(cmd.equals("/shop.app")){
			nextPage="mall.mall";
		}
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}
