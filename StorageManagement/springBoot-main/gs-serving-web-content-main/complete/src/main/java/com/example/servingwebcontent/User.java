package com.example.servingwebcontent;


public class User {
    String userName;
    String address;
    String userID;
   
    public String getUserID(){
        return userID;
    }

    public void setUserID(String uid){
        this.userID = uid;
    }
    
    public String getAddress(){
        return address;
    };

    public void setAddress(String add){
        this.address = add;

    }

    public String getUserName(){
        return userName;

    }

    public void setUserName(String name){
        this.userName = name;

    }

    public void printUserName(User u){
        System.out.println("Submited Name:");
        System.out.println(u.userName);
    }
   
   
}
