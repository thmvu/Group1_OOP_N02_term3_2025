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
    public void insertToAivenDb(User u) {
        Connection conn = null;
        /*
         * String user = System.getenv("user");
         * String password = System.getenv("password");
         * String host = System.getenv("host");
         * String port = System.getenv("port");
         * String databaseName = System.getenv("databaseName");
         */

        System.out.println(
                String.format("The current shell is: %s.", System.getenv("port")));

        // System.out.println("port"+port);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://avnadmin:AVNS_RE3O2bhYZ_1_6ER7YK7@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                    "sqluser", "password");

            /*
             * conn =
             * DriverManager.getConnection("jdbc:mysql://"+user+":"+password+"@"+host+":"+
             * port+"/"+databaseName+"?ssl-mode=REQUIRED", user, password);
             */
            Statement sta = conn.createStatement();

            // random userID
            Random rand = new Random();
            int id = rand.nextInt(1000);
            //
            String userIdVal = "u" + id;
            String ur = u.getUserName();
            String ad = u.getAddress();

            String reset = "INSERT INTO user(userId, username, address) VALUES(?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(reset)) {
                pst.setString(1, userIdVal);
                pst.setString(2, ur);
                pst.setString(3, ad);
                pst.executeUpdate();
            }
            System.out.println("Display data from database: ");

            sta.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connecion");
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
