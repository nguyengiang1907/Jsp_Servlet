package com.example.student_servlet_jdbc.week12.service;
import com.example.student_servlet_jdbc.week12.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demoStudent";
    private String jdbcUsername = "root";
    private String jdbcPassword = "giang";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        return connection;
    }
    private final String SELECT_ALL_STUDENT = "SELECT * FROM STUDENT";
    private final String INSERT_INTO_STUDENT = "INSERT INTO STUDENT(name,sex,address) VALUES(?,?,?)";
    private final String SELECT_STUDENT_ID = "SELECT id,name,sex,address FROM STUDENT WHERE id = ?";
    private final String UPDATE_STUDENT_ID = "UPDATE STUDENT SET name=?,sex=?,address=? WHERE id = ?";
    private final String DELETE_STUDENT_ID = "DELETE FROM STUDENT WHERE id = ?";
    @Override
    public List<Student> selectAllStudent() {
        // Bước 1 tạo List chứa lớp Student <Mảng này là mảng rỗng>
        List<Student> students = new ArrayList<>();
        // Tạp Connection để chưa phương thức getConnection kết nối với SQL
        try(Connection connection = getConnection();
            // Tạo PreparedStatement tạo các câu thực thi truy vấn tới SQL
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)){
            // Tạo ResultSet chứa các dữ liệu từ CSDL
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                // Lấy ra từng trường dữ liệu trên CSDL
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int id = rs.getInt("id");
                // Thực hiện add các dữ liệu vừa nhận từ CSDL vào lớp 
                students.add(new Student(id,name,sex,address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_INTO_STUDENT);
        try(Connection connection = getConnection();
            // Kết nối với CSDL và thực hiện câu truy vấn
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENT)) {
            // Set giá trị gửi lên CSDL
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSex());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.executeUpdate();
            // Truy vấn thực thi và tha đổi cơ sỡ dữ liệu
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Student selectStudent(int id) throws SQLException {
        Student student = null;
        try(Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_ID);) {

            preparedStatement.setInt(1,id);
            System.out.println(SELECT_STUDENT_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                student = new Student(id,name,sex,address);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowStudent;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_ID);){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSex());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setInt(4,student.getId());
            rowStudent = preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowStudent;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDelete;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_ID)){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

}
