package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

@WebServlet(name = "ProductDiscountCalculator" , value = "/display-discount")
public class ProductDiscountCalculator extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name =String.valueOf(req.getParameter("productDescription"));
        double price = Double.parseDouble(req.getParameter("listPrice"));
        double discount = Double.parseDouble(req.getParameter("discountPercent"));

            double discountAmount = price * discount * 0.01;
            double discountPrice = price - discountAmount;
            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<h2>Tên sản phẩm: " + name + "</h1><br>");
            writer.println("<h2>Phần trăm triết khấu: "+ discount + "</h2><br>");
            writer.println("<h2> Giá ban đầu: "+price+"</h2><br>");
            writer.println("<h2> Lượng triết khấu: " + discountAmount + "</h2><br>");
            writer.println("<h2> Giá sau khi trừ triết khấu: " + discountPrice + "</h2>");
            writer.println("</html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
