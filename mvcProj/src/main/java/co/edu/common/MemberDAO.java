package co.edu.common;

import java.sql.SQLException;

public class MemberDAO extends DAO {

	// 입력
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

}
