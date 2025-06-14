package com.example.servingwebcontent;
import java.util.ArrayList;

public class ListUser {
    public void printListUser(ArrayList<User> listUser){
        for(int i =0; i<listUser.size(); i++){
            System.out.println("List user:");
            System.out.println(listUser.get(i).userName);
            System.out.println(listUser.get(i).address);
            System.out.println(listUser.get(i).userID);


        }
    }
    
}
