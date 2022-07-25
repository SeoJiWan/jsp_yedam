package com.tst.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO {
	
	// 등록
	public void insertBoard(Board board) {
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
			}
			else {
				System.out.println("입력 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	// 전체 조회
	public List<Board> boardList() {
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
				board.setCreateDate(rs.getDate(5).toString());
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
	public Board getBoard(int boardId) {
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
				board.setCreateDate(rs.getDate(5).toString());
				board.setVisitCnt(rs.getInt(6));
				
				improveVisitCnt(boardId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return board;
	}
	
	// 조회수 증가
	public void improveVisitCnt(int boardId) {
		try {
			String sql = "update board set visit_cnt=visit_cnt+1 where board_id = ?";
			connect();
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardId);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + " 건 수정.");
			}
			else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
