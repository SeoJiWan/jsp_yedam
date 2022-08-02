package co.edu.service;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

public class MemberService {
	/*
	 * Field
	 */
	private static MemberService memberService = new MemberService();
	MemberDAO dao = new MemberDAO();

	/*
	 * Constructor
	 */
	private MemberService() {}

	/*
	 * Method
	 */
	public static MemberService getMemberService() {
		return memberService;
	}
	
	// 회원가입
	public void joinMember(MemberVO member) {
		dao.insert(member);
	}
	
	// 단건조회
	public MemberVO findOneMember(String memberId) {
		return dao.selectOne(memberId);
	}
	
	// 로그인
	public MemberVO login(String id, String password) {
		MemberVO member = dao.selectOne(id);
		if (member != null) {
			if (member.getPassword().equals(password)) {
				return member;
			}
		}
		return null;
	}
	
	// id 중복체크
	public String idDuplCheck(String id) {
		MemberVO member = dao.selectOne(id);
		if (member == null) {
			return "";
		}
		return member.getMemberId();
	}
}
