package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.dev.Utils;
import co.dev.domain.Member;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");
		String job = req.getParameter("job");
////		System.out.println("search id = " + id);
//		
		Member member = memberService.findOneMember(id);
		System.out.println("member = " + member);
//		
		if (member == null) {
			req.setAttribute("error", "해당하는 ID 가 없습니다.");
			Utils.forward(req, resp, "memberView/memberSearch.jsp");
			
		}
		else {
			req.setAttribute("findMember", member);
			Utils.forward(req, resp, "memberResult/memberSearchResult.jsp");
		}
		
		
	}

}
