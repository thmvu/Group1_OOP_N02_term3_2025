package com.example.servingwebcontent.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;


public class aivenConnection {

    public void aivenConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_U7GdPSqWnwNiHeo_OK3@mysql-eee7f4a-minhvu6723.g.aivencloud.com:14771/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_U7GdPSqWnwNiHeo_OK3"
            );
            // You can add your logic here, e.g., create a Statement or execute a query
            Statement sta = conn.createStatement();
            ResultSet reset = sta.executeQuery("SELECT * FROM users"); // Replace with your table name
             System.out.println("Displaying data from users table:");
             while (reset.next()){
                String user_id = reset.getString("user_id");
                String full_name = reset.getString("full_name");
                String gender = reset.getString("gender");
                Date dob = reset.getDate("dob");
                String phone = reset.getString("phone");
                String email = reset.getString("email");
                String address = reset.getString("address");
                String password = reset.getString("password");
                String role = reset.getString("role");

                System.out.println("ID: " + user_id + 
                                   ", Ten: " + full_name + 
                                   ", Gioi Tinh: " + gender + 
                                   ", Ngay Sinh: " + dob + 
                                   ", SDT: " + phone + 
                                   ", Email: " + email + 
                                   ", Dia Chi: " + address + 
                                   ", Mat Khau: " + password + 
                                   ", Vai Tro: " + role);
             }

            reset.close();
            sta.close();
            conn.close();
        }
        catch(Exception e) {
            System.out.println("Error in database connetion");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } 
         
    }

}
