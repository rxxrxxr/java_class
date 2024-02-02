package org.example.member;

import org.example.DBINFO;

import java.sql.*;

public class MemberDB {
    private MemberCLI cli = new MemberCLI();

    // too many connection...
    // Mysql 실시간 모든 연결...

    // 회원정보를 데이터베이스에 추가하는 메서드
    public void insert() {
        Member member = cli.inputMember();

        boolean result = findByEmail(member.getEmail()); // 동일한 이메일인지를 찾는다

        if(!result) { // 동일한 이메일이 존재하지 않으면 데이터베이스와 연결
            Connection con = null;

            try {
                // DB 연결하기
                con = DriverManager.getConnection(DBINFO.url, DBINFO.user, DBINFO.password);

                // SQL 구문 작성하고...
                PreparedStatement pstmt
                        = con.prepareStatement("insert into member " +
                        "(reg_time, update_time, created_by, modified_by," +
                        " address, email, name, password, role) " +
                        "values " +
                        "(now(),now(),'',''," +
                        "?,?,?,?,'user')");

                pstmt.setString(1, member.getAddr());
                pstmt.setString(2, member.getEmail());
                pstmt.setString(3, member.getName());
                pstmt.setString(4, member.getPassword());
                // SQL 구문실행하기
                pstmt.executeUpdate();
                System.out.println("입력되었습니다.");

            } catch (Exception e) {
                System.out.println("이쪽으로 온다.");
                e.printStackTrace();
            }
            finally {
                if(con!=null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else{
            System.out.println("중복되어서 회원가입 실패");
        }
    }

    public boolean findByEmail(String email){
        try{
            // DB 연결하기
            Connection con
                    = DriverManager.getConnection(DBINFO.url,DBINFO.user,DBINFO.password);
            PreparedStatement pstmt =
                    con.prepareStatement("SELECT * from member where email=?"); // member 테이블에서 email찾기 쿼리문
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Member login() { // 로그인 메서드
        Member member = cli.loginMember(); // 이메일과 비밀번호를 입력받는다
        try{ // DB연결
            Connection con
                    = DriverManager.getConnection(DBINFO.url,DBINFO.user,DBINFO.password);
            PreparedStatement pstmt = con.prepareStatement(
                    "SELECT * FROM member " +
                         "WHERE email=? AND PASSWORD=?"); // 이메일과 패스워드를 찾는 쿼리문
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                member.setRole(rs.getString("role")); // DB에 존재하는 정보일때 member객체에 role을 가져와 설정한다
                return member;
            }else{
                System.out.println("로그인실패 이메일과 패스워드를 확인하세요...");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}