package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "StudentServlet" , value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String maSv = req.getParameter("maSv");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email =String.valueOf(req.getParameter("email"));

        while (true){
            if (maSv != "" && name != "" && address != "" && phoneNumber != ""){
                PrintWriter writer = resp.getWriter();
                writer.println(maSv);
                writer.println(name);
                writer.println(address);
                writer.println(phoneNumber);
                writer.println(email);
                break;
            }else {
                PrintWriter writer = resp.getWriter();
                writer.println("Không hợp lệ !");
                break;
            }
        }
        try {
            insertDataToSql(maSv,name,address,phoneNumber,email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void insertDataToSql(String maSv, String name, String address, String phoneNumber , String email) throws SQLException {
        JDBC jdbc = new JDBC();
        Connection connection = jdbc.connect();
        String query = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";

        PreparedStatement prtm = connection.prepareStatement(query);
        prtm.setString(1,maSv);
        prtm.setString(2,name);
        prtm.setString(3,address);
        prtm.setString(4,phoneNumber);
        prtm.setString(5,email);

        int row = prtm.executeUpdate();
        if (row != 0 ){
            System.out.println("Thêm thành công !");
        }
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
