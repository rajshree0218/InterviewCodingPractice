package org.example.SystemDesign.lowLevelDesign._01_creationalDesignPatterns.objectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    Connection mysqlConnection;
    DBConnection(){
        try {
            mysqlConnection = DriverManager.getConnection("url", "username", "password");
        } catch (Exception e){
            // handle exception here
        }
    }
}
