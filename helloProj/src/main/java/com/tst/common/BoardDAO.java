package com.tst.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO {

	// 등록
	public void insert(Board board) {
		try {
			String sql = "insert into board (board_id, title, content, writer) "
					+ "values(board_id_seq.nextval, ?, ?, ?)";
			connect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getWriter());

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

	// 수정
	public void update(Board board) {
		try {
			String sql = "update board set title = ?, content = ?, create_date = to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') "
					+ "where board_id = ?";
			connect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoardId());

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + " 건 수정.");
			} else {
				System.out.println("수정 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void delete(int boardId) {
		try {
			String sql = "delete from board where board_id = ?";
			connect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardId);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + " 건 삭제.");
			} else {
				System.out.println("삭제 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 전체 조회
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<Board>();
		try {
			String sql = "select * from board order by 1";
			connect();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Board board = new Board();

				board.setBoardId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setCreateDate(rs.getString(5));
				board.setVisitCnt(rs.getInt(6));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public Board selectOne(int boardId) {
		Board board = null;
		try {
			String sql = "select * from board where board_id = ?";
			connect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardId);

			rs = ps.executeQuery();

			if (rs.next()) {
				board = new Board();

				board.setBoardId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setCreateDate(rs.getString(5));
				board.setVisitCnt(rs.getInt(6));

				addVisitCnt(boardId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return board;
	}

	// 조회수 증가
	public void addVisitCnt(int boardId) {
		try {
			String sql = "update board set visit_cnt=visit_cnt+1 where board_id = ?";
			connect();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardId);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("조회수" + result + " 건 수정.");
			} else {
				System.out.println("조회수 수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 로그인 체크
	public User checkLogin(String id, String pwd) {
		User user = null;
		try {
			String sql = "select * from users where id = ? and password = ?";
			connect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setName(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}

}
