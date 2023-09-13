package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "LoginServlet",  value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        PrintWriter writer = response.getWriter();
        if ("admin".equalsIgnoreCase(userName) && "1234".equalsIgnoreCase(passWord)){
            writer.println("<H1>Welcome " + userName + " to website</H1>");
        }else {
            writer.println("<h1>login Error</h1>");
        }
    }

    @Override
    public void destroy() {
    }
}
