package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.dao.BoardDAO;
import co.edu.service.BoardService;
import co.edu.vo.BoardVO;
import co.edu.vo.MemberVO;

public class InsertBoardControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO member = (MemberVO) req.getSession().getAttribute("member");
		BoardVO board = new BoardVO();
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		board.setWriter(member.getMemberId());
		
		boardService.writeBoard(board);
		
		HttpUtil.forward(req, resp, "board/boardWriteResult.tiles");

	}

}
