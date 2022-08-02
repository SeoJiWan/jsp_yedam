package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardService {
	
	/*
	 * Field
	 */
	private static BoardService boardService = new BoardService();
	BoardDAO dao = new BoardDAO();

	/*
	 * Constructor
	 */
	private BoardService() {}

	/*
	 * Method
	 */
	public static BoardService getBoardService() {
		return boardService;
	}
	
	// 글 작성
	public void writeBoard(BoardVO board) {
		dao.insert(board);
	}
	
	// 전체 글 조회
	public List<BoardVO> findAllBoards() {
		return dao.selectAll();
	}
	
	// 페이징
	public List<BoardVO> findAllBoardsPaging(Criteria cri) {
		return dao.selectAllPaging(cri);
	}
 
}
