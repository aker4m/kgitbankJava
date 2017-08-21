package admin.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.*;

public class Cate_input_okCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDTO dto = new CategoryDTO();
		dto.setCode(req.getParameter("code"));
		dto.setCnum(Integer.parseInt(req.getParameter("num")));
		dto.setCname(req.getParameter("name"));
		CategoryBean bean = new CategoryBean();
		String msg = null, url=null;
		
		try {
			int res = bean.insertCate(dto);
			if(res>0){
				msg = "카테고리 등록 성공 !! 카테고리 목록페이지로 이동합니다.";
				url = "cate_list.admin";
			}else{
				msg = "카테고리 등록 실패 !! 카테고리 등록페이지로 이동합니다.";
				url = "cate_input.admin";
			}
		} catch (SQLException e) {}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
