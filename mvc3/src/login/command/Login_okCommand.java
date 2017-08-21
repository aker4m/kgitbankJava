package login.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.*;

public class Login_okCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String saveId = req.getParameter("saveId");
		LoginCheck check = new LoginCheck();
		check.setId(req.getParameter("id"));
		check.setPasswd(req.getParameter("passwd"));
		
		LoginOkBean loginOk = new LoginOkBean();
		int res = check.memberCheck();
		String msg = null, url="login.login";
		if(res==LoginCheck.OK){
			loginOk.setId(check.getId());
			try {
				loginOk.infoSetting();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getSession().setAttribute("mbid", loginOk.getId());
			req.getSession().setAttribute("mbName", loginOk.getName());
			
			Cookie ck = new Cookie("id", loginOk.getId());
			if(saveId!=null){
				ck.setMaxAge(24*60*60);
			}else{
				ck.setMaxAge(0);
			}
			resp.addCookie(ck);
			msg = loginOk.getName()+"님, 환영합니다.";
			url = "index.jsp";
		}else if(res == LoginCheck.NOT_ID){
			msg = check.getId()+"는 없는 아이디 입니다.";
		}else if(res == LoginCheck.NOT_PWD){
			msg = check.getId()+"님의 패스워드가 틀렸습니다.";
		}else if(res == LoginCheck.ERROR){
			msg = "서버 오류발생!! 관리자에게 문의하세요";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
