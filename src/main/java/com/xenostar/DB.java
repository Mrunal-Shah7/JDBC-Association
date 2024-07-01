package com.xenostar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.PrimitiveIterator;

public class DB {
    private  static final  String url = "jdbc:mysql://localhost:3306/jdbc";
    private  static final  String username = "XENOSTAR7";
    private  static  final  String password = "pmscrm007";


    public  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }




}
