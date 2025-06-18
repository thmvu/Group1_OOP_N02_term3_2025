package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class aivenConnection {
    private static final String URL = "jdbc:mysql://mysql-eee7f4a-minhvu6723.g.aivencloud.com:14771/defaultdb?ssl-mode=REQUIRED";
        private static final String USER = "avnadmin";
        private static final String PASSWORD = "AVNS_U7GdPSqWnwNiHeo_OK3";

    // Giải pháp 1: Ném lỗi ra ngoài để DAO xử lý
        public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
