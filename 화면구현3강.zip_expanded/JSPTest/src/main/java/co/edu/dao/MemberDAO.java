package co.edu.dao;

import java.sql.SQLException;

import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	
	/*
	 * Method
	 */
	// 삽입
	public void insert(MemberVO member) {
		String sql = "insert into test_member values(?, ?, ?, ?)";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getName());
			ps.setString(4, member.getAddress());

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

	// 단건조회
	public MemberVO selectOne(String memberId) {
		MemberVO member = null;
		String sql = "select * from test_member where id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);

			rs = ps.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setMemberId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setAddress(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

}
