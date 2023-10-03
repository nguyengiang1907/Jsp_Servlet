package com.example.student_servlet_jdbc.week12.controller;

import com.example.student_servlet_jdbc.week12.model.Student;
import com.example.student_servlet_jdbc.week12.service.IStudentDAO;
import com.example.student_servlet_jdbc.week12.service.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create" :
                try {
                    insertStudent(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "edit":
                try {
                    updateStudent(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                 showNewForm(request, response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                 try {
                     deleteStudent(request, response);
                  } catch (SQLException e) {
                    throw new RuntimeException(e);
                 }
                break;
            default:
                // Ban đầu giá trị bằng rỗng nên được chạy vào listStudent
                try {
                    listStudent(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    public void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        // Tạo mảng list chứa Student gọi tới phương thức và lấy được dữ liệu từ SQL
        List<Student> list = studentDAO.selectAllStudent();

        // Set giá trị cho mảng list
        request.setAttribute("list", list);
        // Chuyển và gửi dữ liệu sang trang list.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
    public void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        // Tạo trường dữ liệu chứa các
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");

        // Tạo đối tượng newStudent có các giá trị vừa set
        Student newStudent = new Student(name,sex,address);
        // Truyền đối tượng vào studentDao truyền dữ liệu tới SQP
        studentDAO.insertStudent(newStudent);
        // Chuyển và truyền dữ liệu tới trang create.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }
    public void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }
    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        Student edit = new Student(id,name,sex,address);
        studentDAO.updateStudent(edit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request,response);
    }
    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student edit = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("student",edit);
        dispatcher.forward(request,response);
    }
    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        studentDAO.deleteStudent(id);
        List<Student> list = studentDAO.selectAllStudent();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);

    }

}
