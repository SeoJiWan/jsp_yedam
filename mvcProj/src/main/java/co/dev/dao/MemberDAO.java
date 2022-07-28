package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.domain.Member;

public class MemberDAO extends DAO {

	/*
	 * Method
	 */
	// 삽입
	public void insert(Member member) {
		String sql = "insert into member values(?, ?, ?, ?)";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getMail());

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
	public void update(Member member) {
		String sql = "update member set name = ?, password = ?, mail = ? " + "where id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getMail());
			ps.setString(4, member.getId());

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

	// 삭제
	public void delete(String id) {
		String sql = "delete from member where id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

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

	// 단건조회
	public Member selectOne(String id) {
		Member member = null;
		String sql = "select * from member where id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setPwd(rs.getString(3));
				member.setMail(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	// 전체조회
	public List<Member> selectAll() {
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member order by 1";
		connect();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setPwd(rs.getString(3));
				member.setMail(rs.getString(4));

				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
