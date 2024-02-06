package org.example;

import org.example.enums.Role;

import java.sql.*;

public class Enum_Study_DB {
    public void insert() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/gcw", "gcw", "1234");
            pstmt = con.prepareStatement("insert into enum_study " + "(role) " + "values " + "(?)");
            pstmt.setString(1, Role.ADMIN.toString()); // setString 은 홀따옴표가 들어간다 숫자일때는 setLong을 써야한다
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void select() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/gcw", "gcw", "1234");
            pstmt = con.prepareStatement("select * from enum_study");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getLong("id") + "\t");
                System.out.println(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                con.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/gcw", "gcw", "1234");
            pstmt = con.prepareStatement("UPDATE enum_study " + "SET ROLE = 'USER' " + "WHERE id = ?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.38/gcw", "gcw", "1234");
            pstmt = con.prepareStatement("DELETE from enum_study WHERE id = ?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
