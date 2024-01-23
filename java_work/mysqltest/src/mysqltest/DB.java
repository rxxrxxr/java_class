package mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

	public void insert(String board_title, String board_contents) {
		System.out.println("게시물이 등록되었습니다");

		try {
			// 연결하기...
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			// SQL 구문 작성하기...
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO board" + 
															"(board_title, board_contents)" + 
															"VALUES" + 
															"(?,?)");
			pstmt.setString(1, board_title);
			pstmt.setString(2, board_contents);
			// SQL 구문 실행하기...
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void select() {
		System.out.println("DB에 할일목록 보여주기");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT 할일 FROM todo");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(""));
				System.out.println(rs.getString("할일"));
				System.out.println(rs.getString("상태"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
