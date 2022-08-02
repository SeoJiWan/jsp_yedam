package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;
import co.edu.vo.Page;

public class BoardListPagingContorl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		
		Criteria cri = new Criteria(); // 1, 10건
		cri.setPageNum(Integer.parseInt(pageNum));
		cri.setAmount(Integer.parseInt(amount));
		
		List<BoardVO> pageList = boardService.findAllBoardsPaging(cri);
		pageList.forEach(System.out::println);
		
		req.setAttribute("list", pageList);
		
		List<BoardVO> totalList = boardService.findAllBoards();
		int total = totalList.size();
		req.setAttribute("pageInfo", new Page(cri, total)); // 현재페이지, 시작, 마지막페이지
		
		HttpUtil.forward(req, resp, "board/boardList.tiles");

	}

}
