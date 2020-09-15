package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberSelectAllServ
 */
@WebServlet("/member/memberSelectAllServ")
public class memberSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member2DAO dao = new Member2DAO();
		ArrayList<Member2VO> list =dao.selectAll(null);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("memberSeletAll.jsp").forward(request, response);
		
	}		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
