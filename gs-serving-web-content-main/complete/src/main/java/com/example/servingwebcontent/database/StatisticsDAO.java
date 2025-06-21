package com.example.servingwebcontent.database;

public interface StatisticsDAO {
    int getTotalUsers();
    int getTotalSellers();
    int getTotalCustomers();
    int getTotalProducts();
    int getTotalTransactions();
    double getTotalRevenue();
}
