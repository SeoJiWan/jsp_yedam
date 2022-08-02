package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.vo.MemberVO;

public class MemberJoinControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원가입화면: 회원가입 후 첫페이지로 이동.
		MemberVO member = new MemberVO();
		
		member.setMemberId(req.getParameter("memberId"));
		member.setPassword(req.getParameter("memberPassword"));
		member.setName(req.getParameter("memberName"));
		member.setAddress(req.getParameter("memberAddress"));
		
		System.out.println("member = " + member);
		
		memberService.joinMember(member);
		
		resp.sendRedirect("./main.do");

	}

}
