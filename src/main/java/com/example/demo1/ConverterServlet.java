package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet" , value = "/converter")
public class ConverterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float rate = Float.parseFloat(req.getParameter("rate"));
        float usd = Float.parseFloat(req.getParameter("usd"));

        float vnd = rate * usd;

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<h1>Rate: " + rate + "</h1>");
        writer.println("<h1>Usd: " + usd + "</h1>");
        writer.println("<h1>VND: " + vnd + "</h1>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
    }
}
