package com.example.student_servlet_jdbc.week12.service;

import com.example.student_servlet_jdbc.week12.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    List<Student> selectAllStudent()throws SQLException;
    void insertStudent(Student student)throws SQLException;
    Student selectStudent(int id)throws SQLException;
    boolean updateStudent(Student student)throws SQLException;
    boolean deleteStudent(int id)throws SQLException;
}
