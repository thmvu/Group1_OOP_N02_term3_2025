package com.example.servingwebcontent;

import java.io.FileWriter;
import java.io.IOException;
//import com.example.servingwebcontent.File;
import java.util.ArrayList;

public class WriteToFile {
    public void ToFile(ArrayList<User> u) {
        try {
            
            int i = u.size() - 1;
            FileWriter writer = new FileWriter("./complete/File/Login.txt", true);
            writer.append("\n");

            writer.write(u.get(i).userName);
            writer.write(u.get(i).address);

            writer.close();
        } catch (IOException e) {
            System.out.println("Error at write to File!");
            e.printStackTrace();
        }

    }
}