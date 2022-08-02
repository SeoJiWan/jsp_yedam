package co.edu.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.service.BoardService;
import co.edu.service.MemberService;

public interface Controller {
	
	MemberService memberService = MemberService.getMemberService();
	BoardService boardService = BoardService.getBoardService();
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
