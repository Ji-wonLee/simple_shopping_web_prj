package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dto.UserInfoDto;
import service.UserInfoSvc;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		UserInfoDto userInfo = (session != null) ? (UserInfoDto) session.getAttribute("userInfo") : null;
		//세션 에서 사용자 정보 조회

		if (userInfo == null) {
			// 세션이 없으면 로그인 페이지
			resp.sendRedirect("LoginServlet");

		}else {



			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><head><title>Welcome</title></head><body>");
			out.println("<h1>어서오세요, " + userInfo.getName() + "님" + "</h1>");
			out.println("<p>로그인 성공.</p>");
		
			//out.println("<a href='logout'>Logout</a>"); // 로그아웃 기능
			out.println("<form action=\"logout\" method=\"GET\">");
			out.println("<button type=\"submit\">logout</button>");
			out.println("</form>");
			
			out.println("<form action=\"LoginNSearch\" method=\"GET\">");
			out.println("<button type=\"submit\">상품 조회하기</button>");
			out.println("</form>");
			
//			out.println("<a href='LoginNSearch'>상품 조회하기</a>");
			out.println("</body></html>");
		}
	}
}
