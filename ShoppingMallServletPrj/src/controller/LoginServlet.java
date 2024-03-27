package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserInfoSvc;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 폼을 보여주는 HTML 응답
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String htmlForm = "<!DOCTYPE html>" +
                          "<html>" +
                          "<head><title>Login</title></head>" +
                          "<body>" +
                          "<h2>Login</h2>" +
                          "<form method='POST'>" +
                          "ID: <input type='text' name='id'><br>" +
                          "Password: <input type='password' name='password'><br>" +
                          "<input type='submit' value='Login'>" +
                          "</form>" +
                          "</body>" +
                          "</html>";
        out.println(htmlForm);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserInfoSvc userInfoSvc = new UserInfoSvc();
        boolean loginResult = userInfoSvc.loginUser(id, password);

        if(loginResult) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);

            // 로그인 성공 응답
            response.sendRedirect("welcome"); // 로그인 성공 페이지로 리다이렉트. 'welcome'은 성공 페이지의 URL.
        } else {
            // 로그인 실패 응답
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html><html><head><title>Login Failed</title></head><body>");
            out.println("<p>로그인 실패</p>");
            out.println("<a href='LoginServlet'>Try again</a>");
            out.println("</body></html>");
        }
    }

}
