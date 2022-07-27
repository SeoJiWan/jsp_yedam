package co.dev.service;
import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.domain.Member;

public class MemberService {

	/*
	 * Field
	 */
	// 싱글톤
	private static MemberService memberService = new MemberService();
	MemberDAO memberDAO = new MemberDAO();

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
	public void joinMember(Member member) {
		memberDAO.insert(member);
	}
	
	// 회원 단건 조회
	public Member findOneMember(String id) {
		return memberDAO.selectOne(id);
	}
	
	// 회원 전체 조회
	public List<Member> findAllMembers() {
		return memberDAO.selectAll();
	}
}
