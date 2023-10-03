package com.example.student_servlet_jdbc.week13.demo;

import java.sql.*;

public class ViDuJDBC {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sinhvien";

    static final String USER = "root";
    static final String PASS = "giang";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try{
            // Buoc 2: Dang ky Driver
            Class.forName(JDBC_DRIVER);

            // Buoc 3: Mo mot ket noi
            System.out.println("Dang ket noi toi co do du lieu .....");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Buoc 4: Thiet lap auto commit la false
            conn.setAutoCommit(false);

            // Buoc 5: Thuc thi truy van
            System.out.println("Tao cac lenh truy van SQL......");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            // Buoc 6: Chen mot hang vao trong bang sinhvienk60
            System.out.println("\n Chen mot bang.....");
            String SQL = "INSERT INTO sinhvienk60 VALUES(5,'Tran Hung','Cuong',7.5)";
            stmt.executeUpdate(SQL);

            // Buoc 7: Chen them mot hang vao trong bang sinhvienk60
            SQL = "INSERT INTO sinhvienk60 " +
                    "VALUES (6, 'Vu Ngoc', 'Phan', 6.5)";
            stmt.executeUpdate(SQL);

            // Buoc 8: Ky thac cac thay doi.
            System.out.println("\n Ky thac cac thay doi.......");
            conn.commit();

            // Buoc 9: Liet ke tat ca cac ban ghi.
            String sql = "SELECT masv,ho,ten,diemthi FROM sinhvienk60";
            ResultSet resultSet = stmt.executeQuery(sql);
            System.out.println("\n Liet ke Result set dem tham chieu.....");
            printRs(resultSet);

            // Buoc 10: Don sach moi truong va giai phong resource
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            // Xu ly cac loi cho JDBC
            e.printStackTrace();
            // Neu xuat hien loi thi xoa sach cac thay doi
            // va tro ve trang thai truoc khi co thay doi.
            System.out.println("\nQuay ve trang thai truoc thay doi ...");
            try{
                if(conn !=null)
                    conn.rollback();
            }catch(SQLException se2){
                se2.printStackTrace();
            }// Ket thuc khoi try
        }catch (Exception e){
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        }finally{
            // Khoi finally duoc su dung de dong cac resource
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }// Ket thuc khoi finally
        }// Ket thuc khoi try
        System.out.println("\n Chuc cac ban hoc tot!");

    }
    public static void printRs(ResultSet rs) throws SQLException{
        // Bao dam chung ta da bat dau tu hang dau tien
        rs.beforeFirst();
        while(rs.next()){
            // Lay du lieu boi su dung ten cot
            int mssv  = rs.getInt("mssv");
            int diemthi = rs.getInt("diemthi");
            String ho = rs.getString("ho");
            String ten = rs.getString("ten");

            // Hien thi cac gia tri
            System.out.print("\nMSSV: " + mssv);
            System.out.print("\nHo: " + ho);
            System.out.println("\nTen: " + ten);
            System.out.print("\nDiem Thi: " + diemthi);
            System.out.print("\n=================");
        }
        System.out.println();
    }

}
