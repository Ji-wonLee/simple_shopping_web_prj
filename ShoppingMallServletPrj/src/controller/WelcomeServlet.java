package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String userId = (session != null) ? (String) session.getAttribute("userId") : null;

        if (userId == null) {
            // 세션이 없으면 로그인 페이지로 리다이렉트
            resp.sendRedirect("LoginServlet");
            return;
        }

        // 로그인 성공 후 환영 페이지 생성
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Welcome</title></head><body>");
        out.println("<h1>Welcome, " + userId + "</h1>");
        out.println("<p>로그인 성공.</p>");
        out.println("<a href='logout'>Logout</a>"); // 로그아웃 기능을 구현하는 서블릿 경로
        out.println("</body></html>");
    }
}