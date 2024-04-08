package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dto.ProductInfoDto;
import service.ProductInfoSvc;

@WebServlet("/ViewProductsServlet")
public class ViewProductsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ProductInfoSvc productInfoSvc = null;

		String productName = request.getParameter("productName");
		if (productName != null && !productName.trim().isEmpty()) {
		    productInfoSvc = new ProductInfoSvc();
		    ArrayList<ProductInfoDto> productList = productInfoSvc.searchProductsByName(productName);
		    request.setAttribute("productList", productList);
		}
		request.getRequestDispatcher("/view/ViewProductsServlet.jsp").forward(request, response);
	}



}