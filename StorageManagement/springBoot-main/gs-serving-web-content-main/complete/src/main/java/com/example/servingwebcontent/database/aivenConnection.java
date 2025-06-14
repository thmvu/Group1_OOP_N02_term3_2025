package com.example.servingwebcontent.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;



public class aivenConnection {
    /*
     * mysql://avnadmin:AVNS_2ZlIVz4ACEb86Eu0Exr@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED
     */
    public void aivenConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://avnadmin:AVNS_RE3O2bhYZ_1_6ER7YK7@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                    "sqluser", "password");

                  //  AVNS_2ZlIVz4ACEb86Eu0Exr
            Statement sta = conn.createStatement();
            ResultSet reset = sta.executeQuery("select * from user");
            System.out.println("Display data from database: ");
            while (reset.next()) {
                String userID = reset.getString("userId");
                String username = reset.getString("username");
                String address = reset.getString("address");
                System.out.println(userID + " " + username + " " + address);

            }

            reset.close();
            sta.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connecion");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
