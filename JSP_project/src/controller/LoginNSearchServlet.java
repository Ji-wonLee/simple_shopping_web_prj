package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dto.ProductInfoDto;
import service.ProductInfoSvc;

@WebServlet("/LoginNSearch")
public class LoginNSearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 로그인 여부 확인
		if (session == null || session.getAttribute("userInfo") == null) {
			
			//response.sendRedirect("/view/index.html");
			request.getRequestDispatcher("/WEB-INF/view/index.html").forward(request, response);
			
			return;
		}

		
		String productName = request.getParameter("productName");
		if (productName != null && !productName.trim().isEmpty()) {
		    ProductInfoSvc productInfoSvc = new ProductInfoSvc();
		    ArrayList<ProductInfoDto> productList = productInfoSvc.searchProductsByName(productName);
		    request.setAttribute("productList", productList);
		    
		}
		request.getRequestDispatcher("/WEB-INF/view/LoginNSearch.jsp").forward(request, response);
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}