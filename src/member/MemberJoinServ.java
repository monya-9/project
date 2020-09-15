package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/MemberJoinServ")
public class MemberJoinServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("등록실행");
		
		Member2VO memberVO = new Member2VO();
		memberVO.setMember_id(request.getParameter("member_id"));
		memberVO.setMember_pw(request.getParameter("member_pw"));
		memberVO.setNickname(request.getParameter("nickname"));
		memberVO.setMember_tel(request.getParameter("member_tel"));
		memberVO.setMember_email(request.getParameter("member_email"));
		memberVO.setSignup_date(request.getParameter("signup_date"));
		memberVO.setGender(request.getParameter("gender"));		
		
		Member2DAO dao = new Member2DAO();
		dao.insert(memberVO);
		
		response.sendRedirect("memberSelectAll.jsp");
	}

}
