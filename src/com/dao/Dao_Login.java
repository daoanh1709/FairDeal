/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nhhao
 */
public class Dao_Login {

    public static Connection conn;
    private static PreparedStatement ps;

    public Dao_Login() {
        try {
            System.out.println("Hello");
            conn = DBConnection.getConnection();
            System.out.print("Connect!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String adminlogin(String usename, String password) {
        try {
            ps = conn.prepareCall("{call Adminlogin(?,?)}");
            ps.setString(1, usename);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("result");
            }
            return null;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static String employeeslogin(String usename, String password) {
        try {
            ps = conn.prepareCall("{call Employeeslogin(?,?)}");
            ps.setString(1, usename);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("result");
            }
            return null;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
