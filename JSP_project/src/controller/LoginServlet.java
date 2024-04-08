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
		// 사용자 ID와 비밀번호를 요청 파라미터에서 가져옵니다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 로그인 요청이 아닌 경우, 로그인 페이지로 이동합니다.
		if (id == null || password == null) {
			request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
			return;
		}

		// 사용자 서비스를 이용해 사용자 인증을 수행합니다.
		UserInfoSvc userInfoSvc = new UserInfoSvc();
		UserInfoDto userInfoDto = userInfoSvc.loginUser(id, password);

		if (userInfoDto != null) {
			// 로그인 성공: 사용자 세션 생성
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfoDto);

		
			response.sendRedirect("/view/welcome.jsp");
		} else {
			
			response.sendRedirect("Login.jsp?error=true");
		}
	}
}