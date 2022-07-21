package ex.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//servlet mapping이름이 login임
@WebServlet("/html/login")
public class LoginServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init called");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy called");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        //요청의 내용을 받아옴(request.getParameter:name을 알고 값이 하나일 때)
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디:"+user_id);
		System.out.println("비밀번호:"+user_pw);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        //요청의 내용을 받아옴(request.getParameter:name을 알고 값이 하나일 때)
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		System.out.println("아이디:"+user_id);
		System.out.println("비밀번호:"+user_pw);
	}

}