package com.example.servingwebcontent.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;

import com.example.servingwebcontent.ListUser;
import com.example.servingwebcontent.User;
import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class userAiven {

    ArrayList<User> items = new ArrayList<User>(); 
    //User user = new User();

    /**
     * @return
     */
    public ArrayList<User> userAivenList() {
      
        Connection conn = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://avnadmin:AVNS_RE3O2bhYZ_1_6ER7YK7@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                    "sqluser", "password");
            Statement sta = conn.createStatement();

            ResultSet setdata = sta.executeQuery("select * from user");
            int index =0;
            int columnCount = setdata.getMetaData().getColumnCount();
             System.out.println("column #"+columnCount);
   
          

            while (setdata.next()) {
                User user = new User();
              
                String userID = setdata.getString("userId");
           
                String username = setdata.getString("username");
          
                String address = setdata.getString("address");
                System.out.println("USER AIVEN TEST:");
                System.out.println(userID + " " + username + " " + address);

                user.setUserID(userID);
                user.setUserName(username);
                user.setAddress(address);

                System.out.println("Get username in user Aiven");
                System.out.println(user.getUserName());
                System.out.println(index);
                

        
            items.add(user);
       }

            setdata.close();
            sta.close();
            conn.close();
           
        } 
        catch (Exception e) {
            System.out.println("Error in database connecion");
            System.out.println(e);
            e.printStackTrace();
        }

        
        return items;

    }
    
}

