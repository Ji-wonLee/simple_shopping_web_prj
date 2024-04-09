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
		if (session == null || session.getAttribute("userInfo") == null) {
			//resp.sendRedirect("/view/index.html");
			req.getRequestDispatcher("/WEB-INF/view/LoginNSearch.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/view/LoginNSearch.jsp").forward(req, resp);
		}

	}
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}
