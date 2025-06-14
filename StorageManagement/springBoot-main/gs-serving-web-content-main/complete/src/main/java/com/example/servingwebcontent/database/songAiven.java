package com.example.servingwebcontent.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;

import com.example.servingwebcontent.ListUser;
import com.example.servingwebcontent.User;
import com.example.servingwebcontent.Song;
import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class songAiven {

    public songAiven(){}

    /*
     * to do
     * mapping database data to Model Song
     */

    ArrayList<Song> items = new ArrayList<Song>(); 
  

    /**
     * @return
     */
    public ArrayList<Song> songAivenList() {
      
        Connection conn = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://avnadmin:AVNS_RE3O2bhYZ_1_6ER7YK7@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                    "sqluser", "password");
            Statement sta = conn.createStatement();

            ResultSet setdata = sta.executeQuery("select * from song limit 10");
            int index =0;
            int columnCount = setdata.getMetaData().getColumnCount();
             System.out.println("column #"+columnCount);
   
          

            while (setdata.next()) {
                Song song = new Song();
              
                String songID = setdata.getString("songID");
           
                String songName = setdata.getString("songName");
          
                String songAuthor = setdata.getString("songAuthor");

                String country = setdata.getString("country");

                System.out.println("Song AIVEN TEST:");
                System.out.println(songID + " " + songName + " " + songAuthor);

                song.setSongID(songID);
                song.setSongName(songName);
                song.setSongAuthor(songAuthor);
                song.setSongCountry(country);


                System.out.println("Get SONG in song Aiven");
                System.out.println(song.getSongName());
                System.out.println(index);
                

        
            items.add(song);
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

