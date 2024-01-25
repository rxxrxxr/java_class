package org.example.mh;

import org.example.DBINFO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDB {
    public void insert(Member member) {
        try {
            Connection con
                    = DriverManager.getConnection(DBINFO.url,DBINFO.user,DBINFO.password);
            PreparedStatement pstmt
                    = con.prepareStatement("insert into member " +
                    "(reg_time, update_time, created_by, modified_by," +
                    " address, email, name, password, role) " +
                    "values " +
                    "(now(),now(),'',''," +
                    "?,?,?,?,'admin')");
            pstmt.setString(1, member.getAddr());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getPassword());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("정상종료");

    }

    public boolean findByEmail(String email){
        try {
            Connection con = DriverManager.getConnection(DBINFO.url,DBINFO.user,DBINFO.password);
            PreparedStatement pstmt = con.prepareStatement("SELECT * from member where email=?");
            pstmt.setString(1,email);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // 행이 있으면
        return true;
        // 행이 없으면
        return false;
    }

}
