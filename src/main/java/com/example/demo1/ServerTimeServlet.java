package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet(name = "ServerTimeServlet", urlPatterns = "/time")
public class ServerTimeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response){

    }

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("");
        Date today = new Date();
        writer.println("Thời gian : ");
        writer.println("<h1>"+today+"<h1>");
        writer.println("");
    }

    @Override
    public void destroy() {
    }
}
