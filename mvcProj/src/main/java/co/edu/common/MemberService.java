package co.edu.common;

public class MemberService {
	/*
	 * Field
	 */
	// 싱글톤
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
	public void joinMember(Member member) {
		dao.insert(member);
	}

	
	
}
