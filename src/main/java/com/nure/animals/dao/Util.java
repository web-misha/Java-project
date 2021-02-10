package com.nure.animals.dao;

import java.sql.*;
import static java.lang.System.*;


public class Util {
	final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
    final String USER = "root";
    final String PASS = "misha2002";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex){
            out.println("Connection failed...");
            out.println(ex);
        }
        return conn;
    }
}