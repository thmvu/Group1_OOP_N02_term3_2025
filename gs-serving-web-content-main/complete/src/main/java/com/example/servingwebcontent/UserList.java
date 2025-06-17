package com.example.servingwebcontent;

import java.util.ArrayList;

public class UserList {
    private static UserList instance;

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User u) {
        users.add(u);
        System.out.println("Da them user: " + u.getUserID());
    }

    public User getUserInfo(String userId) {
        for (User u : users) {
            if (u.getUserID().equals(userId)) {
                return u;
            }
        }
        System.out.println("Khong tim thay user voi ID: " + userId);
        return null;
    }

    public boolean getEditUser(String newName, String userId) {
        for (User u : users) {
            if (u.getUserID().equals(userId)) {
                u.setFullName(newName);
                System.out.println("Da cap nhat ten user " + userId + " thanh: " + newName);
                return true;
            }
        }
        System.out.println("Khong tim thay user de sua.");
        return false;
    }

    public boolean getDeleteUser(String userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserID().equals(userId)) {
                users.remove(i);
                System.out.println("Da xoa user co ID: " + userId);
                return true;
            }
        }
        System.out.println("Khong tim thay user de xoa.");
        return false;
    }

    public void printUserList() {
        System.out.println("----- Danh sach user -----");
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("-------------------------");
    }

    public ArrayList<User> searchUsername(String userID){
        ArrayList<User> newList = new ArrayList<>();
        for (User u : users){
            if (u.getUserID().contains(userID)) {
                newList.add(u);
            }
        }
        return newList;
    }

    // ✅ THÊM PHẦN NÀY
    public Customer getCustomerInfo(String customerId) {
        for (User u : users) {
            if (u instanceof Customer && u.getUserID().equals(customerId)) {
                return (Customer) u;
            }
        }
        System.out.println("Khong tim thay customer voi ID: " + customerId);
        return null;
    }
}
