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
        if (session == null || session.getAttribute("userId") == null) {
            // 사용자가 로그인하지 않았을 경우
            response.sendRedirect("LoginServlet");
            return;
        }

        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Search Product</title></head><body>");
        out.println("<h2>상품 조회</h2>");
        out.println("<form action='LoginNSearch' method='POST'>");
        out.println("상품명: <input type='text' name='productname'><br>");
        out.println("<input type='submit' value='Search'>");
        out.println("<a href='logout'> Logout</a>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String productName = request.getParameter("productname");
       
        ProductInfoSvc productInfoSvc = new ProductInfoSvc();
        ArrayList<ProductInfoDto> products = productInfoSvc.searchProductsByName(productName);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Search Results</title></head><body>");
        out.println("<h2>검색 결과</h2>");
        
        
        if (products.isEmpty()) {
            out.println("<p>조회하시는 상품이 없습니다.</p>");
        } else {
            out.println("<ul>");
            for (ProductInfoDto product : products) {
                double discountedPrice = product.getPrice() * 0.9; // 10% 할인
                out.println("<li>" + product.getProname() + " - 원가: " + product.getPrice() + ", 할인가: " + String.format("%.2f", discountedPrice) + "</li>");
            }
            out.println("</ul>");
        }
        out.println("<a href='LoginNSearch'>다시 검색</a>");
        out.println("</body></html>");
    }

}
