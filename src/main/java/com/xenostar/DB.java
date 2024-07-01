package com.xenostar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.PrimitiveIterator;

public class DB {
    private  static final  String url = "jdbc:mysql://localhost:3306/DatabaseName";
    private  static final  String username = "Username";
    private  static  final  String password = "Password";


    public  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }




}
