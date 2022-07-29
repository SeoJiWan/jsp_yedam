package co.dev.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.domain.Member;

public class memberInsertUseAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 회원정보 등록 -> json 반환
		resp.setContentType("text/json;utf-8");
		
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

		memberService.joinMember(member);
		
		// json 반환
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(member));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
