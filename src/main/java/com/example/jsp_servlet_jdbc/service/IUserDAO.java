package com.example.jsp_servlet_jdbc.service;

import com.example.jsp_servlet_jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

     List<User> selectAllUsers();
     User selectUser(int id);
     void insertUser(User user)throws SQLException;
     boolean editUser(User user)throws SQLException;
     boolean deleteUser(int id)throws SQLException;
}
