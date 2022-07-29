package co.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.dev.domain.Member;

public class MemberJsonController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// [{"name": "hong", "age": 14},{"name": "kim", "age": 18}]
		
		List<Member> members = memberService.findAllMembers();
		
		resp.setContentType("text/json;utf-8");
		
//		String json = "[{\"name\": \"hong\", \"age\": 14},{\"name\": \"kim\", \"age\": 18}]";
		
		JsonArray jarr = new JsonArray();
		
		for(Member member : members) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("id", member.getId());
			jobj.addProperty("pwd", member.getPwd());
			jobj.addProperty("name", member.getName());
			jobj.addProperty("mail", member.getMail());
			
			jarr.add(jobj);
		}
		
		try {
			resp.getWriter().print(jarr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
