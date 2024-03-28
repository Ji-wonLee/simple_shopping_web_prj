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

		ProductInfoSvc productInfoSvc = new ProductInfoSvc();

		
		out.println("<html><head><title>사탕 목록</title></head><body>");
		out.println("<h2>상품 검색</h2>");
		out.println("<form action='' method='GET'>");
		out.println("상품명: <input type='text' name='productname'><br>");
		out.println("<input type='submit' value='Search'>");
		//out.println("<a href='index.html'> 뒤로가기</a>");
		out.println("</form>");
		out.println("<form action=\"index.html\" method=\"GET\">");
		out.println("<button type=\"submit\">뒤로가기</button>");
		out.println("</form>");

		
		String productName = request.getParameter("productname");
		if (productName != null && !productName.trim().isEmpty()) {
			ArrayList<ProductInfoDto> products = productInfoSvc.searchProductsByName(productName);
			if (products.isEmpty()) {
				out.println("<p>검색 결과가 없습니다.</p>");
			} else {
				out.println("<ul>");
				for (ProductInfoDto product : products) {
					out.println("<li>" + product.getProname() + " - 가격: " + product.getPrice() + "</li>");
				}
				out.println("</ul>");
			}
		}
		out.println("</body></html>");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
}
