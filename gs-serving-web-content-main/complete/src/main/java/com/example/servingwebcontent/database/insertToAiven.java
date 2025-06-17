package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.lang.System;

import com.example.servingwebcontent.User;

public class insertToAiven {
    public void insertToAiven(User u){
        Connection conn = null;
        System.out.println(
            String.format("The current shell is: %s.",System.getenv("port!")));


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://avnadmin:AVNS_U7GdPSqWnwNiHeo_OK3@mysql-eee7f4a-minhvu6723.g.aivencloud.com:14771/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_U7GdPSqWnwNiHeo_OK3"
            );
            Statement sta = conn.createStatement();

            //random user_id
            Random rand = new Random();
            int id = rand.nextInt(1000000); // Random user_id between 0 and 999999

            String userIdVal = "u" + id;
            String ur = u.getFullName();
            String ad = u.getAddress();
            String g = u.getGender();
            String d = u.getDob();
            String p = u.getPhone();
            String e = u.getEmail();
            String pass = u.getPassword();
            String r = u.getRole();

             String reset = "INSERT INTO users (user_id, full_name, gender, dob, phone, email, address, password, role) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(reset)){
            pst.setString(1, userIdVal);
                pst.setString(2, ur);
                pst.setString(3, g);
                pst.setString(4, d);
                pst.setString(5, p);
                pst.setString(6, e);
                pst.setString(7, ad);
                pst.setString(8, pass);
                pst.setString(9, r);
                pst.executeUpdate();
        }
        System.out.println("Display data from database :");

        sta.close();
        conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connection");
            System.out.println(e);
            e.printStackTrace();
        }
        
    }
}
