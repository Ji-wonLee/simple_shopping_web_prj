package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfoDto;
import service.UserInfoSvc;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		
		if (id == null || password == null) {
			request.getRequestDispatcher("/WEB-INF/view/Login.jsp").forward(request, response);
			return;
		}

		// 사용자 서비스를 이용해 사용자 인증을 수행
		UserInfoSvc userInfoSvc = new UserInfoSvc();
		UserInfoDto userInfoDto = userInfoSvc.loginUser(id, password);

		if (userInfoDto != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfoDto);

		
			//response.sendRedirect("/view/welcome.jsp");
			request.getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);
		} else {
			//실패
			//response.sendRedirect("/view/LoginFailed");
			request.getRequestDispatcher("/WEB-INF/view/LoginFailed.jsp").forward(request, response);
			
		}
	}
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}