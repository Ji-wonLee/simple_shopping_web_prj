package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Login Page</title></head><body>");
        out.println("<h2>Login</h2>");
        out.println("<form action='LoginServlet' method='POST'>"); // 로그인 폼
        out.println("ID: <input type='text' name='id'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<input type='submit' value='Login'>"); // 로그인 버튼
        out.println("<a href='index.html'> 뒤로가기</a>");
        
        out.println("</form>");
        // 상품 조회 페이지로 이동
//        out.println("<a href='ViewProductsServlet'>View Products Without Login</a>");
//        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserInfoSvc userInfoSvc = new UserInfoSvc();
        UserInfoDto userInfo = userInfoSvc.loginUser(id, password);

        if(userInfo != null) {
            HttpSession session = request.getSession();
            
            //세션값 설정
            session.setAttribute("userId", id);
            session.setAttribute("userInfo",  userInfo);
            
            
            // 로그인 성공
            response.sendRedirect("welcome"); 
        } else {
            // 로그인 실패
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html><html><head><title>Login Failed</title></head><body>");
            out.println("<p>로그인 실패</p>");
            out.println("<a href='LoginServlet'>Try again</a>");
            out.println("</body></html>");
        }
    }

}
