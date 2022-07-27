package co.dev.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.Utils;
import co.dev.domain.Member;

public class MemberListController implements Controller {
	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		List<Member> list = memberService.findAllMembers();
//		list.forEach(System.out::println);

		// 요청정보에 member 를 담아줌
		req.setAttribute("memberList", list);
		
		Utils.forward(req, resp, "memberResult/memberListResult.jsp");
	}
}
