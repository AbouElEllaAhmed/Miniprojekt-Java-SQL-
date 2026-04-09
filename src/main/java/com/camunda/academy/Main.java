package com.camunda.academy;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String url = "jdbc:mysql://localhost:3306/miniprojekt";
        String user = "root";
        String password = "Miraschgaogamon1";


        try ( Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Verbindung erfolgreich!");

            //Insert
            String insertSql = "INSERT INTO students (name, email) Values (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1,"Ahmed");
            insertStmt.setString(2, "ahmed@example.com");
            insertStmt.executeUpdate();

            //Select
            String selectSql = "SELECT * FROM students";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()){
                System.out.println(
                                rs.getInt("id") + "|" +
                                rs.getString("name") + "|" +
                                rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}