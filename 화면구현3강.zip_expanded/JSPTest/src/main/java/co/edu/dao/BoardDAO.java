package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardDAO extends DAO {

	/*
	 * Method
	 */
	// 삽입
	public void insert(BoardVO board) {
		String sql = "insert into test_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getWriter());
			ps.setString(3, board.getContent());

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + " 건 입력.");
			} else {
				System.out.println("입력 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 전체조회
	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<>();
		String sql = "select * from test_board order by 1 desc";
		connect();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setWrite_date(rs.getDate(5));
				board.setVisit_cnt(rs.getInt(6));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 페이징 처리 전체조회
	public List<BoardVO> selectAllPaging(Criteria cri) {
		List<BoardVO> list = new ArrayList<>();
		String sql = "select seq, title, writer, content, write_date, visit_cnt "
				+ "from (select rownum rn, seq, title, writer, content, write_date, visit_cnt "
				+ "      from (select seq, title, content, writer, write_date, visit_cnt "
				+ "            from test_board "
				+ "            order by seq desc) "
				+ "      where rownum <= ?) "
				+ "where rn > ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cri.getAmount() * cri.getPageNum()); // 10 * 2
			ps.setInt(2, cri.getAmount() * (cri.getPageNum() - 1));

			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setWrite_date(rs.getDate(5));
				board.setVisit_cnt(rs.getInt(6));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
