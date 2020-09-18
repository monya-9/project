package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/member/MemberLoginServ","/member/logout"})
public class MemberLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("../index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Member2VO memberVO = new Member2VO();
		memberVO.setMember_id(request.getParameter("member_id"));
		memberVO.setMember_pw(request.getParameter("member_pw"));

		
		Member2VO resultVO = Member2DAO.getinstance().selectOne(memberVO);
		
		String page = "";
		if(resultVO==null) {	//id가 없음
			page = "memberLogin.jsp";
			request.setAttribute("errormsg", "해당ID가 없습니다.");
		}
		else 
		{
			if(memberVO.getMember_pw().equals(resultVO.getMember_pw())) {	//로그인 성공
				page = "/index.jsp";
				request.getSession().setAttribute("memberLogin", resultVO);
				request.getSession().setAttribute("member_id", resultVO.getMember_id());
			} else {	//패스워드 불일치
				request.setAttribute("errormsg", "패스워드 불일치");
				page = "memberLogin.jsp";
			}
		}
		
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
