package com.example.servlet_;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet" , value = "/computer")
public class CalculatorServlet extends HttpServlet {
    Calculator calculator = new Calculator();
    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float number1 = Float.parseFloat(req.getParameter("number1"));
        float number2 = Float.parseFloat(req.getParameter("number2"));
        String calculation = String.valueOf(req.getParameter("calculation"));
        float result = calculator.tinh(number1,number2,calculation);
        String sign = null;
        PrintWriter writer = resp.getWriter();
        switch (calculation){
            case "summation" : sign = " + ";
            break;
            case "subtraction" : sign = " - ";
            break;
            case "multiplication" : sign = " *" ;
            break;
            case "division" : sign = " / ";
            break;
        }
        writer.print(number1);
        writer.print(sign);
        writer.print(number2);
        writer.print(" = ");
        writer.print(result);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
