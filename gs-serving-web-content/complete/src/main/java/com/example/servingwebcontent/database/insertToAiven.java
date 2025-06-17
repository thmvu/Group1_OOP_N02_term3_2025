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

            conn = DiriverManager.getConnection()
        }
    }
}
