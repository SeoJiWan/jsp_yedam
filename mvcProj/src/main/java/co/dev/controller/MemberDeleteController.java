package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.Utils;

public class MemberDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");
		
		memberService.deleteMember(id);
		
		req.setAttribute("deletedId", id);
		Utils.forward(req, resp, "memberResult/memberDeleteResult.jsp");
		
	}

}
