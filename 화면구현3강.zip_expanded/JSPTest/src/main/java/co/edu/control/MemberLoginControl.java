package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.vo.MemberVO;

public class MemberLoginControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 성공 시 memberLoginSuccess.jsp로 이동.
		// 로그인 실패 시 memberLoginFail.jsp로 이동.
		HttpSession ss = req.getSession();
		
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPassword");
		System.out.println("id = " + id);
		System.out.println("pwd = " + pwd);
		
		MemberVO member = memberService.login(id, pwd);
		System.out.println("member = " + member);
		
		if (member == null) {
			HttpUtil.forward(req, resp, "member/memberLoginFail.tiles");
		}
		else {
			req.setAttribute("member", member);
			HttpUtil.forward(req, resp, "member/memberLoginSuccess.tiles");	
			ss.setAttribute("member", member);
		}
		
		
	}

}
