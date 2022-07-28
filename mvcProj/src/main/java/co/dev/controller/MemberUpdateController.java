package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.Utils;
import co.dev.domain.Member;

// 수정 컨트롤
public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		// 파라미터
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		System.out.println("id = " + id);
		System.out.println("pwd = " + pwd);
		System.out.println("name = " + name);
		System.out.println("mail = " + mail);
		
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setMail(mail);
		
		memberService.modifyMember(member);
		
		// member 공유
		req.setAttribute("member", member);
		Utils.forward(req, resp, "memberResult/memberUpdateResult.jsp");
		
		
	}

}
