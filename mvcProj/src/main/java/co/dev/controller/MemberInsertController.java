package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.Utils;
import co.dev.domain.Member;

public class MemberInsertController implements Controller {

	/*
	 * Method
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 입력 -> 뷰페이지
		// memberInsert.jsp 에서 memberInsert.do 로 요청
		// --> *.do url 요청이 들어오면 FrontController 실행
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");

		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setMail(mail);

		memberService.joinMember(member);

		// 요청정보에 member 를 담아줌
		req.setAttribute("member", member);
		
		Utils.forward(req, resp, "memberResult/memberInsertResult.jsp");

	}


}
